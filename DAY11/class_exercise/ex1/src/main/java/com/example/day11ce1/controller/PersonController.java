package com.example.day11ce1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11ce1.model.Person;
import com.example.day11ce1.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/person")
    public Person postMethodName(@RequestBody Person entity) {
        
        return personService.addPerson(entity);
    }
    
    @GetMapping("/person")
    public List<Person> getMethodName() {
        return personService.getPersons();
    }
    
    @GetMapping("/person/{id}")
    public Optional<Person> getMethodName(@PathVariable int id) {
        return personService.getPerson(id);
    }
    
}
