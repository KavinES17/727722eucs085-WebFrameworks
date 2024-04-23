package com.example.day7pah.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day7pah.model.Car;

public interface CarRepo extends JpaRepository<Car,Integer>{
    List<Car> findDistinctByCurrentOwnerNameAndAddress(String currentOwnerName,String address);
}
