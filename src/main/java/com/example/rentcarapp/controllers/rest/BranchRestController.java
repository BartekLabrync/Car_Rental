package com.example.rentcarapp.controllers.rest;

import com.example.rentcarapp.dto.branch.BranchDto;
import com.example.rentcarapp.dto.branch.CreateBranchRequest;
import com.example.rentcarapp.dto.branch.UpdateBranchRequest;
import com.example.rentcarapp.services.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
@AllArgsConstructor
public class BranchRestController {

    private final BranchService branchService;

    @GetMapping("{id}")
    public ResponseEntity<BranchDto> getBranchById (@PathVariable long id) {
        BranchDto branchById = branchService.getBranchById(id);
        return ResponseEntity.ok(branchById);
    }

    @GetMapping
    public ResponseEntity<List<BranchDto>> getAllBranches () {
        List<BranchDto> branch = branchService.getAllBranches();
        return ResponseEntity.ok(branch);
    }

    @PostMapping
    public ResponseEntity<BranchDto> createBranch (@RequestBody CreateBranchRequest createBranchRequest) {
        BranchDto branchDto = branchService.createBranch(createBranchRequest);
        return ResponseEntity.ok(branchDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<BranchDto> updateBranch (@PathVariable long id, @RequestBody UpdateBranchRequest updateBranchRequest) {
        branchService.updateBranch(id, updateBranchRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBranch (@PathVariable long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok().build();
    }
}
