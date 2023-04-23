package com.example.demo.controller;

import com.example.demo.dto.SysmptomsDto;
import com.example.demo.model.Symptoms;
import com.example.demo.service.SpecialityService;
import com.example.demo.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/symptoms")
public class SymptomsController {
    @Autowired
    private SymptomsService service;
    @PostMapping("/addSymptoms")
    public Symptoms addSymptoms(@RequestBody SysmptomsDto sysmptomsDto){
        Symptoms s = service.addSymptom(sysmptomsDto);
        return s;
    }

    @GetMapping("/getAllSymptomsAndSpeciality")
    public List<Symptoms> getAllSymptoms(){
        return service.getAllSymptoms();
    }
}
