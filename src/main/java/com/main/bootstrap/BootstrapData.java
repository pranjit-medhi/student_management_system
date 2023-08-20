package com.main.bootstrap;

import com.main.entity.Student;
import com.main.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

//@Controller
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public BootstrapData(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student arun = new Student();
        arun.setFirstName("Arun");
        arun.setLastName("Mohan");
        arun.setEmail("arun@mohan.com");


        Student barun = new Student();
        barun.setFirstName("Barun");
        barun.setLastName("Mohan");
        barun.setEmail("barun@mohan.com");

        Student darun = new Student();
        darun.setFirstName("Darun");
        darun.setLastName("Das");
        darun.setEmail("darun@das.com");

        studentRepository.save(arun);
        studentRepository.save(barun);
        studentRepository.save(darun);
    }
}
