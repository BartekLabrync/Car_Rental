package com.example.rentcarapp.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAddressRequest {


    private long id;
    private String postCode;
    private String street;
}
