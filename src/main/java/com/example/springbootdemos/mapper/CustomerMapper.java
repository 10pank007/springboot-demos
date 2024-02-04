package com.example.springbootdemos.mapper;

import com.example.springbootdemos.dto.CustomerDTO;
import com.example.springbootdemos.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CustomerMapper {
    public List<CustomerDTO> convertCustomerToDTO(List<Customer> customers) {
        return customers.stream().map(customer -> new CustomerDTO(
                customer.getName(),
                customer.getAge(),
                customer.getId())).collect(Collectors.toList());
    }
    public CustomerDTO convertCustomerToDTO(Customer customer) {
        return new CustomerDTO(customer.getName(),customer.getAge(), customer.getId());
    }
    public Customer dtoToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getCustomerName());
        customer.setAge(customerDTO.getCustomerAge());
        customer.setId(customerDTO.getId());
        return customer;
    }
}
