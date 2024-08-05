package com.dossantos.hexagonal.adapters.out;

import com.dossantos.hexagonal.adapters.out.repository.CustomerRepository;
import com.dossantos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dossantos.hexagonal.application.core.domain.Customer;
import com.dossantos.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
