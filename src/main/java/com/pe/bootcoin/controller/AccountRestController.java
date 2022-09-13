package com.pe.bootcoin.controller;

import com.pe.bootcoin.dto.FixedAccountDto;
import com.pe.bootcoin.dto.SavingsAccountDto;
import com.pe.bootcoin.model.balanceCuentaMongo;
import com.pe.bootcoin.service.FixedAccountService;
import com.pe.bootcoin.service.AccountService;
import com.pe.bootcoin.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {

  @Autowired
  private AccountService accountService;

  @Autowired
  private FixedAccountService fixedAccountService;

  // Savings Account endpoints
  @GetMapping("/savings")
  public Flux<SavingsAccountDto> getAllSavings() {
    return accountService.findAll();
  }

  //@CircuitBreaker(name = "AccountsCB", fallbackMethod = "fallBackGetAccounts")
  @GetMapping("/savings/{id}")
  public Mono<SavingsAccountDto> getSavings(@PathVariable String id) {
    return accountService.findById(id);
  }

  @PostMapping("/savings/save")
  public Mono<SavingsAccountDto> saveSavings(
      @RequestBody Mono<SavingsAccountDto> savingsAccountDto) {
    return accountService.save(savingsAccountDto);
  }

  @PutMapping("/savings/update/{id}")
  public Mono<SavingsAccountDto> updateSavings(
      @RequestBody Mono<SavingsAccountDto> savingsAccountDto,
      @PathVariable String id) {
    return accountService.update(savingsAccountDto, id);
  }

  @DeleteMapping("/savings/delete/{id}")
  public Mono<Void> deleteSavings(@PathVariable String id) {
    return accountService.deleteById(id);
  }

  // Fixed Account endpoints
  @GetMapping("/fixed")
  public Flux<FixedAccountDto> getAllFixed() {
    return fixedAccountService.findAll();
  }

  @GetMapping("/fixed/{id}")
  public Mono<FixedAccountDto> getFixed(@PathVariable String id) {
    return fixedAccountService.findById(id);
  }

  @PostMapping("/fixed/save")
  public Mono<FixedAccountDto> saveFixed(
      @RequestBody Mono<FixedAccountDto> fixedAccountDto) {
    return fixedAccountService.save(fixedAccountDto);
  }

  @PutMapping("/fixed/update/{id}")
  public Mono<FixedAccountDto> updateFixed(
      @RequestBody Mono<FixedAccountDto> fixedAccountDto,
      @PathVariable String id) {
    return fixedAccountService.update(fixedAccountDto, id);
  }

  @DeleteMapping("/fixed/delete/{id}")
  public Mono<Void> deleteFixed(@PathVariable String id) {
    return fixedAccountService.deleteById(id);
  }

  public Mono<SavingsAccountDto> fallBackGetAccounts(
      @PathVariable("id") String id, Throwable e) {
    SavingsAccountDto account = new SavingsAccountDto();
    account.setAccountNumber("El microservicio no esta disponible");

    return Mono.just(account);
  }
  
  //Kafka
  @Autowired
  private final SavingsService savingService;
  
  public AccountRestController(SavingsService savingService) {
    super();
    this.savingService = savingService;
  }
  
  @PostMapping
  public balanceCuentaMongo save(@RequestBody balanceCuentaMongo savingService) {
  return this.savingService.save(savingService);
}

}
