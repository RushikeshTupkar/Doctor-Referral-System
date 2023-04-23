package com.example.demo.model;


import com.example.demo.helper.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String city;
    private String email;
    private String phone_number;
    private String address;

    @ManyToOne
    @JoinColumn
    private Speciality speciality;

    @OneToOne
    @JoinColumn
    private Status status;

}
