package com.example.springbootdemos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String customerName;
    private int customerAge;
    private int id;

    public CustomerDTO(String customerName, int customerAge) {
        this.customerName = customerName;
        this.customerAge = customerAge;
    }
}
