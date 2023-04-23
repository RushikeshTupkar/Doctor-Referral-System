package com.example.demo.service;

import com.example.demo.dto.PatientDto;
import com.example.demo.exceptionHandler.NotValid;
import com.example.demo.helper.Validations;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Symptoms;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PatientService {
    @Autowired
    private IPatientRepo patientRepo;
    @Autowired
    private IDoctorRepo IDoctorRepo;

    @Autowired
    private ISymptomsRepo symptomsRepo;
    @Autowired
    private IStatusRepo statusRepo;

    @Autowired
    private ISpecialityRepo specialityRepo;
    public Patient addPatient( PatientDto patientDto) throws NotValid {
        if(!Validations.isValidMobileNo(patientDto.getPhone_number())){
            throw new NotValid("Please consider providing valid phone number");
        }
        if(!Validations.isValidEmail(patientDto.getEmail())){
            throw new NotValid("Please consider providing valid email");
        }

        Patient p = new Patient();
        p.setName(patientDto.getName());
        p.setPhone_number(patientDto.getPhone_number());
        p.setEmail(patientDto.getEmail());
        p.setCity(patientDto.getCity());
        p.setStatus(statusRepo.findById(1).get());
        Patient save = patientRepo.save(p);

        return save;
    }

    public Doctor getDoctor(String city, String symptom, boolean flag) {
        List<Symptoms> bySymptom = symptomsRepo.findBySymptom(symptom);
        if(!bySymptom.isEmpty()){
            Long id = bySymptom.get(0).getSpeciality().getId();
            List<Doctor> bySpecialityIdAndCity = IDoctorRepo.findBySpecialityIdAndCity(id, city);
            if(!bySpecialityIdAndCity.isEmpty()){
                return bySpecialityIdAndCity.get(0);
            }else{
                throw new NullPointerException("No doctor is available in -> "+city+" -:- We are still waiting to expand to your location");
            }
        }
        List<String> byFirstLetter = symptomsRepo.findByFirstLetter(symptom.substring(0,2));
      if(!flag){
       throw new NullPointerException("Please check symptom spelling -> consider appropriate symptom from this list ->"+byFirstLetter.toString());
      }
      return null;
    }

    public Patient getPatientById(Long id) throws NotValid {
        if(!patientRepo.findById(id).isPresent()){
            throw new NotValid("No patient found with id -> "+id+" please consider providing valid id");
        }
        Patient p = patientRepo.findById(id).get();
        if(p.getStatus().getId()==1){
            return  p;
        }else{
            throw new NotValid("No patient found with id -> "+id+" please consider providing valid id");
        }

    }

    public Doctor getDoctorById(long id) throws NotValid {
        Doctor doc=null;
        if(!patientRepo.findById(id).isPresent()){
            throw new NotValid("No patient found with id -> "+id+" please consider providing valid id");
        }
        Patient p = patientRepo.findById(id).get();
        if(p.getStatus().getId()!=1){
            throw new NotValid("No patient found with id -> "+id+" please consider providing valid id");
        }
        String city = p.getCity();
        List<String>symptoms = p.getSymptom();
        boolean flag = true;
        if(!symptoms.isEmpty()) {
            for (String sym : symptoms) {
                Doctor doctorBySym = this.getDoctorBySym(sym);
                if(doctorBySym!=null){
                    doc = doctorBySym;
                }
                Doctor doctor = this.getDoctorForID(city.toLowerCase(), sym.toLowerCase());
                if (doctor!=null) {
                    flag = false;
                    return doctor;
                }
            }
        }
        if(flag && doc!=null) {
            throw new NullPointerException("No doctor found for patient having symptoms -> " + symptoms.toString()+"" +
                    "  But you can consider visiting this "+doc.toString()+" doctor in the city -> "+doc.getCity());
        }else if(flag){
            throw new NullPointerException("No doctor found for patient having symptoms -> " + symptoms.toString());
        }
           return null;
    }

    public void deleteById(Long id) throws NotValid {
        if(!patientRepo.findById(id).isPresent()){
            throw new NotValid("No patient found with id -> "+id+" please consider providing valid id");
        }
//        patientRepo.deleteById(id);
        patientRepo.deleteByIdChangeStatus(2, id);
    }


    public Doctor getDoctorForID(String city, String symptom) {
        List<Symptoms> bySymptom = symptomsRepo.findBySymptom(symptom);
        if (!bySymptom.isEmpty()) {
            Long id = bySymptom.get(0).getSpeciality().getId();
            List<Doctor> bySpecialityIdAndCity = IDoctorRepo.findBySpecialityIdAndCity(id, city);
            if (!bySpecialityIdAndCity.isEmpty()) {
                return bySpecialityIdAndCity.get(0);
            }
        }
        return null;
    }

    public Doctor getDoctorBySym(String symptom) {
        List<Symptoms> bySymptom = symptomsRepo.findBySymptom(symptom);
        if (!bySymptom.isEmpty()) {
            Long id = bySymptom.get(0).getSpeciality().getId();
            List<Doctor> bySpecialityIdAndCity = IDoctorRepo.findBySpecialityId(id);
            if (!bySpecialityIdAndCity.isEmpty()) {
                return bySpecialityIdAndCity.get(0);
            }
        }
        return null;
    }


    public List<Symptoms> getAlldata() {
        return symptomsRepo.getAllSymptoms();
    }
}
