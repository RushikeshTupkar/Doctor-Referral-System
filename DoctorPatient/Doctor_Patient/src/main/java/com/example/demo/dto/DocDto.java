package com.example.demo.dto;


import io.swagger.annotations.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocDto {

    @NotBlank
    @NotNull
    private String first_name;
    @NotBlank
    @NotNull
    private String last_name;
   @Length(max = 20, message = "Length of city should be less than 20 characters")
    private String city;

    @Email(message = "please provide valid email", regexp = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$")
    private String email;

    private String phone_number;
    @NotBlank
    private String address;
    @NotBlank
    private String speciality;
}
