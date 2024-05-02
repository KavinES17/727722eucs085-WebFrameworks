package com.example.cw2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cw2.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Integer>{
    
}
