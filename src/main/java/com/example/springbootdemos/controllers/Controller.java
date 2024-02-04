package com.example.springbootdemos.controllers;

import com.example.springbootdemos.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<String> homeGet() {
        return new ResponseEntity<String>("home get", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> homePost() {
        return new ResponseEntity<>("home post", HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return null;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById() {
        return null;
    }

    @PostMapping("/customers")
    public void saveCustomerToJSONBody(@RequestBody Customer customer) {
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustomers(@PathVariable("id") int id) {
        return null;
    }
    @PatchMapping ("/customers/{id}")
    public ResponseEntity<List<Customer>> updateCustomers(@PathVariable("id") int id) {
        return null;
    }

//    @PostMapping("/customers")
//    public ResponseEntity<List<Customer>> createCustomers(
//            @RequestParam int id,
//            @RequestParam String name
//    ) {
//        this.customers.add(new Customer(id, name));
//         return  new ResponseEntity<>(this.customers, HttpStatus.CREATED);
//    }

//@GetMapping("/customers")
//@ResponseStatus(HttpStatus.OK)
//public List<Customer> getCustomers() {
//    return this.customers;
//}
}
