package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;

@RestController
@RequestMapping("/universities")

public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university) {
        return universityService.saveUniversity(university);
    }

    @GetMapping("/all")
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable int id) {
        return universityService.getUniversityById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUniversity(@PathVariable int id) {
        universityService.deleteUniversity(id);
        return "University deleted successfully";
    }
}
