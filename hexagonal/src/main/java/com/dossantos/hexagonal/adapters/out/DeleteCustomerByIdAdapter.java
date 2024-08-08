package com.dossantos.hexagonal.adapters.out;

import com.dossantos.hexagonal.adapters.out.repository.CustomerRepository;
import com.dossantos.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
