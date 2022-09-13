package com.pe.bootcoin.repository;

import com.pe.bootcoin.model.balanceCuentaMongo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountRepository extends ReactiveMongoRepository<balanceCuentaMongo, String>{

}
