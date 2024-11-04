package com.prashantjain.yummyrest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Email is required")
        @Email(message = "Email must be in correct format")
        @JsonProperty("email") String email,

        @NotBlank(message = "Password is required")
        @JsonProperty("password") String password
) {
}

