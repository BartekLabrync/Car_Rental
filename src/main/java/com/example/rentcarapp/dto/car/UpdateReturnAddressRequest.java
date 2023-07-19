package com.example.rentcarapp.dto.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReturnAddressRequest {


    private long id;
    private long postCoda;
    private String street;
}

