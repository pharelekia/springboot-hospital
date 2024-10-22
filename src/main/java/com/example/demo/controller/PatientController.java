package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/patients")
@RequiredArgsConstructor
@RestController
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.deletePatient(id));
    }
}
