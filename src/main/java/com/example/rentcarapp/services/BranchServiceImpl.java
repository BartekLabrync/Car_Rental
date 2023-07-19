package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.branch.AvailableCars;
import com.example.rentcarapp.dto.branch.NewBranchDto;
import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.models.Car;
import com.example.rentcarapp.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService{

    private final BranchRepository branchRepository;

    @Override
    public void addBranch(NewBranchDto dto) {
        Branch newBranch = new Branch();
        newBranch.setAddress(dto.getAddress());
        newBranch.setStaffList(Collections.emptyList());
        newBranch.setListOfCurrentlyAvailCars(Collections.emptyList());
        branchRepository.save(newBranch);
    }

    @Override
    public AvailableCars getAvailableCars(Branch model) {
        AvailableCars dto = AvailableCars
                .builder()
                .address(model.getAddress())
                .listOfCurrentlyAvailCars(model.getListOfCurrentlyAvailCars())
                .id(model.getId())
                .build();
        return dto;
    }
}
