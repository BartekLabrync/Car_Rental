package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Long> {
}
