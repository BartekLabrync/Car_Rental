package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.branch.BranchDto;
import com.example.rentcarapp.dto.branch.CreateBranchRequest;
import com.example.rentcarapp.services.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BranchController {
    private final BranchService branchService;

    @GetMapping("/addBranch")
    public String addBranch(Model model){
        model.addAttribute("createBranchRequest", new CreateBranchRequest());
        return "addBranch";
    }

    @PostMapping("/addBranch")
    public String addBranch(
            CreateBranchRequest createBranchRequest,
            Model model){
        BranchDto branchDto = branchService.createBranch(createBranchRequest);
        return "redirect:addBranch";
    }
}
