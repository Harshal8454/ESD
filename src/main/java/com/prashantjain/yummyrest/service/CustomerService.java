package com.prashantjain.yummyrest.service;

import com.prashantjain.yummyrest.dto.CustomerRequest;
import com.prashantjain.yummyrest.dto.CustomerResponse;
import com.prashantjain.yummyrest.entity.Customer;
import com.prashantjain.yummyrest.mapper.CustomerMapper;
import com.prashantjain.yummyrest.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    // Constructor injection
    @Autowired
    public CustomerService(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    // Method to create a new customer
    public String createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        customerRepo.save(customer);
        return "Customer created successfully";
    }

    // Method to authenticate login
    public String login(String email, String password) {
        Optional<Customer> optionalCustomer = customerRepo.findByEmail(email);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            if (customer.getPassword().equals(password)) {
                return "User logged in successfully.";
            }
        }
        return "Invalid email or password.";
    }
}

