package com.example.rentcarapp.dto.mainRental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainRentalDto {

    private Long id;
    private String name;
    private String Contact_Address;
    private String Owner;
    private String Logo;
    private String Branch_List;
}
