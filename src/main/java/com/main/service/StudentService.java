package com.main.service;

import com.main.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Integer id);
    Student createStudent(Student student);
    Student updateStudent(Integer id, Student student);
    void deleteStudent(Integer id);
}
