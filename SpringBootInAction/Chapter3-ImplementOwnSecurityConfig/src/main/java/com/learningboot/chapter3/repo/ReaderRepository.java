package com.learningboot.chapter3.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningboot.chapter3.domain.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>{

}
