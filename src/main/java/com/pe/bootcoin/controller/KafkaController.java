package com.pe.bootcoin.controller;

import com.pe.bootcoin.model.balanceCuentaMongo;
import com.pe.bootcoin.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final SavingsService kafkaStringProducer;

    @Autowired
    KafkaController(SavingsService kafkaStringProducer) {
        this.kafkaStringProducer = kafkaStringProducer;
    }

    /*
        @PostMapping(value = "/publish")
        public Mono<Client> sendMessageToKafkaTopic(@RequestBody Client message) {
            this.kafkaStringProducer.sendMessage(message);
            return Mono.just(message);
        }*/
    @PostMapping(value = "/publish")
    public balanceCuentaMongo save(@RequestBody balanceCuentaMongo savingService) {
        return this.kafkaStringProducer.save(savingService);
    }
}
