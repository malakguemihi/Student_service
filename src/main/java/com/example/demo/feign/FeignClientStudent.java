package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Student;

@FeignClient(name = "student-service", url = "http://localhost:8082")
public interface FeignClientStudent {

    @GetMapping("/students/all")
    List<Student> getAllStudents();
}
