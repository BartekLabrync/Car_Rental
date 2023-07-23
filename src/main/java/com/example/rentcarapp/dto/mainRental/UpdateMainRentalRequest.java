package com.example.rentcarapp.dto.mainRental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMainRentalRequest {

    private Long id;
    private String name;
    private long Contact_Address;
    private String Owner;
    private String Logo;
    //private String Branch_List;
}
