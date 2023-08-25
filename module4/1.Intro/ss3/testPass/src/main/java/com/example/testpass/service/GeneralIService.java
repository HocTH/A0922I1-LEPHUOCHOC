package com.example.testpass.service;

import com.example.testpass.exception.AdminException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralIService <T>{
  boolean update(T t);
  boolean save(T t)  ;
  List<T> findAll();
  T findById(int id);
  boolean deleteById(int id);
  Page<T> findAll(Pageable pageable);
}
