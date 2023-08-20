package com.main.controller;

import com.main.entity.Student;
import com.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private  final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public String listAllStudent(Model model)
    {
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
    }
//    @GetMapping("/student/{id}")
//    public Optional<Student> getSingleStudentById(@PathVariable Integer id)
//    {
//        return  studentService.getStudentById(id);
//    }


    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.createStudent(student);
        return "redirect:/student";
    }
    @GetMapping("/student/new")
    public  String createStudent(Model model)
    {
        Student student = new Student();
        model.addAttribute("student", student);

        return "createStudent";
    }

    @GetMapping("/student/edit/{id}")
    public String editService(@PathVariable Integer id, Model model)
    {
        model.addAttribute("student", studentService.getStudentById(id).get());
        return "editStudent";

    }
    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Student student, Model model)
    {
       Student existingStudent = studentService.getStudentById(id).get();
       existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent( existingStudent.getId(), existingStudent);
        return "redirect:/student";
    }
    @GetMapping("/student/{id}")
    public String deleteSingleStudent(@PathVariable Integer id)
    {
         studentService.deleteStudent(id);
        return "redirect:/student";
    }
}
