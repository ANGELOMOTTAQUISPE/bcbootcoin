package com.pe.bootcoin.service.impl;

import com.pe.bootcoin.dto.FixedAccountDto;
import com.pe.bootcoin.dto.entitytodto.entitytodto;
import com.pe.bootcoin.repository.FixedAccountRepository;
import com.pe.bootcoin.service.FixedAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FixedAccountServiceImpl implements FixedAccountService {

	@Autowired
	private FixedAccountRepository fixedAccountDao;

	@Override
	public Flux<FixedAccountDto> findAll() {
		return fixedAccountDao.findAll().map(entitytodto::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> findById(String id) {
		return fixedAccountDao.findById(id).map(entitytodto::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> save(Mono<FixedAccountDto> fixedAccountDto) {
		return fixedAccountDto.map(entitytodto::dtoToEntity)
				.flatMap(fixedAccountDao::insert).map(entitytodto::entityToDto);
	}

	@Override
	public Mono<FixedAccountDto> update(Mono<FixedAccountDto> fixedAccountDto, String id) {
		return fixedAccountDao.findById(id)
				.flatMap(p -> fixedAccountDto.map(entitytodto::dtoToEntity)
						.doOnNext(e -> e.setId(id))
				.flatMap(fixedAccountDao::save).map(entitytodto::entityToDto));
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return fixedAccountDao.deleteById(id);
	}

}
