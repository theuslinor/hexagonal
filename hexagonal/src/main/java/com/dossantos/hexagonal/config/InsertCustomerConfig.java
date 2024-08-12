package com.dossantos.hexagonal.config;

import com.dossantos.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.dossantos.hexagonal.adapters.out.InsertCustomerAdapter;
import com.dossantos.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.dossantos.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCode,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCode, insertCustomerAdapter, sendCpfValidationAdapter);
    }

}
