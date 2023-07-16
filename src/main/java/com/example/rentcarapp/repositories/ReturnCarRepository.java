package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.ReturnCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReturnCarRepository extends JpaRepository <ReturnCar,Long> {
}
