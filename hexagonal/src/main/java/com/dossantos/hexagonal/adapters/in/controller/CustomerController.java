package com.dossantos.hexagonal.adapters.in.controller;

import com.dossantos.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.dossantos.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.dossantos.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.dossantos.hexagonal.application.core.domain.Customer;
import com.dossantos.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.dossantos.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.dossantos.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.dossantos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final CustomerMapper customerMapper;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest  customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
