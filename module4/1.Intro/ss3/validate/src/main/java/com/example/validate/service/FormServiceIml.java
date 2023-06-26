package com.example.validate.service;

import com.example.validate.model.Form;
import com.example.validate.repo.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class FormServiceIml implements FormService{
    @Autowired
    private FormRepository service;
    @Override
    public boolean create(Form form) {
        service.save(form);
        return true;
    }

    @Override
    public boolean update(Form form) {
        if(service.existsById(form.getId())){
            service.save(form);
            return true;
        }
        return false;
    }

    @Override
    public Form findById(int id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        service.deleteById(id);
        return true;
    }

    @Override
    public List<Form> findAll() {
        return (List<Form>) service.findAll();
    }
}
