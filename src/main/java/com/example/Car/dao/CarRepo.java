package com.example.Car.dao;

import com.example.Car.dto.Car;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepo {
    static final String DB_URL = "jdbc:mysql://localhost:3306/car";
    static final String USER = "root";
    static final String PASS = "password";
    Connection conn = null;

    public CarRepo() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Car> getAllCarDetails() {
        String sql = "select * from carInfo";
        List<Car> carDetails = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setName(rs.getString("name"));
                car.setPhoneNo(rs.getString("phoneNo"));
                car.setEmail(rs.getString("email"));
                car.setAddress(rs.getString("address"));
                car.setManufacturingDate(rs.getDate("manufacture_date").toLocalDate());
                car.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
                car.setModel(rs.getString("model"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public String addCarInfo(Car car) {
        String sql = "insert into carInfo (expiry_date) values(?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(car.getExpiryDate()));
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                return "successfully added ExpiryDate";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "failed to add expiry date";

    }

    public Car getCarModelDetails(int id) {
        String sql = "Select * from  carInfo  where id= ?";
        try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Car car = new Car();
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
        } catch (SQLException e) {
            throw new RuntimeException("error occures", e);
        }
        return null;

    }
}
//} public Car getCarModelsDettails(int id) {
//    String sql = "Select * from  carInfo  where id= ?";
//    try (PreparedStatement preparedStatement = this.conn.prepareStatement(sql)) {
//        preparedStatement.setInt(1, id);
//        ResultSet rs = preparedStatement.executeQuery();
//        if (rs.next()) {
//            Car car = new Car();
//            car.setId(rs.getInt("id"));
//            car.setName(rs.getString("name"));
//            car.setPhoneNo(rs.getString("phoneNo"));
//            car.setEmail(rs.getString("email"));
//            car.setAddress(rs.getString("address"));
//            car.setManufacturingDate(rs.getDate("manufacture_date").toLocalDate());
//            car.setExpiryDate(rs.getDate("expiry_date").toLocalDate());
//            car.setModel(rs.getString("model"));
//            return car;
//        }
//    } catch (SQLException e) {
//        throw new RuntimeException("error occures",e);
//    }
//    return null;
//
//}
//}