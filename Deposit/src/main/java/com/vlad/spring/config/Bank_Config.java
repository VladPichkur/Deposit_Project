package com.vlad.spring.config;

import com.vlad.spring.Dao.Bank_Repository;
import com.vlad.spring.Entity.Bank;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Bank_Config {
    @Bean
    CommandLineRunner commandLineRunner(Bank_Repository repository){
        return args -> {
            Bank bank1 = new Bank("Los Pollos Hermanos");
            Bank bank2 = new Bank("Приват банк");
            Bank bank3 = new Bank("Albuquerque Bank");
            repository.saveAll(
                    List.of(bank1,bank2,bank3)
            );
        };
    }
}
