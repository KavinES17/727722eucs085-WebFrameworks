package com.example.ce2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("Student created")
    public String name;

    @JsonProperty("Age")
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
