package com.example.hospitalmanagement.entity;

import com.example.hospitalmanagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

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
    private BloodGroupType bloodGroupType;

//   @CreationTimestamp
//   @Column(updatable = false)
//   private LocalDate createdAt;

   @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
   @JoinColumn(name = "insurance_id") //Owning Side
   private Insurance insurance;

   @OneToMany(mappedBy = "patient", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
   private List<Appoinment> appointments;

}
