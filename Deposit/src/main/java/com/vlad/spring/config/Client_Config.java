package com.vlad.spring.config;

import com.vlad.spring.Dao.Client_Repository;
import com.vlad.spring.Entity.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Client_Config {
    @Bean
    CommandLineRunner commandLineRunner1(Client_Repository repository){
        return args -> {
            Client client = new Client("Walter White",200000.0);
            repository.saveAll(
                    List.of(client)
            );
        };
    }
}
