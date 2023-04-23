package com.example.demo.service;

import com.example.demo.helper.Status;
import com.example.demo.repo.IStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private IStatusRepo statusRepo;

    public Status createStatus(Status status) {
        Status save = statusRepo.save(status);
        return save;
    }
}
