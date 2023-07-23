package com.example.rentcarapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate reservDate;

    @OneToOne
    private User client;

    @OneToOne
    private RentCar car;

    private LocalDate dateFor;

    private LocalDate dateTo;

    @OneToOne
    private Branch reservBranch;

    @OneToOne
    private Branch branchReturn;

    private BigDecimal amount;

    private long parentId;
}
