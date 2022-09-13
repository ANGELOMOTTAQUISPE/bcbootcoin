package com.pe.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Account {

    @Id
    private String id;

    @Field("account_number")
    private String accountNumber;

    @Field("available_balance")
    private double availableBalance;

    @Field("currency")
    private String currency;

    @Field("holder_name")
    private String holderName;

    @Field("holder_last_name")
    private String holderLastName;

    @Field("status")
    private char status;



}