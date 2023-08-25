package com.example.libraryborrow.service;

import com.example.libraryborrow.entity.Student;
import com.example.libraryborrow.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repo;
    @Override
    public List<Student> findAll() {
        return (List<Student>) repo.findAll();
    }

    @Override
    public boolean save(Student student) {
        repo.save(student);
        return true;
    }

    @Override
    public boolean update(Student student) {
        if (repo.existsById(student.getIdStudent())){
            repo.save(student);
            return true;
        }
        return false;
    }

    @Override
    public Student findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
           repo.deleteById(id);
            return true;
        }
        return false;
    }
}
