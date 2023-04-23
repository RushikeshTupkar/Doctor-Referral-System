package com.example.demo.controller;

import com.example.demo.dto.PatientDto;
import com.example.demo.exceptionHandler.NotValid;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Symptoms;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody PatientDto patient) throws NotValid {
        Patient patient1 = service.addPatient(patient);
        return patient1;
    }

    @GetMapping("/suggestDoctorBySymptomsAndCity")
    public Doctor suggestDoctorBySymptomsAndCity(@RequestParam String city, @RequestParam String symptom ){
        Doctor doctor = service.getDoctor(city.toLowerCase(), symptom.toLowerCase(), false);
        if(doctor.getStatus().getId()!=1){
            throw new NullPointerException("No doctor is available in -> "+city+" -:- We are still waiting to expand to your location");
        }
        return doctor;
    }

    @GetMapping("/suggestDoctorByPatientId")
    public Doctor suggestDoctorByPatientId(@RequestParam long id) throws NotValid {
        Doctor doctor = service.getDoctorById(id);
        if(doctor.getStatus().getId()!=1){
            throw new NullPointerException("No doctor is available in -> "+doctor.getCity()+" -:- We are still waiting to expand to your location");
        }
        return doctor;
    }

    @GetMapping("/getPatientById")
    public Patient getPatientById(@RequestParam long id) throws NotValid {
        Patient p = service.getPatientById(id);
        return p;
    }

    @DeleteMapping("/deletePatientById")
    public ResponseEntity<String> deleteById(@RequestParam Long id) throws NotValid {
        service.deleteById(id);
        return new ResponseEntity<>("Patient deleted having id -> "+id, HttpStatus.OK);
    }

    @GetMapping("getSymptomsAndSpecialitiesNeeded")
    public List<Symptoms> getAll(){
        return service.getAlldata();
    }
}
