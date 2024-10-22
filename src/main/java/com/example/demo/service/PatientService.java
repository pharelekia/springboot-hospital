package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.exception.PatientNotFoundException;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id){
        return patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient with "+id+" not found"));
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patient){
        Patient patient1 = getPatientById(id);
        patient1.setName(patient.getName());
        patient1.setAge(patient.getAge());
        return patientRepository.save(patient1);
    }

    public String deletePatient(Long id){
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
        return "Patient deleted";
    }
}
