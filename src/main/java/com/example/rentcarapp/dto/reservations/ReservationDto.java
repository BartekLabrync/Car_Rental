package com.example.rentcarapp.dto.reservations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long id;

    private LocalDate reservDate;

    private Long clientId;

    private Long carId;

    private LocalDate dateFor;

    private LocalDate dateTo;

    private Long reservBranchId;

    private Long branchReturnId;

    private BigDecimal amount;

    private Long parentId;

}
