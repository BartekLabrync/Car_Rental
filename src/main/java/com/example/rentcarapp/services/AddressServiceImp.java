package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.car.AddressDto;
import com.example.rentcarapp.models.Address;
import com.example.rentcarapp.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImp implements AddressService{
    private final AddressRepository addressRepository;

    @Override
    public void selectAddress(AddressDto dto){
        var model=toModel(dto);
        //return;

    }

      private Address toModel(AddressDto dto){
        return Address
                .builder()
                .id(dto.getId())
                .postCoda(dto.getPostCoda())
                .street(dto.getStreet())
                .build();
    }



    }





