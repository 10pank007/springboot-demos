package com.example.springbootdemos.controllers;

import com.example.springbootdemos.dao.CustomerDAO;
import com.example.springbootdemos.dto.CustomerDTO;
import com.example.springbootdemos.models.Customer;
import com.example.springbootdemos.repository.CustomerDAOInter;
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
//    @GetMapping("/")
//    public ResponseEntity<String> homeGet() {
//        return new ResponseEntity<String>("home get", HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> homePost() {
//        return new ResponseEntity<>("home post", HttpStatus.CREATED);
//    }
    //private CustomerDAO customerDAO;
    private CustomerDAOInter customerDAOInter;

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getCustomers() {
        //List<Customer> all = customerDAO.findAll();
        List<Customer> all = customerDAOInter.findAll();
        List<CustomerDTO> collect = all.stream().map(customer ->
                new CustomerDTO(customer.getName(), customer.getAge())).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        //Customer byId = customerDAO.findById(id);
        return new ResponseEntity<>(customerDAOInter.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public void saveCustomerToJSONBody(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getCustomerName());
        customer.setAge(customerDTO.getCustomerAge());
        customerDAOInter.save(customer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> deleteCustomers(@PathVariable("id") int id) {
        //customerDAO.deleteById(id);
        customerDAOInter.deleteById(id);
        return new ResponseEntity<>(customerDAOInter.findAll(), HttpStatus.ACCEPTED);
    }
    @PatchMapping ("")
    public ResponseEntity<List<Customer>> updateCustomers(@RequestBody Customer customer) {
        customerDAOInter.save(customer);
        return new ResponseEntity<>(customerDAOInter.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findBy/name/{name}")
    public List<Customer> findByNameQuery(@PathVariable String name) {
        return customerDAOInter.byName(name);
    }
    @GetMapping("/findBy/name/method/{name}")
    public List<Customer> findByNameMethodQuery(@PathVariable String name) {
        return customerDAOInter.findByName(name);
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
