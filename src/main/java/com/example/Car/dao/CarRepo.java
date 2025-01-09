package com.example.Car.dao;

import com.example.Car.dto.Car;
import com.example.Car.dto.CarRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepo {
    //    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
//    static final String USER = "root";
//    static final String PASS = "password";
//    Connection conn = null;
//
//    public CarRepo() {
//        try {
//            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
    private final JdbcTemplate jdbcTemplate;

    public CarRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String insertNewModel(Car car) {
        String sql = "insert into carInfo(name,phoneNo,email,address,manufacture_date,expiry_date) values(?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql,car.getName(),car.getPhoneNo(),car.getEmail(),car.getAddress(),car.getManufacturingDate() ,car.getExpiryDate());
        if (rows == 1) {
            return "car added succesfully";
        }else{
            return "insertion failed";
        }


    }


    public Car getCarModelDetails(int id) {
        String sql = "Select * from  carInfo  where id= ?";

        return jdbcTemplate.queryForObject(sql,new Object[]{id}, new CarRowMapper());

    }

    public List<Car> getCarsByIds(List<String> carIds) {
        String sql = "select * from carInfo where id IN(" + String.join(",", carIds) + ")";
        return jdbcTemplate.query(sql, new CarRowMapper());
    }
 public  int updateExpiryDate(int carId, LocalDate newExpDate){
        String sql="Update carInfo set expiry_date=? where id=? ";
        return  jdbcTemplate.update(sql,newExpDate,carId);
 }

}