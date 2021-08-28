package com.somsubhra.springbootexceptionhandling.student;

import com.somsubhra.springbootexceptionhandling.exception.ApiRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
//        Calls exception class
        throw new ApiRequestException("Can't get all students");
    }

}
