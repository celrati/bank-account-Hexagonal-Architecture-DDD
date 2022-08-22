package com.bankaccount.demo.domain.dto;

import com.bankaccount.demo.domain.entity.Client;
import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "client")
public class TransactionDto {

    private Long id;
    private Long clientID;
    private double amount;

}
