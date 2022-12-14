package com.bankaccount.demo.domain.dto;

import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "transactionList")
public class ClientDto {

    private Long id;
    private String userName;
    private LocalDate birthDate;
    private double balance;

}
