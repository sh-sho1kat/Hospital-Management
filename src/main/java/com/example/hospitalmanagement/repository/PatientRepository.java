package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
    Patient findByBirthDate(LocalDate date);

    List<Patient> findByNameOrBirthDate(String name, LocalDate date);

    @Query("SELECT p FROM Patient p Where p.bloodGroupType = :bloodGroupType")
    List<Patient> findbyBloodGroup(@Param("bloodGroupType") BloodGroupType bloodGroupType);

    @Transactional
    @Modifying

    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateName(@Param("name") String name, @Param("id") Long id);

}
