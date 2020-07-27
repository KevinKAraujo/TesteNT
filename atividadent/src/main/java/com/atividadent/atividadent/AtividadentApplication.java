package com.atividadent.atividadent;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages="ativaden.model")//Aqui fara escaniamento das entidades, colocamos o nome do nosso pacote com a classe.
@EnableJpaRepositories(basePackages= {"atividadent.repository"})
@EnableTransactionManagement


public class AtividadentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadentApplication.class, args);
		
		
	}
	
}
