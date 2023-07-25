package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.address.AddressDto;
import com.example.rentcarapp.dto.address.CreateAddressRequest;
import com.example.rentcarapp.dto.address.UpdateAddressRequest;
import com.example.rentcarapp.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable long id){
        AddressDto addressById = addressService.read(id);
        return ResponseEntity.ok(addressById);
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses(){
        List<AddressDto> addresses = addressService.readAll();
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("{id}")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest){
        addressService.update(updateAddressRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody CreateAddressRequest createAddressRequest){
        AddressDto addressDto = addressService.create(createAddressRequest);
        return ResponseEntity.ok(addressDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteAddress(@PathVariable long id){
        addressService.delete(id);
        return ResponseEntity.ok().build();
    }
}
