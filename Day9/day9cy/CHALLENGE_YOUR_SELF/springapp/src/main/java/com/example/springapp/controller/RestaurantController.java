package com.example.springapp.controller;

import java.util.List;

//import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Restaurant;
import com.example.springapp.service.RestaurantService;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping("/api/restaurant")
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant)
    {
        if(restaurantService.saveRestaurant(restaurant)==true)
        {
            return new ResponseEntity<>(restaurant,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(restaurant,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/restaurant/{restaurntId}")
    public ResponseEntity<List<Restaurant>> getRestaurantId(@PathVariable int restaurntId)
    {
        List<Restaurant> b=restaurantService.getId(restaurntId);
        if(b!=null)
        {
            return new ResponseEntity<List<Restaurant>>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/restaurant/byname/{restaurntName}")
    public ResponseEntity<List<Restaurant>> getRestaurantName(@PathVariable String restaurntName)
    {
        List<Restaurant> a=restaurantService.getName(restaurntName);
        if(a!=null)
        {
            return new ResponseEntity<List<Restaurant>>(a,HttpStatus.OK);
        }
        return new ResponseEntity<>(a,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/restaurant/capacity/{capacity}")
    public ResponseEntity<List<Restaurant>> getRestaurantCapacity(@PathVariable long capacity)
    {
        List<Restaurant> c=restaurantService.getCapacity(capacity);
        if(c!=null)
        {
            return new ResponseEntity<List<Restaurant>>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
}
