package com.example.demo.service;

import com.example.demo.dto.SysmptomsDto;
import com.example.demo.model.Speciality;
import com.example.demo.model.Symptoms;
import com.example.demo.repo.ISpecialityRepo;
import com.example.demo.repo.ISymptomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsService {
    @Autowired
    private ISymptomsRepo symptomsRepo;
    @Autowired
    private ISpecialityRepo specialityRepo;
    public Symptoms addSymptom(SysmptomsDto sysmptomsDto) {
        List<Speciality> bySpeciality = specialityRepo.findBySpeciality(sysmptomsDto.getSpeciality());
        Speciality s = bySpeciality.get(0);
        Symptoms symptoms = new Symptoms();
        symptoms.setSymptom(sysmptomsDto.getSymptom().toLowerCase());
        symptoms.setSpeciality(s);
        Symptoms save = symptomsRepo.save(symptoms);
        return save;
    }

    public List<Symptoms> getAllSymptoms() {
        return symptomsRepo.findAll();
    }
}
