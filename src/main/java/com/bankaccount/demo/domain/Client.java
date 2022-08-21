package com.bankaccount.demo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
