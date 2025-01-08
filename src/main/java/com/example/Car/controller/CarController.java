package com.example.Car.controller;

import com.example.Car.dto.Car;
import com.example.Car.service.CarServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/mycarCompany")
public class CarController {
@Autowired
    CarServices carServices;
@GetMapping(path = "car",produces ="application/json")
    public List<Car> getAllCarDetails() {
    return carServices.getAllCarDetails();
}
    @GetMapping(path = "/fetch/{id}",produces ="application/json")
    public Car getCarModelDetails(@Valid@PathVariable("id")int id){
    return  carServices.getCarModelDetails(id);
    }
//    @PatchMapping(path = "car/{expirydate}",produces = "")
}


