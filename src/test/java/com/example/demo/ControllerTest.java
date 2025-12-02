package com.example.demo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    @Order(1)
    void shouldSaveStudent() {
        // إنشاء جامعة وهمية
        University university = new University();
        university.setName("Test University");
        university.setLocation("Algeria");
        university = universityRepository.save(university);

        // إنشاء طالب
        Student student = new Student();
        student.setFirstName("Charlie");
        student.setLastName("Brown");
        student.setEmail("charlie.brown@example.com");
        student.setUniversity(university);

        // حفظ الطالب
        studentRepository.save(student);

        // التأكد من أن عدد الطلاب أصبح 1
        assertThat(studentRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllStudents() {
        List<Student> students = studentRepository.findAll();

        // التأكد من أن القائمة تحتوي على طالب واحد
        assertThat(students).hasSize(1);

        // التأكد من اسم الطالب وبريد الجامعة
        Student student = students.get(0);
        assertThat(student.getFirstName()).isEqualTo("Charlie");
        assertThat(student.getLastName()).isEqualTo("Brown");
        assertThat(student.getUniversity().getName()).isEqualTo("Test University");
    }
}
