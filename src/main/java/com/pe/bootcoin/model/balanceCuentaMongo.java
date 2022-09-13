package com.pe.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("balance_cuenta_mongo")
public class balanceCuentaMongo extends Account {

    @Field("bank_account_code")
    private String bankAccountCode;

    @Field("balance")
    private double balance;

}
