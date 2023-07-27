package com.example.rentcarapp.dto.user;

import com.example.rentcarapp.models.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private Branch branchId;
    private long addressId;

}
