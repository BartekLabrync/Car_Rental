package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.user.CreateUserRequest;
import com.example.rentcarapp.dto.user.UpdateUserRequest;
import com.example.rentcarapp.dto.user.UserDto;
import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.models.User;
import com.example.rentcarapp.repositories.BranchRepository;
import com.example.rentcarapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BranchRepository branchRepository;


    public List<UserDto> getAllUsers () {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById (@PathVariable long id) {
        return userRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public UserDto createUser (CreateUserRequest createUserRequest) {
        User user = toModel(createUserRequest);
        user = userRepository.save(user);
        return convertToDto(user);
    }

    public UserDto updateUser (UpdateUserRequest updateUserRequest) {
        User user = this.convertToEntity(updateUserRequest);
        user = userRepository.save(user);
        return this.convertToDto(user);
    }

    public void deleteUser (Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }


    public UserDto convertToDto (User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setBranchId(user.getBranch());
        //dto.setAddressId(user.getAddressId());
        return dto;
    }

    public User convertToEntity (UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setBranch(dto.getBranchId());
        //user.setAddressId(dto.getAddressId());
        return user;
    }

    public User toModel (CreateUserRequest dto) {
        Branch branch = null;
        if(branchRepository.existsById(dto.getBranchId())){
            branch = branchRepository.getReferenceById(dto.getBranchId());
        }
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setBranch(branch);
        //user.setAddressId(dto.getAddressId());
        return user;
    }

    public User convertToEntity (UpdateUserRequest dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        //user.setAddressId(dto.getAddressId());
        return user;
    }



}
