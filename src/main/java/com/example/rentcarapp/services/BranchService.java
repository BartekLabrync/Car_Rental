package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.branch.BranchDto;
import com.example.rentcarapp.dto.branch.CreateBranchRequest;
import com.example.rentcarapp.dto.branch.UpdateBranchRequest;
import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.repositories.AddressRepository;
import com.example.rentcarapp.repositories.BranchRepository;
import com.example.rentcarapp.repositories.MainRentalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final AddressRepository addressRepository;
    private final MainRentalRepository mainRentalRepository;


    public List<BranchDto> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BranchDto getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public BranchDto createBranch (CreateBranchRequest createBranchRequest) {
        Branch branch = this.toModel(createBranchRequest);
        branch = branchRepository.save(branch);
        return this.toDto(branch);
    }

    public BranchDto updateBranch (long id, UpdateBranchRequest updateBranchRequest) {
        Branch branch = this.toModel(updateBranchRequest);
        branch = branchRepository.save(branch);
        return this.toDto(branch);
    }

    public void deleteBranch (Long id) {
        getBranchById(id);
        branchRepository.deleteById(id);
    }


    public BranchDto toDto(Branch branch) {
        BranchDto dto = new BranchDto();
        dto.setId(branch.getId());
        dto.setAddress(branch.getAddress());
        dto.setStaffList(branch.getStaffList());
        dto.setListOfCurrentlyAvailCars(branch.getListOfCurrentlyAvailCars());
        dto.setMainRental(branch.getMainRental());
        //dto.setReservationId(branch.getReservationId());
        return dto;
    }

    public Branch toModel(BranchDto dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setStaffList(dto.getStaffList());
        branch.setListOfCurrentlyAvailCars(dto.getListOfCurrentlyAvailCars());
        branch.setMainRental(dto.getMainRental());
        //branch.setReservationId(dto.getReservationId());
        return branch;
    }

    public Branch toModel(CreateBranchRequest dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(addressRepository.getReferenceById(dto.getAddress()));
        branch.setStaffList(null);
        branch.setListOfCurrentlyAvailCars(null);
        branch.setMainRental(mainRentalRepository.getReferenceById(dto.getMainRental()));
        //branch.setReservationId(dto.getReservationId());
        return branch;
    }

    public Branch toModel(UpdateBranchRequest dto) {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setStaffList(dto.getStaffList());
        branch.setListOfCurrentlyAvailCars(dto.getListOfCurrentlyAvailCars());
        branch.setMainRental(dto.getMainRental());
        //branch.setReservationId(dto.getReservationId());
        return branch;
    }
}
