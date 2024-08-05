package com.dossantos.hexagonal.application.ports.in;

import com.dossantos.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
