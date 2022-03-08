package com.thinkxfactor.springdemo.repository;

import com.thinkxfactor.springdemo.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
