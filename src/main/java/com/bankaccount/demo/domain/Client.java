package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.mappers.TransactionMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private LocalDate birthDate;
    private double balance;
    //private List<Transaction> transactionList;

    public void deposit(double amount) {
        //transactionList.add(TransactionMapper.transactionBuild(id, amount));
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if(balance >= amount) {
            //transactionList.add(TransactionMapper.transactionBuild(id, -amount));
            balance = balance - amount;
        }else {
            // we need to throw an exception..
        }

    }

    public void getHistory() {
        System.out.println("test info");
    }



}
