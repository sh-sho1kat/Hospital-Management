package com.example.hospitalmanagement.service;


import com.example.hospitalmanagement.entity.Insurance;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.InsuranceRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository  insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void createInsuranceForPatient(Insurance insurance, Long patient_id)
    {
            Patient patient = patientRepository
                    .findById(patient_id)
                    .orElseThrow(() -> new RuntimeException("Patient not found with id " + patient_id));
            patient.setInsurance(insurance);
            insurance.setPatient(patient);

            return;
    }

}
