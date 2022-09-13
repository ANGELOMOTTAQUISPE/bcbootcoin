package com.pe.bootcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FixedAccountDto {

	private String id;
	private String accountNumber;
	private double balance;
	private Date initialDate;
	private Date endDate;
	private String currency;
	private String holderName;
	private String holderLastName;
	private char status;
	private Date createdAt;
	private Date updatedAt;

}
