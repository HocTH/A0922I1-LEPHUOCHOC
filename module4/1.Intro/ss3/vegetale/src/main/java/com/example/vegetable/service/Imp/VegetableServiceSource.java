package com.example.vegetable.service.Imp;

import com.example.vegetable.entity.Vegetable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public class VegetableServiceSource implements com.example.vegetable.service.VegetableServiceSource {
//    private Map<Integer,Vegetable> vegetableMap = new HashMap<>();
//
//    public VegetableServiceSource() {
//        TypeSource typeService = new TypeService();
//        Date date = null;
//        try{
//            date = (new SimpleDateFormat("dd/MM/yyy")).parse("01/01/2023");
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        vegetableMap.put(1, new Vegetable(1,"Toi",10,100000,date,typeService.findById(2)));
//        vegetableMap.put(2, new Vegetable(2,"Toi",14,20000,date,typeService.findById(1)));
//        vegetableMap.put(3, new Vegetable(3,"Toi",13,500000,date,typeService.findById(2)));
//    }
@PersistenceContext
private EntityManager entityManager;
    @Override
    public boolean create(Vegetable vegetable) {
        entityManager.persist(vegetable);
        return true;
    }

    @Override
    public boolean update(Vegetable vegetable) {
        entityManager.merge(vegetable);
        return true;
    }

    @Override
    public Vegetable findById(int id) {
        return entityManager.find(Vegetable.class, id);
    }

    @Override
    public List<Vegetable> findAll() {
        return entityManager.createQuery("select p from Vegetable p").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
     entityManager.remove(findById(id));
            return true;
    }
}
