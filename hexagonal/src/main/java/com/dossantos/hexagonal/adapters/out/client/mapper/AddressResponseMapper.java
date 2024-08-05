package com.dossantos.hexagonal.adapters.out.client.mapper;

import com.dossantos.hexagonal.adapters.out.client.response.AddressResponse;
import com.dossantos.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
