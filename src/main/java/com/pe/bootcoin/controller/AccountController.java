package com.pe.bootcoin.controller;

import com.pe.bootcoin.model.AccountRedis;
import com.pe.bootcoin.model.balanceCuentaMongo;
import com.pe.bootcoin.repository.SavingsAccountRedisRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AccountController {
  private SavingsAccountRedisRepository savingRepository;
  
  public AccountController(SavingsAccountRedisRepository savingRepository) {
    this.savingRepository = savingRepository;
  }
  
  @GetMapping("/redis")
  public Map<String, AccountRedis> findAll() {
      return savingRepository.findAll();
  }

  @GetMapping("/redis/{id}")
  public balanceCuentaMongo findById(@PathVariable String id) {
      return savingRepository.findById(id);
  }

  @PostMapping("/redis")
  public void createStudent(@RequestBody AccountRedis student) {
    savingRepository.save(student);
  }

  @DeleteMapping("/redis/{id}")
  public void deleteStudent(@PathVariable String id) {
    savingRepository.delete(id);
  }

}
