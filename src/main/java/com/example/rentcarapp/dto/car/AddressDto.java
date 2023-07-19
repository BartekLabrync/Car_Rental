package com.example.rentcarapp.dto.car;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses")
public class AddressDto {

    private long id;
    private long postCoda;
    private String street;}

