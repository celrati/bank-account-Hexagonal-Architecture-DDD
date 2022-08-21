package com.bankaccount.demo.domain;


import com.bankaccount.demo.domain.mappers.TransactionMapper;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
