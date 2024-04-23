package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    public boolean savePerson(Person person)
    {
        try{
            personRepo.save(person);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public List<Person> getName(String name)
    {
        return personRepo.findByNameStartsWithOrderByNameAsc(name);
    }
    public List<Person> getNamEnde(String name)
    {
        return personRepo.findByNameEndsWithOrderByNameAsc(name);
    }
}
