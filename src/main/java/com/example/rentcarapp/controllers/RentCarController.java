package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.car.CreateCarRequest;
import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.dto.rentCar.UpdateRentCarRequest;
import com.example.rentcarapp.models.RentCar;
import com.example.rentcarapp.services.AddressService;
import com.example.rentcarapp.services.RentCarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("/rentCar")
@AllArgsConstructor
public class RentCarController {
    private final RentCarService rentCarService;

    @GetMapping("{id}")
    public ResponseEntity<RentCarDto> getRentCar(@PathVariable long id) {
//        log.info();
        RentCarDto rentCarById = rentCarService.read(id);
        return ResponseEntity.ok(rentCarById);
    }
    @GetMapping
    public ResponseEntity<List<RentCarDto>> getAllRentCars() {
        List<RentCarDto> rentCars = rentCarService.readAll();
        return ResponseEntity.ok(rentCars);
    }
    @PutMapping("{id}")
    public ResponseEntity<RentCarDto> updateRentCar (@RequestBody UpdateRentCarRequest updateRentCarRequest){
        rentCarService.update(updateRentCarRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RentCarDto> createRentCar (@RequestBody CreateRentCarRequest createRentCarRequest){
        RentCarDto rentCarDto = rentCarService.create(createRentCarRequest);
        return ResponseEntity.ok(rentCarDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteRentCar (@PathVariable long id){
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRentCar(@PathVariable long id){
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }

}
