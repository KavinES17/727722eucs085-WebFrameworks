package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Person;
import java.util.List;


@Repository
public interface PersonRepo extends JpaRepository<Person,Integer>
{

    List<Person> findByNameStartsWithOrderByNameAsc(String name);   
    List<Person> findByNameEndsWithOrderByNameAsc(String name);
}