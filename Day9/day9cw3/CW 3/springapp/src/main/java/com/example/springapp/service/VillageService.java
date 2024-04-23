package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Village;
import com.example.springapp.repository.VillageRepo;

@Service
public class VillageService {
    @Autowired
    private VillageRepo rep;

    public boolean post(Village person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Village start(String lastname)
    {
        return rep.findByName(lastname);
    }
    public Village get3(int id)
    {
        return rep.findById(id);
    }

    public List<Village> end(int population)
    {
        return rep.findByPopulation(population);
    }
    
}
