package com.example.vegetable.service.Imp;

import com.example.vegetable.entity.Type;
import com.example.vegetable.service.TypeSource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TypeService implements TypeSource {
@PersistenceContext
private EntityManager entityManagement;

    @Override
    public boolean create(Type type) {
        entityManagement.persist(type);
        return true;
    }

    @Override
    public boolean update(Type type) {
       entityManagement.merge(type);
            return true;

    }

    @Override
    public Type findById(int id) {
        return entityManagement.find(Type.class, id);
    }

    @Override
    public List<Type> findAll() {
        return entityManagement.createQuery("select  t from Type t").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        Type type = findById(id);
        entityManagement.remove(type);
        return true;
    }
}
