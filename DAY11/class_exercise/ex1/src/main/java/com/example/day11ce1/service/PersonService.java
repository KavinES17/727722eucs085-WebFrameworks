package com.example.day11ce1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day11ce1.model.Person;
import com.example.day11ce1.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;
    @SuppressWarnings("null")
    public Person addPerson(Person person)
    {
        return personRepo.save(person);
    }

    public List<Person> getPersons()
    {
        return personRepo.findAll();
    }

    public Optional<Person> getPerson(int id)
    {
        return personRepo.findById(id);
    }
}
