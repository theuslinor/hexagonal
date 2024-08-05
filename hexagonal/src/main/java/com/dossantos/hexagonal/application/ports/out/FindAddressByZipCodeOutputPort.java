package com.dossantos.hexagonal.application.ports.out;

import com.dossantos.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
