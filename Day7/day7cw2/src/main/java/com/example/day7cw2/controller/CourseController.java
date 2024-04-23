package com.example.day7cw2.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day7cw2.model.Course;
import com.example.day7cw2.service.CourseService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CourseController {
    public CourseService courseService;
    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }
    @PostMapping("/api/course")
    public ResponseEntity<Course> postMethodName(@RequestBody Course course) {
        if(courseService.saveCourse(course))
        {
            return new ResponseEntity<>(course,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/course")
    public ResponseEntity<List<Course>> getMethodName() {
        List<Course> list = courseService.getCourses();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/course/{courseName}")
    public ResponseEntity<List<Course>> getMethod(@PathVariable("courseName") String courseName) {
        List<Course> list = courseService.getCourseByCourseName(courseName);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    
}
