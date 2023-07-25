package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.branch.BranchDto;
import com.example.rentcarapp.dto.branch.CreateBranchRequest;
import com.example.rentcarapp.dto.branch.UpdateBranchRequest;
import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<BranchDto> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public BranchDto getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public BranchDto createBranch (CreateBranchRequest createBranchRequest) {
        Branch branch = this.fromConvertToEntity(createBranchRequest);
        branch = branchRepository.save(branch);
        return this.convertToDto(branch);
    }

    public BranchDto updateBranch (long id, UpdateBranchRequest updateBranchRequest) {
        Branch branch = this.convertToEntity(updateBranchRequest);
        branch = branchRepository.save(branch);
        return this.convertToDto(branch);
    }

    public void deleteBranch (Long id) {
        getBranchById(id);
        branchRepository.deleteById(id);
    }


    public BranchDto convertToDto(Branch branch) {
        BranchDto dto = new BranchDto();
        dto.setId(branch.getId());
        dto.setAddress(branch.getAddress());
        dto.setStaffList(branch.getStaffList());
        dto.setListOfCurrentlyAvailCars(branch.getListOfCurrentlyAvailCars());
        dto.setMainRental(branch.getMainRental());
        dto.setReservationId(branch.getReservationId());
        return dto;
    }

    public Branch convertToEntity(BranchDto dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setStaffList(dto.getStaffList());
        branch.setListOfCurrentlyAvailCars(dto.getListOfCurrentlyAvailCars());
        branch.setMainRental(dto.getMainRental());
        branch.setReservationId(dto.getReservationId());
        return branch;
    }

    public Branch fromConvertToEntity(CreateBranchRequest dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setStaffList(dto.getStaffList());
        branch.setListOfCurrentlyAvailCars(dto.getListOfCurrentlyAvailCars());
        branch.setMainRental(dto.getMainRental());
        branch.setReservationId(dto.getReservationId());
        return branch;
    }

    public Branch convertToEntity(UpdateBranchRequest dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setStaffList(dto.getStaffList());
        branch.setListOfCurrentlyAvailCars(dto.getListOfCurrentlyAvailCars());
        branch.setMainRental(dto.getMainRental());
        branch.setReservationId(dto.getReservationId());
        return branch;
    }
}
