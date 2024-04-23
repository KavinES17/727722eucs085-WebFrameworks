package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Restaurant;
import java.util.List;


@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Integer>
{
    @Query("select a from Restaurant a where a.restaurntId=?1")
    List<Restaurant> findByRestaurntId(int restaurntId);

    @Query("select a from Restaurant a where a.restaurntName=?1")
    List<Restaurant> findByRestaurntName(String restaurntName);
    
    @Query("select a from Restaurant a where a.capacity=?1")
    List<Restaurant> findByCapacity(long capacity);
    
}
