package com.example.rentcarapp.services.Address;

import com.example.rentcarapp.dto.address.AddressDto;
import com.example.rentcarapp.dto.address.CreateAddressRequest;
import com.example.rentcarapp.dto.address.UpdateAddressRequest;
import com.example.rentcarapp.models.Address;
import com.example.rentcarapp.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

      private final AddressRepository addressRepository;

   private AddressDto toDto(Address model){
       AddressDto  dto= AddressDto.builder()
               .id(model.getId())
               .postCode(model.getPostCode())
               .street(model.getStreet())
               .build();
       return dto;
   }
    private Address toModel(AddressDto dto ){
        Address  model = Address.builder()
                .id(dto.getId())
                .postCode(dto.getPostCode())
                .street(dto.getStreet())
                .build();
        return model;
   }
   public Address toModel(CreateAddressRequest dto){
       Address model = Address.builder()
               .id(dto.getId())
               .postCode(dto.getPostCode())
               .street(dto.getStreet())
               .build();
       return model;
   }
    public Address toModel(UpdateAddressRequest dto){
        Address model = Address.builder()
                .id(dto.getId())
                .postCode(dto.getPostCode())
                .street(dto.getStreet())
                .build();
        return model;
    }

    @Override
    public AddressDto create(CreateAddressRequest dto) {
        return toDto(addressRepository.save(toModel(dto)));
    }

    @Override
    public AddressDto update(UpdateAddressRequest dto) {
        var model=toModel(dto);
        return toDto(addressRepository.save(model));
    }

    @Override
    public AddressDto read(long id) {
        return addressRepository
                .findById(id)
                .map(this::toDto)
                .orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void delete(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<AddressDto> readAll() {
        return addressRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }
}

