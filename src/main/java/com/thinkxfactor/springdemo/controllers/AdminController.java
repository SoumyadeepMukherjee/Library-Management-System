package com.thinkxfactor.springdemo.controllers;

import java.util.List;

import com.thinkxfactor.springdemo.entity.Admin;
import com.thinkxfactor.springdemo.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    // CRUD operation : Create(POST), Read(GET), Update(PUT/POST) , Delete(DELETE)

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/getAdmin/{id}")
    public Admin getAdmin(@PathVariable long id) {
        return adminRepository.findById(id).get();
    }

    @PutMapping("/updateAdmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @DeleteMapping("/deleteAdmin")
    public void deleteAdmin(@PathVariable long id) {
        adminRepository.deleteById(id);
    }

}
