package com.example.day7cw3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7cw3.model.Door;
import com.example.day7cw3.service.DoorService;


@RestController
public class DoorController {
    public DoorService doorService;
    public DoorController(DoorService doorService)
    {
        this.doorService = doorService;
    }
    @PostMapping("/api/door")
    public ResponseEntity<Door> postMethodName(@RequestBody Door door) {
        if(doorService.saveDoor(door))
        {
            return new ResponseEntity<>(door,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/door")
    public ResponseEntity<List<Door>> getMethodName() {
        List<Door> list = doorService.getDoors();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<Door> getById(@PathVariable("doorId") int id) {
        Door door = doorService.getDoorById(id);
        if(door == null)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(door,HttpStatus.OK);
    }
    
    @GetMapping("/api/door/accesstype/{accessType}")
    public ResponseEntity<List<Door>> getMethod(@PathVariable("accessType") String accessType) {
        List<Door> list = doorService.getDoorsByAccessType(accessType);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
