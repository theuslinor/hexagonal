package com.dossantos.hexagonal.config;

import com.dossantos.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.dossantos.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerById(
            FindCustomerByIdOutputPort findCustomerByIdOutputPort
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdOutputPort);
    }

}
