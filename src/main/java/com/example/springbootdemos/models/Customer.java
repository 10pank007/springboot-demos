package com.example.springbootdemos.models;

import com.example.springbootdemos.models.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.View;

@Getter
@Setter
@AllArgsConstructor
@Entity
//@Table(name = "customers_table")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.SuperAdmin.class)
    private int id;
//    @Column(name = "customers_name", unique = true, nullable = false)
    @JsonView({Views.SuperAdmin.class, Views.Admin.class})
    private String name;


}
