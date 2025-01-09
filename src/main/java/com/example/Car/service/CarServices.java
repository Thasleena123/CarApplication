package com.example.Car.service;

import com.example.Car.dao.CarRepo;
import com.example.Car.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServices {
    CarRepo carRepo;

    @Autowired
    public CarServices(CarRepo carRepo) {
        this.carRepo = carRepo;
    }



    public Car getCarModelDetails(int id) {
        try {
            return carRepo.getCarModelDetails(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    public List<Car> getCarsByIds(String ids) {
        String[] carId = ids.split(",");
        List<String> carIds = new ArrayList<>(Arrays.asList(carId));
        return carRepo.getCarsByIds(carIds);
    }

    public boolean updateExpiryDate(int carId, LocalDate newExpDate) {
        Car car = carRepo.getCarModelDetails(carId);
        if (car != null) {
            int rowAffected = carRepo.updateExpiryDate(carId, newExpDate);
            return rowAffected > 0;

        }
        return false;
    }
    public String insertNewModel(Car car) {
        return carRepo.insertNewModel(car);
    }
}