package com.example.springbootdemos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
//@Table(name = "customers_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "customers_name", unique = true, nullable = false)
//    @Email
//    @Pattern()
    @NotBlank(message = "name is required")
    @Size(min = 2, message = "name must be at least 2 characters")
    @Size(max = 255, message = "name must be not more than 255 characters")
    private String name;
}
