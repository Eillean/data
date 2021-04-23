# 步骤
1.新建一个Spring Initializr项目

2.选择项目所需要的依赖

 Web (web)
 
 SQL (MySQL JDBC Mybatis)
   
pom中会加入依赖：   
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.5</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.test</groupId>
    <artifactId>data</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>data</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.4</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.16.16</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.1</version>
                <configuration>
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```

3.修改配置文件application.properties
```
# 服务端口
server.port = 8888

# MySQL数据库连接
spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true
spring.datasource.username=root
spring.datasource.password=123456

# mybatis
mybatis.mapper-locations=classpath:mapper/*Mapper.xml
```

4. Controller:
```
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
```

5.service
```
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
```
6.mapper
```
package com.test.mapper;

import com.test.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student studentQry();
}
```

7.mapper.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.test.mapper.StudentMapper">

    <resultMap id="BaseResultMap" type="com.test.entity.Student">
        <result column="id" jdbcType="INTEGER" property="id" />
        <result column="name" jdbcType="VARCHAR" property="name" />
        <result column="age" jdbcType="INTEGER" property="age" />
    </resultMap>

    <select id="studentQry" resultType="com.test.entity.Student">
        select * from student
    </select>

</mapper>
```

8.entity
```
package com.test.entity;

import lombok.Data;

@Data
public class Student {
    public Integer id;
    public String name;
    public Integer age;
}
```
9.SQL
```
CREATE TABLE `student` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `age` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

# 结构图
！[image](https://www.baidu.com/img/flexible/logo/pc/result.png)


