package com.example.rentcarapp.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private long id;
    private String postCode;
    private String street;
}
