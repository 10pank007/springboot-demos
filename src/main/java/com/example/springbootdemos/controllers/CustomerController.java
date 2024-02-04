package com.example.springbootdemos.controllers;

import com.example.springbootdemos.dao.CustomerDAO;
import com.example.springbootdemos.dto.CustomerDTO;
import com.example.springbootdemos.models.Customer;
import com.example.springbootdemos.repository.CustomerDAOInter;
import com.example.springbootdemos.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService service;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerToJSONBody(@RequestBody @Valid CustomerDTO customerDTO) {
        service.saveCustomer(customerDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomers(@PathVariable("id") int id) {
        service.delete(id);
    }
    @PatchMapping ("")
    public ResponseEntity<CustomerDTO> updateCustomers(@RequestBody CustomerDTO dto) {
        return new ResponseEntity<>(service.update(dto), HttpStatus.OK);
    }
}
