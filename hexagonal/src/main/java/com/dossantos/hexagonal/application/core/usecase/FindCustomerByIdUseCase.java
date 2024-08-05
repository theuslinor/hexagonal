package com.dossantos.hexagonal.application.core.usecase;

import com.dossantos.hexagonal.application.core.domain.Customer;
import com.dossantos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.dossantos.hexagonal.application.ports.out.FindCustomerByIdOutputPort;


public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;


    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer find(String id) {
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
