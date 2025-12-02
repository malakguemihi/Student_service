package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.CourseDTO;

@FeignClient(name = "course-service", url = "http://localhost:8000/api")
public interface FeignClientCourse {

    @GetMapping("/students/{studentId}/courses/")
    List<CourseDTO> getCoursesByStudent(@PathVariable("studentId") int studentId);
}


