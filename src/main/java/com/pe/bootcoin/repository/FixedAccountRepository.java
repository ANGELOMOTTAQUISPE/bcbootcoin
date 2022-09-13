package com.pe.bootcoin.repository;

import com.pe.bootcoin.model.balancecuenta;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedAccountRepository extends ReactiveMongoRepository<balancecuenta, String>{

}