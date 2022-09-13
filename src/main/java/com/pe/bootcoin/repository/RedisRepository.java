package com.pe.bootcoin.repository;

import com.pe.bootcoin.model.AccountRedis;
import com.pe.bootcoin.model.balanceCuentaMongo;

import java.util.Map;

public interface RedisRepository {

  Map<String, AccountRedis> findAll();
  balanceCuentaMongo findById(String id);
  void save(AccountRedis student);
  void delete(String id);

}
