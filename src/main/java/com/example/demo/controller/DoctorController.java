package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RequestMapping("/doctors")
@RequiredArgsConstructor
@Controller
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.getDoctor(id));
    }

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, Doctor doctor){
        return ResponseEntity.ok(doctorService.updateDoctor(id,doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id){
        return ResponseEntity.ok(doctorService.deleteDoctor(id));
    }
}
