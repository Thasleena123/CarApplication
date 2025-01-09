package com.example.Car.dto;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car=new Car();
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        car.setPhoneNo(rs.getString("phoneNo"));
        car.setEmail(rs.getString("email"));
        car.setAddress(rs.getString("address"));
        car.setManufacturingDate(rs.getDate("manufacture_date").toLocalDate());
        car.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
        car.setModel(rs.getString("model"));
        return car;
    }
}
