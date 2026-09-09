package com.example.hospitalmanagement.service;


import com.example.hospitalmanagement.entity.Appoinment;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.AppoinmentRepository;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {
    private final AppoinmentRepository appoinmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void getAppoinment(Appoinment appoinment,Long doctor_id, Long patient_id){
        Doctor doctor =  doctorRepository.findById(doctor_id)
                        .orElseThrow(()->
                        new RuntimeException("doctor not found with id "+doctor_id));
        Patient patient = patientRepository.findById(patient_id)
                        .orElseThrow(()->
                                new RuntimeException("patient not found with id "+patient_id));

        if(appoinment.getId() != null){
            throw new IllegalArgumentException("appoinment already exists with id "+appoinment.getId());
        }
        appoinment.setDoctor(doctor);
        appoinment.setPatient(patient);

        patient.getAppointments().add(appoinment);
        appoinmentRepository.save(appoinment);
    }

    @Transactional
    public void reAssignAppoinment(Long appoinment_id,Long doctor_id){
        Appoinment appoinment = appoinmentRepository.findById(appoinment_id).orElseThrow();
        Doctor doctor =  doctorRepository.findById(doctor_id).orElseThrow();

        appoinment.setDoctor(doctor);
        doctor.getAppoinments().add(appoinment);
    }
}
