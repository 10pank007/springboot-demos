package com.example.springbootdemos.services;

import com.example.springbootdemos.dao.CustomerDAO;
import com.example.springbootdemos.dto.CustomerDTO;
import com.example.springbootdemos.mapper.CustomerMapper;
import com.example.springbootdemos.models.Customer;
import com.example.springbootdemos.repository.CustomerDAOInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerDAOInter customerDAOInter;
    private CustomerMapper customerMapper;

    public List<CustomerDTO> findAll() {
        return customerMapper.convertCustomerToDTO(customerDAOInter.findAll());
    }
    public CustomerDTO findById(int id) {
        Customer customer = customerDAOInter.findById(id).get();
        return customerMapper.convertCustomerToDTO(customer);
    }
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDAOInter.save(customerMapper.dtoToCustomer(customerDTO));
    }
    public void delete(int id) {
        customerDAOInter.deleteById(id);
    }
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = customerMapper.dtoToCustomer(customerDTO);
        Customer save = customerDAOInter.save(customer);
        return customerMapper.convertCustomerToDTO(save);
    }
}
