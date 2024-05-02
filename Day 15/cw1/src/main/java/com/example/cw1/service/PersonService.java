package com.example.cw1.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cw1.model.Person;
import com.example.cw1.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    public Person createPerson(Person person) {
        return repo.save(person);
    }

    public List<Person> getAllPersons() {
        return repo.findAll();
    }
}
