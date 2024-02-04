package com.example.springbootdemos.controllers;

import com.example.springbootdemos.dao.CustomerDAO;
import com.example.springbootdemos.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class Controller {
//    @GetMapping("/")
//    public ResponseEntity<String> homeGet() {
//        return new ResponseEntity<String>("home get", HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> homePost() {
//        return new ResponseEntity<>("home post", HttpStatus.CREATED);
//    }
    private CustomerDAO customerDAO;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> all = customerDAO.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Customer byId = customerDAO.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerToJSONBody(@RequestBody Customer customer) {
        customerDAO.save(customer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomers(@PathVariable("id") int id) {
        customerDAO.deleteById(id);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.ACCEPTED);
    }
    @PatchMapping ("")
    public ResponseEntity<List<Customer>> updateCustomers(@RequestBody Customer customer) {
        customerDAO.update(customer);
        return new ResponseEntity<>(customerDAO.findAll(), HttpStatus.OK);
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
