package com.example.day7pah.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7pah.model.Car;
import com.example.day7pah.service.CarService;



@RestController
public class CarController {
    private CarService carService;
    public CarController(CarService carService)
    {
        this.carService=carService;
    }

    @PostMapping("/api/car")
    public ResponseEntity<Car> postMethod(@RequestBody Car car) {
        if(carService.saveCar(car) == true)
            return new ResponseEntity<>(car,HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @GetMapping("/api/car")
    public ResponseEntity<List<Car>> getMethod() {
        List<Car> list=carService.getCars();
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/api/car/distinct")
    public ResponseEntity<List<Car>> filterMethod(@RequestParam("currentOwnerName") String currentOwnerName,@RequestParam("address") String address) {
        List<Car> list=carService.getFiltered(currentOwnerName,address);
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
