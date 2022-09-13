package com.pe.bootcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("fixed_accounts")
public class balancecuenta extends Account {

    @Field("balance")
    private double balance;

    @Field("initial_date")
    private Date initialDate;

    @Field("end_date")
    private Date endDate;
}