package com.example.demo.repo;

import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
    @Query(value = "Select * From doctor where speciality_id=:speciality_id AND city=:city", countQuery = "Select count(*) from doctor", nativeQuery = true)
    public List<Doctor> findBySpecialityIdAndCity(Long speciality_id, String city);


    @Query(value = "Select * From doctor where speciality_id=:speciality_id", countQuery = "Select count(*) from doctor", nativeQuery = true)
    List<Doctor> findBySpecialityId(Long speciality_id);

    @Modifying
    @Transactional
    @Query(value = "Update doctor set status_id=:status_id where id=:id", countQuery = "Select count(*) from patient", nativeQuery = true)
    public void deleteByIdChangeStatus(int status_id , Long id);
}
