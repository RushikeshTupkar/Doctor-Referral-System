package com.example.demo.service;

import com.example.demo.dto.SpecialityDto;
import com.example.demo.dto.SysmptomsDto;
import com.example.demo.model.Speciality;
import com.example.demo.repo.ISpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {
    @Autowired
    private ISpecialityRepo specialityRepo;

    public Speciality addSpeciality(SpecialityDto specialityType) {
        Speciality speciality = new Speciality();
        speciality.setSpeciality_type(specialityType.getSpeciality_type());
        Speciality save = specialityRepo.save(speciality);
        return save;
    }


    public List<Speciality> getAllSpecialities() {
        return specialityRepo.findAll();
    }
}
