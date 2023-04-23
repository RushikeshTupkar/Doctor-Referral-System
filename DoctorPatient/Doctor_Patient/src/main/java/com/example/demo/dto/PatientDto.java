package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private Long id;
    private String name;
    private String phone_number;
    private String email;
    private String city;
    private ArrayList<String> symptom;
}
