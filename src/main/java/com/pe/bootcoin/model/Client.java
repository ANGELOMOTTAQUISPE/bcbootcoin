package com.pe.bootcoin.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client implements Serializable {

    @Id
    private String idClient;
    private String name;

    private String documentNumber;
    private String documentType;
    private String phoneNumber;
    private String email;
    private TypeClient typeClient;
}
