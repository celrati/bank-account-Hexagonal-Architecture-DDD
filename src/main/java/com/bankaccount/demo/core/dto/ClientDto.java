package com.bankaccount.demo.core.dto;

import com.bankaccount.demo.core.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private String userName;
    private LocalDate birthDate;
    private double balance;

}
