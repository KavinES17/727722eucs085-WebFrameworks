package com.example.day7cw2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day7cw2.model.Course;
import com.example.day7cw2.repository.CourseRepo;

@Service
public class CourseService {
    public CourseRepo courseRepo;
    public CourseService(CourseRepo courseRepo)
    {
        this.courseRepo = courseRepo;
    }
    public boolean saveCourse(Course course)
    {
        try
        {
            courseRepo.save(course);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Course> getCourses()
    {
        return courseRepo.findAll();
    }
    public List<Course> getCourseByCourseName(String courseName)
    {
        return courseRepo.findByCourseName(courseName);
    }
}
