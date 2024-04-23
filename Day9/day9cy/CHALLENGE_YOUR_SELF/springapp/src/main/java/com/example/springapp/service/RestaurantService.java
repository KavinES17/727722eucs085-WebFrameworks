package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Restaurant;
import com.example.springapp.repository.RestaurantRepo;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    @SuppressWarnings("null")
    public boolean saveRestaurant(Restaurant restaurant)
    {
        try{
            restaurantRepo.save(restaurant);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
public List<Restaurant> getId(int restaurntId)
    {
        return restaurantRepo.findByRestaurntId(restaurntId);
    }

    public List<Restaurant> getName(String restaurntName)
    {
        return restaurantRepo.findByRestaurntName(restaurntName);
    }
    
    public List<Restaurant> getCapacity(long capacity)
    {
        return restaurantRepo.findByCapacity(capacity);
    }
}
