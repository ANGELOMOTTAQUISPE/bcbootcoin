package com.pe.bootcoin.repository;

import com.pe.bootcoin.model.AccountRedis;
import com.pe.bootcoin.model.balanceCuentaMongo;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class SavingsAccountRedisRepository implements RedisRepository{

  private static final String KEY = "bankredisbootcamp";
  private RedisTemplate<String, AccountRedis> redisTemplate;
  private HashOperations hashOperations;
    
  public SavingsAccountRedisRepository(RedisTemplate<String, AccountRedis> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @PostConstruct
  private void init() {
      hashOperations = redisTemplate.opsForHash();
  }
  
  @Override
  public Map<String, AccountRedis> findAll() {
    return hashOperations.entries(KEY);
  }

  @Override
  public balanceCuentaMongo findById(String id) {
    return (balanceCuentaMongo) hashOperations.get(KEY, id);
  }

  @Override
  public void save(AccountRedis accountRedis) {
    hashOperations.put(KEY, UUID.randomUUID().toString(), accountRedis);
  }

  @Override
  public void delete(String id) {
    hashOperations.delete(KEY, id);    
  }

}
