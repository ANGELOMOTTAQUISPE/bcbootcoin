package com.pe.bootcoin.service;

import com.pe.bootcoin.config.events.Event;
import com.pe.bootcoin.config.events.EventType;
import com.pe.bootcoin.config.events.SavingAccountCreatedEvent;
import com.pe.bootcoin.model.balanceCuentaMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class SavingsAccountServiceEvents {
  
  @Autowired
  private KafkaTemplate<String, Event<?>> producer;
  
  @Value("${topic.customer.name:bootcoin}")
  private String topicSaving;
  
  public void publish(balanceCuentaMongo savingAccount) {
    
    SavingAccountCreatedEvent created = new SavingAccountCreatedEvent();
    created.setData(savingAccount);
    created.setId(UUID.randomUUID().toString());
    created.setType(EventType.CREATED);
    created.setDate(new Date());
    
    this.producer.send(topicSaving, created);
    
  }

}
