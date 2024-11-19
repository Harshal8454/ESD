package com.prashantjain.yummyrest.controller;

import com.prashantjain.yummyrest.dto.CustomerRequest;
import com.prashantjain.yummyrest.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    // final : it will create only one object in whole project container, when we run the project
    private final CustomerService customerService;

    @PostMapping // for post request
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        /*
        @Valid :
        The @Valid annotation in Spring is used to trigger validation for the annotated object. When you use @Valid with @RequestBody in a controller method, it ensures that the incoming request body is validated against the constraints defined in the Java class (e.g., CustomerRequest)

        @RequestBody :
         When a client sends a request with JSON or XML data in the body (e.g., via a POST or PUT request), @RequestBody can be used to automatically map this data to a Java object in the controller.

        ResponseEntity<String>:
        String: The type parameter specifies the type of the response body. In this case, it's String, which means the response body will be plain text.
        ResponseEntity: Wraps the response body along with HTTP status and headers, giving you control over the HTTP response.

         */
        System.out.println("==================== create controller");
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
}