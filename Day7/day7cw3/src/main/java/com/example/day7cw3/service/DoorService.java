package com.example.day7cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day7cw3.model.Door;
import com.example.day7cw3.repository.DoorRepo;

@Service
public class DoorService {
    public DoorRepo doorRepo;
    public DoorService(DoorRepo doorRepo)
    {
        this.doorRepo = doorRepo;
    }
    public boolean saveDoor(Door door)
    {
        try
        {
            doorRepo.save(door);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Door> getDoors()
    {
        return doorRepo.findAll();
    }
    public Door getDoorById(int id)
    {
        return doorRepo.findById(id).orElse(null);
    }
    public List<Door> getDoorsByAccessType(String accessType)
    {
        return doorRepo.findByAccessType(accessType);
    }
}
