package com.example.demo.repo;

import com.example.demo.model.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISymptomsRepo extends JpaRepository<Symptoms,Long> {
    @Query(value = "Select * From symptoms where symptom=:symptom", countQuery = "SELECT count(*) from symptoms", nativeQuery = true)
    public List<Symptoms> findBySymptom(String symptom);


    @Query(value = "Select symptom From symptoms where Substring(symptom,1,2)=:symptom", countQuery = "SELECT count(*) from symptoms", nativeQuery = true)
    public List<String> findByFirstLetter(String symptom);


    @Query(value = "Select * from symptoms Order by speciality_id", countQuery = "Select count(*) from symptoms", nativeQuery = true)
    public List<Symptoms> getAllSymptoms();
}

