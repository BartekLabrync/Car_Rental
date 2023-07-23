package com.example.rentcarapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "returnCar")
public class ReturnCar {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     @OneToOne
     private User employee;
     private LocalDate dateOfReturn;
     private String additionalFees;
     private String comments;
     @OneToOne
     private Reservations reservation;

}
