package com.example.rentcarapp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private long addressId;
}
