package com.example.rentcarapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "mainRental")
public class MainRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    @ManyToOne
    private Address Contact_Address;
    private String Owner;
    private String Logo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainRental")
    private List<Branch> branch_List;
}
