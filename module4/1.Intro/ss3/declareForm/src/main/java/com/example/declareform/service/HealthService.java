package com.example.declareform.service;

import com.example.declareform.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HealthService {
  public static List<Person> lists = new ArrayList<>();
  public List<Person> findAll(){
      return lists;
  }
  public void save(Person person){
      for (Person checkPerson : lists){
          if (checkPerson.getId() == person.getId()){
              lists.remove(checkPerson);
              lists.add(person);
              break;
          }
      }
  }
  public Person findById(int id){
      for (Person checkPerson: lists) {
           if (checkPerson.getId() == id){
               return  checkPerson;
           }
      }
      return null;
  }
}
