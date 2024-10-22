package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.DoctorNotFoundException;
import com.example.demo.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(Long id){
        return doctorRepository.findById(id).orElseThrow(()->new DoctorNotFoundException("Doctor with "+id+" doesn't found"));
    }

    public Doctor saveDoctor(Doctor doctorInput){
        return doctorRepository.save(doctorInput);
    }

    public Doctor updateDoctor(Long id, Doctor doctorInput){
        Doctor doctor = getDoctor(id);
        doctor.setName(doctorInput.getName());
        return doctorRepository.save(doctor);
    }

    public String deleteDoctor(Long id){
        Doctor doctor = getDoctor(id);
        doctorRepository.delete(doctor);

        return "Doctor deleted";
    }
}
