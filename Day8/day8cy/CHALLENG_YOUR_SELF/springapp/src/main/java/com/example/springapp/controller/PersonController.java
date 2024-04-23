package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.springapp.model.Person;
import com.example.springapp.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    @PostMapping("/person")
    public ResponseEntity<Person> postPerson(@RequestBody Person person)
    {
        if(personService.savePerson(person)==true)
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    @GetMapping("/person/startsWith")
    public ResponseEntity<List<Person>> getPerson(@RequestParam String name)
    {
        List<Person> a=personService.getName(name);
        if(a!=null)
        {
            return new ResponseEntity<List<Person>>(a,HttpStatus.OK);
        }
        return new ResponseEntity<>(a,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    @GetMapping("/person/endsWith")
    public ResponseEntity<List<Person>> getPersonEnd(@RequestParam String name)
    {
        List<Person> b=personService.getNamEnde(name);
        if(b!=null)
        {
            return new ResponseEntity<List<Person>>(b,HttpStatus.OK);
        }
        return new ResponseEntity<>(b,HttpStatus.INTERNAL_SERVER_ERROR);  
    }
}
