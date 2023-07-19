package com.example.rentcarapp.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "branches")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branchId")
    private List<User> staffList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "branchId")
    private List<Car>  listOfCurrentlyAvailCars;

    //???private long reservationId;
}