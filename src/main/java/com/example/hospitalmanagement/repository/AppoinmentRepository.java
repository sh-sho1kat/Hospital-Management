package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppoinmentRepository extends JpaRepository<Appoinment, Long> {
}