package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String speciality_type;
//    @OneToMany
//    @JoinColumn
//    private List<Doctor>doctors_list;

//    @OneToMany
//    @JoinColumn
//    private List<Symptoms> symptomsList;
}
