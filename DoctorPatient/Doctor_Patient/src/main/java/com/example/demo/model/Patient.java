package com.example.demo.model;


import com.example.demo.helper.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone_number;
    private String email;
    private String city;
    private ArrayList<String> symptom;
    @OneToOne
    @JoinColumn
    private Status status;
}
