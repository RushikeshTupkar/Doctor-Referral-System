package com.example.demo.repo;

import com.example.demo.helper.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepo extends JpaRepository<Status,Integer> {
}
