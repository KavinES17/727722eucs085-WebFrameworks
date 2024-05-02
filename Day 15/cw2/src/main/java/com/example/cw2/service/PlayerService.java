package com.example.cw2.service;

import com.example.cw2.model.Player;
import com.example.cw2.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Player getPlayerById(int id) {
        return playerRepo.findById(id).orElse(null);
    }

    public Player addPlayer(Player player) {
        return playerRepo.save(player);
    }
}
