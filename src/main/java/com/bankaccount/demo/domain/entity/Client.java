package com.bankaccount.demo.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = "transactionList")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private double balance;

    @OneToMany(mappedBy="client")
    private List<Transaction> transactionList;



}
