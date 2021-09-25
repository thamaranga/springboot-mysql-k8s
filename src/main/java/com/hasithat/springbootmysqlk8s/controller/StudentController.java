package com.hasithat.springbootmysqlk8s.controller;

import com.hasithat.springbootmysqlk8s.entity.Student;
import com.hasithat.springbootmysqlk8s.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added successfully::"+student.getId();

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/findStudent/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Deleted Student Successfully::"+id;
    }
}
