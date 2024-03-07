package org.example.demoorm.service;

import org.example.demoorm.exception.NotFoundException;
import org.example.demoorm.model.entity.Customer;
import org.example.demoorm.repo.customer.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return
                customerRepo.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(Long id) throws NotFoundException{
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        else
            throw new NotFoundException();
    }

    @Override
    public void remove(Long id) {

    }
}
