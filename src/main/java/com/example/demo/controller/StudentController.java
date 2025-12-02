package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CourseDTO;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @GetMapping("/searchByName")
    public List<Student> searchByName(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/searchByUniversity")
    public List<Student> searchByUniversity(@RequestParam String univName) {
        return studentService.searchByUniversity(univName);
    }

    @PostMapping("/{studentId}/assignUniversity/{univId}")
    public Student assignUniversity(@PathVariable int studentId, @PathVariable int univId) {
    return studentService.assignUniversity(studentId, univId);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getCoursesByStudent(@PathVariable int id) {
    return studentService.getCoursesByStudent(id);
    }

}
