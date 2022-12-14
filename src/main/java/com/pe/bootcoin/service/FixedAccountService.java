package com.pe.bootcoin.service;

import com.pe.bootcoin.dto.FixedAccountDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FixedAccountService {

	public Flux<FixedAccountDto> findAll();

	public Mono<FixedAccountDto> findById(String id);

	public Mono<FixedAccountDto> save(Mono<FixedAccountDto> fixedAccountDto);

	public Mono<FixedAccountDto> update(Mono<FixedAccountDto> fixedAccountDto, String id);

	public Mono<Void> deleteById(String id);

}