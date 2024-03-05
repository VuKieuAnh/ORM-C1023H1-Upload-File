package org.example.demoorm.service;
import org.example.demoorm.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Long id);

    void remove(Long id);
}