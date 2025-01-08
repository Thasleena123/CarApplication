package com.example.Car.service;

import com.example.Car.dao.CarRepo;
import com.example.Car.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServices {
    CarRepo carRepo;

    @Autowired
    public CarServices(CarRepo carRepo){
        this.carRepo=carRepo;
    }
    public List<Car> getAllCarDetails(){
        return carRepo.getAllCarDetails();
    }
//    public String addCarInfo(Car car){
//        return carRepo.addCarInfo(car);
//    }
    public Car getCarModelDetails(int id){
        try {
            return carRepo.getCarModelDetails(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
