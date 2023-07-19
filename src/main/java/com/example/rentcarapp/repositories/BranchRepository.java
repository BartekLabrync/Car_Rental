package com.example.rentcarapp.repositories;
import com.example.rentcarapp.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository  extends JpaRepository<Branch, Long> {

}
