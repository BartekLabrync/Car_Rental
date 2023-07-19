package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository <Address, Long> {


}
