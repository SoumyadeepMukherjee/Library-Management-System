package com.thinkxfactor.springdemo.controllers;

import java.util.*;
import com.thinkxfactor.springdemo.entity.Student;
import com.thinkxfactor.springdemo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    List<Student> students = new ArrayList<>();

    @GetMapping("/echo")
    public String sayEcho() {
        return "Echo from student controller";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Greetings " + name + "!!";
    }

    // CRUD OPERATIONS
    // CREATE
    @PostMapping("/addStudent")
    public Student addStudents(@RequestBody Student student) {
        Student persistentStudent = studentRepository.save(student);
        return persistentStudent;
        // student.setId(UUID.randomUUID().toString());
        // students.add(student);
        // return students;
    }

    // @GetMapping("/createStudent")
    // public HashMap<String, Object> createStudent(@RequestParam String name,
    // @RequestParam String age,
    // @RequestParam String gender) {
    // HashMap<String, Object> respMap = new HashMap<>();
    // respMap.put("Name:", name);
    // respMap.put("Age:", age);
    // respMap.put("Gender:", gender);
    // return respMap;
    // }

    // READ
    @GetMapping("/getAllStudents")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/getStudent/{sid}")
    public Student getStudent(@PathVariable Long sid) {
        return studentRepository.findById(sid).get();
    }

    // UPDATE
    @PutMapping("/updateStudent")
    public Student updateStudents(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // DELETE
    @DeleteMapping("/delete")
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/getByUserNameAndPassword")
    public Student getByUsernameAndPassword(@RequestParam String name, @RequestParam String password) {
        Student stu = null;
        System.out.println("Query with user name " + name + "and password " + password);
        // Student persistentStudent= studentRepository.findByUserName(name);
        // System.out.println("Query result :"+persistentStudent.getId());
        Optional<Student> persistentStudent = studentRepository.findByUsernameAndPassword(name, password);

        if (persistentStudent.isPresent()) {
            System.out.println("Query Result:" + persistentStudent.get().getId());
            return persistentStudent.get();
        }

        return stu;
    }
}
