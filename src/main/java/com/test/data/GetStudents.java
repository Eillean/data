package com.test.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@CrossOrigin
@Slf4j
public class GetStudents {

    @RequestMapping("/students")
    @CrossOrigin
    public Student getStudent() {
        log.info("获取用户数据信息");
        return new Student("xiaoming", 28);
    }
}
