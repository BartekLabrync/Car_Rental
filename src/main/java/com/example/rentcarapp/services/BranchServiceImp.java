package com.example.rentcarapp.services;

import com.example.rentcarapp.repositories.BranchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class BranchServiceImp implements BranchService{

    private final BranchRepository branchRepository;


    public BranchServiceImp(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

}
