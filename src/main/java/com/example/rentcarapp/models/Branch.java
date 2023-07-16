package com.example.rentcarapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name= "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> staffList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Car>  listOfCurrentlyAvailCars;

    private long reservationId ;
}
