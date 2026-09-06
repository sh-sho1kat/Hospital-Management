package com.example.hospitalmanagement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true,  length = 50)
    private String email;

    @OneToMany(mappedBy = "doctor")
    private List<Appoinment> appoinments;
}
