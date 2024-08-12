package com.dossantos.hexagonal.adapters.in.consumer;

import com.dossantos.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.dossantos.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.dossantos.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceiveValidationCpfConsumer {

    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "dossantos")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
