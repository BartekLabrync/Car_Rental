package com.example.rentcarapp.services.address;

import com.example.rentcarapp.dto.address.AddressDto;
import com.example.rentcarapp.dto.address.CreateAddressRequest;
import com.example.rentcarapp.dto.address.UpdateAddressRequest;

import java.util.List;

public interface AddressService {

    AddressDto create(CreateAddressRequest dto);
    AddressDto update(UpdateAddressRequest dto);
    AddressDto read(long id);
    void delete(long id);
    List<AddressDto> readAll();




}
