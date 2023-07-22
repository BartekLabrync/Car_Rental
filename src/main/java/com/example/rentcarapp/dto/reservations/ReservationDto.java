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
