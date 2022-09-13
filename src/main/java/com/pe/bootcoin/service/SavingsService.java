package com.pe.bootcoin.service;

import com.pe.bootcoin.model.balanceCuentaMongo;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {
  
  private final SavingsAccountServiceEvents accountServiceEvents;
  
  public SavingsService(SavingsAccountServiceEvents accountServiceEvents) {
    super();
    this.accountServiceEvents = accountServiceEvents;
  }
  
  public balanceCuentaMongo save(balanceCuentaMongo savingAccount) {
    System.out.println("Received " + savingAccount);
    this.accountServiceEvents.publish(savingAccount);
    return savingAccount;
  }

}
