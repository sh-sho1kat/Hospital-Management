package com.example.hospitalmanagement;


import com.example.hospitalmanagement.entity.Insurance;
import com.example.hospitalmanagement.repository.InsuranceRepository;
import com.example.hospitalmanagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService  insuranceService;

    @Test
    public void setInsuranceToPatient()
    {
        Insurance insurance = Insurance.builder()
                .policyNumber("IFIC1234")
                .provider("IFIC Bank")
                .validUntil(LocalDate.of(2030, 10,10))
                .build();
        insuranceService.createInsuranceForPatient(insurance,1L);
    }
}
