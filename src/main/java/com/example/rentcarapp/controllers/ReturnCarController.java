package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.returnCar.CreateReturnCarRequest;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.dto.returnCar.UpdateReturnCarRequest;
import com.example.rentcarapp.services.ReturnCar.ReturnCarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returnCar")
@AllArgsConstructor
public class ReturnCarController {
    private final ReturnCarService returnCarService;

    @GetMapping("{id}")
    public ResponseEntity<ReturnCarDto> getReturnCar(@PathVariable long id){
        ReturnCarDto returnCarById = returnCarService.read(id);
        return ResponseEntity.ok(returnCarById);
    }
    @GetMapping
    public ResponseEntity<List<ReturnCarDto>> getAllReturnCars(){
        List<ReturnCarDto> returnCars = returnCarService.readAll();
        return ResponseEntity.ok(returnCars);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReturnCarDto> updateReturnCar(@RequestBody UpdateReturnCarRequest updateReturnCarRequest){
       returnCarService.update(updateReturnCarRequest);
       return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ReturnCarDto> createReturnCar(@RequestBody CreateReturnCarRequest createReturnCarRequest) {
        ReturnCarDto returnCarDto = returnCarService.create(createReturnCarRequest);
        return  ResponseEntity.ok(returnCarDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteReturnCar(@PathVariable long id){
        returnCarService.delete(id);
        return ResponseEntity.ok().build();
    }

}
