package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.address.AddressDto;
import com.example.rentcarapp.dto.address.CreateAddressRequest;

import java.util.List;

public interface AddressService {

    AddressDto create(AddressDto dto);
    AddressDto update(AddressDto dto);
    AddressDto read(long id);
    void delete(AddressDto dto);
    List<AddressDto> readAll();




}
