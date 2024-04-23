package com.example.day10cw1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day10cw1.model.Door;
import com.example.day10cw1.repository.DoorRepo;

@Service
public class DoorService {
    public DoorRepo doorRepo;
    public DoorService(DoorRepo doorRepo)
    {
        this.doorRepo = doorRepo;
    }
    public boolean saveDoor(Door door)
    {
        try{
            doorRepo.save(door);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Door> getByColor(String color)
    {
        return doorRepo.findByColor(color);
    }
    public Door updateColor(String color,int id)
    {
        doorRepo.updateColorById(color, id);
        return doorRepo.findById(id).orElse(null);
    }
    public boolean deleteDoor(int id)
    {
        if(this.getDoorById(id)==null)
        {
            return false;
        }
        doorRepo.deleteDoorByDoorId(id);
        return true;
    }
    public List<Door> getByDoorType(String doorType)
    {
        return doorRepo.findByDoorType(doorType);
    }
    public List<Door> getDoors()
    {
        return doorRepo.findAll();
    }
    public Door getDoorById(int id)
    {
        return doorRepo.findById(id).orElse(null);
    }
}
