package com.example.validate.service;

import com.example.validate.model.Form;

import java.util.List;

public interface FormService {
    boolean create(Form form);
    boolean update(Form form);
    Form findById(int id);
    boolean delete(int id);
    List<Form> findAll();

}
