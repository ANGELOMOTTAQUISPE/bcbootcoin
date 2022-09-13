package com.pe.bootcoin.service.impl;

import com.pe.bootcoin.dto.SavingsAccountDto;
import com.pe.bootcoin.dto.entitytodto.entitytodto;
import com.pe.bootcoin.repository.SavingsAccountRepository;
import com.pe.bootcoin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
  
  @Autowired
	private SavingsAccountRepository savingsAccountDao;

	@Override
	public Flux<SavingsAccountDto> findAll() {
		return savingsAccountDao.findAll().map(entitytodto::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> findById(String id) {
		return savingsAccountDao.findById(id).map(entitytodto::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> save(Mono<SavingsAccountDto> savingsAccountDto) {	  
	  return savingsAccountDto.map(entitytodto::dtoToEntity)
				.flatMap(savingsAccountDao::insert)
				.map(entitytodto::entityToDto);
	}

	@Override
	public Mono<SavingsAccountDto> update(Mono<SavingsAccountDto> savingsAccountDto, String id) {
		return savingsAccountDao.findById(id)
				.flatMap(p -> savingsAccountDto
						.map(entitytodto::dtoToEntity)
						.doOnNext(e -> e.setId(id))
				.flatMap(savingsAccountDao::save)
				.map(entitytodto::entityToDto));
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return savingsAccountDao.deleteById(id);
	}

}
