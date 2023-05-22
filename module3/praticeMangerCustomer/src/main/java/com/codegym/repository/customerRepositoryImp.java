package com.codegym.repository;

import com.codegym.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class customerRepositoryImp implements ICustomerRepository {
    private static final String SELECT_ALL = "select * from customer";
    private static final String SELECT_CUSTOMER_BY_ID = "select name , email , address from customer where id =?";
    public static final String INSERT_CUSTOMER = "insert into customer " + "(name , email , address) values" + "(?,?,?);";
    public static final String UPDATE_CUSTOMER_SQL = "update customer set name = ? , email = ? , address = ? where id = ?;";
    public static final String DELETE_FROM_CUSTOMER = "delete from customer where id = ?;";

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if(connection != null){
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL);
                resultSet = preparedStatement.executeQuery();
                Customer customer = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    customer = new Customer(id,name,email,address);
                    customerList.add(customer);
                }
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }

        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if(connection != null){
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
                preparedStatement.setInt(1,id);
                resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);
                while (resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    customer = new Customer(id,name,email,address);
                }
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return customer;
    }
    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection!= null){
            try {
                preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getEmail());
                preparedStatement.setString(3,customer.getAddress());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void update(int id, Customer customer) {
        Connection connection  = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null){
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getEmail());
                preparedStatement.setString(3, customer.getAddress());
                preparedStatement.setInt(4,id);
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void remove(int id) {
       Connection connection = DBConnection.getConnection();
       PreparedStatement preparedStatement = null;
       if (connection!= null){
           try {
               preparedStatement = connection.prepareStatement(DELETE_FROM_CUSTOMER);
               preparedStatement.setInt(1,id);
               System.out.println(preparedStatement);
               preparedStatement.executeUpdate();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
    }
}
