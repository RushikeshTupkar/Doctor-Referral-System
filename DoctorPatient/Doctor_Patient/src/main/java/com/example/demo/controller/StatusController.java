package com.example.demo.controller;

import com.example.demo.helper.Status;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {

    @Autowired
    private StatusService service;
    @PostMapping("/addStatus")
    public Status addStatus(@Valid @RequestBody Status status){
        return service.createStatus(status);
    }
}
