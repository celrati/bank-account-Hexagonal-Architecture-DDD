package com.bankaccount.demo;

import com.bankaccount.demo.application.ClientController;
import com.bankaccount.demo.domain.ClientRepository;
import com.bankaccount.demo.domain.DomainClientService;
import com.bankaccount.demo.infrastructure.H2ClientRepository;
import com.bankaccount.demo.infrastructure.ImportedClientJpaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.*")
@ComponentScan(basePackages = { "com.*" })
@EntityScan("com.*")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
