package com.dossantos.hexagonal.application.ports.out;

import com.dossantos.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
