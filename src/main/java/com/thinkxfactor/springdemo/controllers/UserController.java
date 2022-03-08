package com.thinkxfactor.springdemo.controllers;

import java.util.*;

import com.thinkxfactor.springdemo.entity.User;
import com.thinkxfactor.springdemo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // int count = 0;

    // @GetMapping("/")
    // public String error() {
    // return "ERROR";
    // }

    // @GetMapping("/hello")
    // public String sayHello1() {
    // return "Hello World!!";
    // }

    // @GetMapping("/hello2")
    // public Map<String, String> sayHello2() {
    // Map<String, String> respMap = new HashMap<>();

    // respMap.put("name", "raj");
    // respMap.put("age", "25");
    // respMap.put("dept", "CSE");
    // return respMap;
    // }

    // @GetMapping("/counter")
    // public String count() {
    // count += 1;
    // return "The counter value is:" + count;
    // }

    // @GetMapping("/getUsers")
    // public User getUser() {
    // User us1 = new User();
    // us1.setName("Raj");
    // us1.setDepartment("CSE");
    // us1.setAge(25);
    // return us1;
    // }

    // @GetMapping("/greet/{name}")
    // public String greet(@PathVariable String name) {
    // return "Hello " + name + "!!";
    // }

    // @GetMapping("/getUser")
    // public User greetUser(@RequestParam String name, @RequestParam String
    // department, @RequestParam int age) {
    // User user = new User();
    // user.setName(name);
    // user.setDepartment(department);
    // user.setAge(age);
    // return user;
    // }

    // @PostMapping("/saveUser")
    // public User saveUser(@RequestBody User user) {
    // user.setId(UUID.randomUUID().toString());
    // return user;
    // }

    @Autowired
    UserRepository userRepository;
    // CRUD operation

    // Create(POST)
    @PostMapping("/addUser")
    public User addBooks(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Read will be GET
    @GetMapping("/getAllUsers")
    public List<User> getBook() {
        return userRepository.findAll();
    }

    @GetMapping("/getBook/{isbn}")
    public User getBook(@PathVariable Long uid) {
        return userRepository.findById(uid).get();
    }

    // Update will be PUT/POST
    @PutMapping("/updateUser")
    public User updateBooks(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Delete will be GET/DELETE
    @DeleteMapping("/deleteUser/{uid}")
    public void deleteUser(@PathVariable Long uid) {
        userRepository.deleteById(uid);
    }

}
