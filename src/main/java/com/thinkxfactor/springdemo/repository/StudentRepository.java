package com.thinkxfactor.springdemo.repository;

import java.util.Optional;

import com.thinkxfactor.springdemo.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByUserName(String username);

    Optional<Student> findByUsernameAndPassword(String username, String password);
}
