package com.example.springbootdemos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private String customerName;
    private int customerAge;


}
