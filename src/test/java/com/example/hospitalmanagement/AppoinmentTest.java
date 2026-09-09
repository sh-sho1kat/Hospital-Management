package com.example.hospitalmanagement;


import com.example.hospitalmanagement.entity.Appoinment;
import com.example.hospitalmanagement.repository.AppoinmentRepository;
import com.example.hospitalmanagement.service.AppoinmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class AppoinmentTest {
    @Autowired
    private AppoinmentService appoinmentService;

    @Test
    public void takeappoinment()
    {
        Appoinment appoinment = Appoinment
                .builder()
                .reason("Heart Attack")
                .appointmentTime(LocalDateTime.of(2026, 10, 10, 12,12))
                .build();

        appoinmentService.getAppoinment(appoinment, 1L, 1L);
    }

    @Test
    public void reAssignDoctorAppoinment()
    {
        appoinmentService.reAssignAppoinment(1L,2L);
    }
}
