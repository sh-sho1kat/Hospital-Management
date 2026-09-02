package com.example.hospitalmanagement.entity;

import com.example.hospitalmanagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter

@Table(
//        name = "patient_tbl",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name_and_birthdate", columnNames = {"name", "birth_date"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birth_date")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthDate;

//    @Column(unique = true)
    private String email;
    private String gender;
   @Column(name = "bloodgroup_type")
   @Enumerated(EnumType.STRING)
    private BloodGroupType bloodgroupType;

}
