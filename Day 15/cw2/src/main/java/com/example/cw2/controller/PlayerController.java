
package com.example.cw2.controller;

import com.example.cw2.model.Player;
import com.example.cw2.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                "N/A", HttpStatus.OK.value(), "List of players", "N/A");
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") int id) {
        logger.info("FINISHED PROCESSING : METHOD=GET; REQUESTURI=/players/{}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                id, HttpStatus.OK.value(), "Player details", "N/A");
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        logger.info("FINISHED PROCESSING : METHOD=POST; REQUESTURI=/players; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIME TAKEN={}",
                player, HttpStatus.CREATED.value(), "Player added successfully", "N/A");
        Player savedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
}