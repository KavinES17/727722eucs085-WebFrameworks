package com.example.day7cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day7cw3.model.Door;
import java.util.List;


public interface DoorRepo extends JpaRepository<Door,Integer>{
    List<Door> findByAccessType(String accessType);
}
