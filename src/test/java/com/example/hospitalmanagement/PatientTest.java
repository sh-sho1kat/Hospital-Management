package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testFindById() {
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);

        Patient patient = new Patient();
        patientRepository.save(patient);
    }

    @Test
    public void testTransaction() {
        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
    }
}
