package com.example.springbootdemos.dao;

import com.example.springbootdemos.models.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Transactional
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    public List<Customer> findAll() {
//        return entityManager.createNativeQuery("select * from customer", Customer.class).getResultList();
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }
    public Customer findById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Transactional
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
