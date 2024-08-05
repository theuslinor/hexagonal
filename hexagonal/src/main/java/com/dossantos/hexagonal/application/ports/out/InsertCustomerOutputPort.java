package com.dossantos.hexagonal.application.ports.out;

import com.dossantos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
