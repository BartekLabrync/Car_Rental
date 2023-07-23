package com.example.rentcarapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "cars")
public class Car {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    private String Brand;

    private String Name;

    private String BodyType;

    private Long Year;

    private String Color;

    private Long Mileage;

    @OneToOne
    private Reservations reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch.id")
    private Branch branchId;
}
