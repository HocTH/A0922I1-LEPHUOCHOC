package com.example.libraryborrow.repository;

import com.example.libraryborrow.entity.Book;
import com.example.libraryborrow.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
}
