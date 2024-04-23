package com.example.day10cw1.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.day10cw1.model.Door;
import com.example.day10cw1.service.DoorService;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class DoorController {
    private DoorService doorService;
    public DoorController(DoorService doorService)
    {
        this.doorService=doorService;
    }

    @PostMapping("/api/door")
    public ResponseEntity<Door> postMethod(@RequestBody Door door) {
        if(doorService.saveDoor(door) == true)
            return new ResponseEntity<>(door,HttpStatus.CREATED);
        return new ResponseEntity<>(door,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/door/bycolor/{color}")
    public ResponseEntity<List<Door>> getByColor(@PathVariable("color") String color) {
        List<Door> list=doorService.getByColor(color);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("/api/door/{doorId}")
    public ResponseEntity<Door> updateByDoorId(@PathVariable("doorId") int doorId,@RequestParam("color") String color) {
        Door d=doorService.updateColor(color,doorId);
        if(d==null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @DeleteMapping("/api/door/{doorId}")
    public ResponseEntity<String> deleteByDoorId(@PathVariable("doorId") int doorId) {
        
        if(doorService.deleteDoor(doorId)==false)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Door deleted successfully",HttpStatus.OK);
    }
    
    @GetMapping("/api/door/bydoortype")
    public ResponseEntity<List<Door>> getByDoorType(@RequestParam("doorType") String doorType) {
        List<Door> list=doorService.getByDoorType(doorType);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/api/door")
    public ResponseEntity<List<Door>> getByDoorDetails() {
        List<Door> list=doorService.getDoors();
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<Door> getByDoorId(@PathVariable("doorId") int doorId) {
        Door d=doorService.getDoorById(doorId);
        if(d == null)
            return new ResponseEntity<>(d,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }
    
    

    
}