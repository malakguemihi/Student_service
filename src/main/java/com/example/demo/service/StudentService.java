package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.feign.FeignClientCourse;
import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FeignClientCourse feignClientCourse;

    // ------------------ Gestion des étudiants ------------------

    public Student addStudent(Student student) {
        if (student.getUniversity() != null && student.getUniversity().getId() != 0) {
            University university = universityRepository.findById(student.getUniversity().getId())
                    .orElseThrow(() -> new RuntimeException("University not found"));
            student.setUniversity(university);
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        if (updatedStudent.getUniversity() != null && updatedStudent.getUniversity().getId() != 0) {
            University university = universityRepository.findById(updatedStudent.getUniversity().getId())
                    .orElseThrow(() -> new RuntimeException("University not found"));
            student.setUniversity(university);
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getById(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByFirstNameContainingIgnoreCase(name);
    }

    public List<Student> searchByUniversity(String universityName) {
        return studentRepository.findByUniversity_Name(universityName);
    }

    public Student assignUniversity(int studentId, int universityId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        University university = universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("University not found"));
        student.setUniversity(university);
        return studentRepository.save(student);
    }

    // ------------------ Integration avec Course Service ------------------

    public List<CourseDTO> getCoursesByStudent(int studentId) {
        return feignClientCourse.getCoursesByStudent(studentId);
    }
}
