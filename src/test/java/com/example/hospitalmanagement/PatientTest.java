package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.type.BloodGroupType;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
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
    @Test
    public void findbyname()
    {
        Patient patient = patientRepository.findByName("Ishita Sen");
        System.out.println(patient);
    }

    @Test
    public void findbybirthdate()
    {
        Patient patient = patientRepository.findByBirthDate(LocalDate.parse("1993-10-25"));
        System.out.println(patient);
    }

    @Test
    public void findbynameorbirthdate()
    {
        List<Patient> patients = patientRepository.findByNameOrBirthDate("Ishita Sen", LocalDate.of(1993,10,25));
        System.out.println(patients);
    }

    @Test
    public void customquery()
    {
        List<Patient> patients = patientRepository.findbyBloodGroup(BloodGroupType.O_POSITIVE);
        System.out.println(patients);
    }
}
