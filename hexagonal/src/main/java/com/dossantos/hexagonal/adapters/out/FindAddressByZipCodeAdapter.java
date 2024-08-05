package com.dossantos.hexagonal.adapters.out;

import com.dossantos.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.dossantos.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.dossantos.hexagonal.application.core.domain.Address;
import com.dossantos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {


    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
