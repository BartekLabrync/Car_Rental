package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.branch.AvailableCars;
import com.example.rentcarapp.dto.branch.NewBranchDto;
import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.models.Car;

import java.util.List;

public interface BranchService {
    void addBranch(NewBranchDto dto);
    AvailableCars getAvailableCars(Branch model);
}
