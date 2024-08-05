package com.dossantos.hexagonal.adapters.out;

import com.dossantos.hexagonal.adapters.out.repository.CustomerRepository;
import com.dossantos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.dossantos.hexagonal.application.core.domain.Customer;
import com.dossantos.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository CustomerRepository;
    private final CustomerEntityMapper CustomerEntityMapper;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = CustomerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
