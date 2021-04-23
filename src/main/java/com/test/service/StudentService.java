package com.test.service;

import com.test.entity.Student;
import com.test.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public Student getAllStudentInfo() {
        return studentMapper.studentQry();
    }

}
