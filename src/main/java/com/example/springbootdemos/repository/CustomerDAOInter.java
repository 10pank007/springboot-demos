package com.example.springbootdemos.repository;

import com.example.springbootdemos.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAOInter extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c where c.name=:name")
    List<Customer> byName(String name);

    List<Customer> findByName(String name);
}
