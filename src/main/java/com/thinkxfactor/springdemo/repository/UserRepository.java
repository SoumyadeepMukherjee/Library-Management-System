package com.thinkxfactor.springdemo.repository;

import com.thinkxfactor.springdemo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
