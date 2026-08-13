package com.portfolio.anshul_portforlio;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfiguration {

    @Bean
     ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
