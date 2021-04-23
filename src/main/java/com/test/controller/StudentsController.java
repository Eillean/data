package com.test.controller;

import com.test.entity.Student;
import com.test.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@CrossOrigin
@Slf4j
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    @CrossOrigin
    public Student getAllStudent() {
        return studentService.getAllStudentInfo();
    }
}
