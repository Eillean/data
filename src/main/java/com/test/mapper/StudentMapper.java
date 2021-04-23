package com.test.mapper;

import com.test.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student studentQry();
}
