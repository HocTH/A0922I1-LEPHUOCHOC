package com.example.usermanager.dao;

import com.example.usermanager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
   User selectUser(int id);
   List<User> selectAllUsers();
   List<User> search();
   boolean deleteUser(int id) throws SQLException;
   boolean updateUser(User user) throws SQLException;
   User getUserById(int id);
   void insertUserStore(User user) throws SQLException;
   void addUserTransaction(User user, int[] permision);
   public void insertUpdateWithoutTransaction();
   public void insertUpdateUseTransaction();
   List<User> selectAllUsersPro();
   boolean updateUserSQL(User user) throws SQLException;
   boolean deleteUserSQL(int id) throws SQLException;
}
