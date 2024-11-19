package com.prashantjain.yummyrest.mapper;

import com.prashantjain.yummyrest.dto.LoginRequest;
import com.prashantjain.yummyrest.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    public Customer toEntity(LoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}
