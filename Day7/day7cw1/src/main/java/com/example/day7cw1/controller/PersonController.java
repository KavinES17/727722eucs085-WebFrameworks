package com.example.day7cw1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7cw1.model.Person;
import com.example.day7cw1.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class PersonController {
    public PersonService personService;
    public PersonController(PersonService personService)
    {
        this.personService= personService;
    }
    @PostMapping("/api/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {
        if(personService.savePerson(person))
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/person")
    public ResponseEntity<List<Person>> getMethodName() {
        List<Person> list = personService.getPersons();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/person/{byAge}")
    public ResponseEntity<List<Person>> getMethod(@PathVariable("byAge") int age) {
        List<Person> list = personService.getPersonByAge(age);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    

}
