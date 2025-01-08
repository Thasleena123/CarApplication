package com.example.Car.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

//@Getter
//@Setter
@Data
public class Car {
    @NotNull(message = "id field cannot be null")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "id must be a number")
    private int id;

    @NotNull(message = "name field cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "name must be in alphanumeric format")
    private String name;

    @NotNull(message = "phoneNo cannot be null")
    @Pattern(regexp = "^[0-9{10}]$", message = "phone no: must be exactly 10 digits,please enter a valid phone no")
    private String phoneNo;

    @NotNull(message = "email field cannot be null")
    @Size(max = 100, message = "email must not exceed 100 characters ")
    @Email(message = "invalid email format")
    private String email;

    @Size(min = 50, max = 300, message = "address must be between 50 and 300")
    @NotNull(message = "address field cannot be null")
    private String address;

    @NotNull(message="manufacture date is required")
    @PastOrPresent(message = "manufacture date cannot be in future")
    private LocalDate manufacturingDate;

    @NotNull(message = "id cannot be null")
    @Future(message = "expiry date should be in future")
    private LocalDate expiryDate;

    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = " model name must be in alphanumeric format")
    private String model;
}
