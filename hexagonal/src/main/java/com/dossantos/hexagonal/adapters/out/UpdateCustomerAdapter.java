package com.dossantos.hexagonal.adapters.out;

import com.dossantos.hexagonal.adapters.out.repository.CustomerRepository;
import com.dossantos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dossantos.hexagonal.application.core.domain.Customer;
import com.dossantos.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
