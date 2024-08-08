package com.dossantos.hexagonal.application.ports.in;

import com.dossantos.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
