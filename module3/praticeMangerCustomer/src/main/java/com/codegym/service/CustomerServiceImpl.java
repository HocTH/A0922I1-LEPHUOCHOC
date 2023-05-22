package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.repository.customerRepositoryImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl  implements CustomerService{
         private ICustomerRepository repository = new customerRepositoryImp();
    @Override
    public List<Customer> findAll() {

        return repository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Customer customer) {
              repository.save(customer);
    }

    @Override
    public void update(int id, Customer customer) {
              repository.update(id, customer);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
