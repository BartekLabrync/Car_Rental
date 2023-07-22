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
    private long clientId;
    private long carId;
    private LocalDate dateFor;
    private LocalDate dateTo;
    private long reservBranchId;
    private long branchReturnId;
    private BigDecimal amount;
    private long parentId;
}
