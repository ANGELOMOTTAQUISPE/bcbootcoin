package com.pe.bootcoin.dto.entitytodto;

import com.pe.bootcoin.dto.FixedAccountDto;
import com.pe.bootcoin.dto.SavingsAccountDto;
import com.pe.bootcoin.model.balancecuenta;
import com.pe.bootcoin.model.balanceCuentaMongo;
import org.springframework.beans.BeanUtils;

public class entitytodto {
    public static SavingsAccountDto entityToDto(balanceCuentaMongo balanceCuentaMongo) {
        SavingsAccountDto savingsAccountDto = new SavingsAccountDto();
        BeanUtils.copyProperties(balanceCuentaMongo, savingsAccountDto);
        return savingsAccountDto;
    }

    public static balanceCuentaMongo dtoToEntity(SavingsAccountDto savingsAccountDto) {
        balanceCuentaMongo balanceCuentaMongo = new balanceCuentaMongo();
        BeanUtils.copyProperties(savingsAccountDto, balanceCuentaMongo);
        return balanceCuentaMongo;
    }

    public static FixedAccountDto entityToDto(balancecuenta balancecuenta) {
        FixedAccountDto fixedAccountDto = new FixedAccountDto();
        BeanUtils.copyProperties(balancecuenta, fixedAccountDto);
        return fixedAccountDto;
    }

    public static balancecuenta dtoToEntity(FixedAccountDto fixedAccountDto) {
        balancecuenta balancecuenta = new balancecuenta();
        BeanUtils.copyProperties(fixedAccountDto, balancecuenta);
        return balancecuenta;
    }
}
