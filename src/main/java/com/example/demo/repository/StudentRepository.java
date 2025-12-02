package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByUniversity_Name(String universityName);
}
