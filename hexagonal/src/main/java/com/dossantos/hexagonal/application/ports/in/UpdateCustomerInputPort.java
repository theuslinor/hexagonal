package com.dossantos.hexagonal.application.ports.in;

import com.dossantos.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
