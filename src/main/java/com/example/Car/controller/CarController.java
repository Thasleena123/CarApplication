package com.example.Car.controller;

import com.example.Car.dto.Car;
import com.example.Car.service.CarServices;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping("/mycarCompany")
public class CarController {
    @Autowired
    CarServices carServices;




    @GetMapping(path = "/fetch/{id}", produces = "application/json")
    public Car getCarModelDetails(@Valid @PathVariable("id") int id) {
        return carServices.getCarModelDetails(id);
    }

    @GetMapping("/getByIds/{ids}")
    public ResponseEntity<List<Car>> getCarsByIds(@PathVariable String ids) {
        List<Car> car = carServices.getCarsByIds(ids);
        return ResponseEntity.ok(car);
    }

    @PutMapping("/updateExpiryDate/{id}")
    public ResponseEntity<String> updateExpiryDate(@PathVariable("id") int carId, @RequestBody Car car) {
        LocalDate newExpDate = car.getExpiryDate();
        boolean isUpdated = carServices.updateExpiryDate(carId, newExpDate);
        if (isUpdated) {
            return ResponseEntity.ok(" expiry date is added successfully");
        } else {
            return ResponseEntity.status(404).body("Car not found.");
        }
    }
    @PostMapping("/insertnewModel")
public  String insertNewModel(@RequestBody Car car){
    return carServices.insertNewModel(car);
    }
}




