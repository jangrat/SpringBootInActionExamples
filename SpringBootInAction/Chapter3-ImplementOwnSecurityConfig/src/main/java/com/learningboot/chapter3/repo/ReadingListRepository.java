package com.learningboot.chapter3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningboot.chapter3.domain.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
