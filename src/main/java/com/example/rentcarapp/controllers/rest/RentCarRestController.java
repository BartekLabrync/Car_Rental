package com.example.rentcarapp.controllers.rest;

import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.dto.rentCar.UpdateRentCarRequest;
import com.example.rentcarapp.services.rentCar.RentCarService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentCar")
@AllArgsConstructor
public class RentCarRestController {
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

    @PostMapping("/addRentCar")
    public ResponseEntity<RentCarDto> createRentCar (@RequestBody CreateRentCarRequest createRentCarRequest){
        RentCarDto rentCarDto = rentCarService.create(createRentCarRequest);
        return ResponseEntity.ok(rentCarDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteRentCar (@PathVariable long id){
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }


}
