package com.example.demo.repo;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IPatientRepo extends JpaRepository<Patient,Long> {

    @Modifying
    @Transactional
    @Query(value = "Update patient set status_id=:status_id where id=:id", countQuery = "Select count(*) from patient", nativeQuery = true)
    public void deleteByIdChangeStatus(int status_id , Long id);
}
