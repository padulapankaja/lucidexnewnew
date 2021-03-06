/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.Users;
import com.mycompany.util.DBConnection;
import com.mycompany.util.SqlScripts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserServiceIml implements IUserService {

    private static Connection connection;    //conncection object create
    private PreparedStatement preparedStatement;  //preparedStatement object create
    private SqlScripts sqlscripts; //sqlscripts object create

    //create user register function add to user's details to db
    @Override
    public boolean userRegister(Users user) {

        try {

            //create database connection
            connection = DBConnection.ConDB();
            preparedStatement = connection.prepareStatement(sqlscripts.INSERTUSERS);
            connection.setAutoCommit(false);
            //set valus to user object
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.execute();
            connection.commit();

            System.out.println("Add sucess");

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Add unsucessfully");
            return false;
        }

        return true;

    }

//    @Override
//    public boolean login(String username, String password) {
//        
//          Users user = new Users();
//        try {
//            
//            connection = DBConnection.ConDB();
//            preparedStatement = connection.prepareStatement(sqlscripts.INSERTUSERS);
//            connection.setAutoCommit(false); 
//            preparedStatement.setString( 1, user.getUserName());
//            preparedStatement.setString( 2, user.getEmail());
//            preparedStatement.setString( 3, user.getPassword());
//
//            preparedStatement.execute();
//            connection.commit();
//
//            System.out.println("Add sucess");
//
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);
//             System.out.println("Add unsucessfully");
//            return false;
//        }
//    
//             
//      
//      return true;
//    }
    //check user user availability 
    public int checkuseravailable(String username, String password) {

        int useravailable = 0;
        try {

            connection = DBConnection.ConDB();
            preparedStatement = connection.prepareStatement(sqlscripts.USERAVAILABLE);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            preparedStatement.execute();
            connection.commit();

            //get result
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                useravailable = resultSet.getInt(1);
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);

            return useravailable;
        }
        return useravailable;

    }

    public int getUserId(String userEmail) {
        int userId = 0;
        try {

            connection = DBConnection.ConDB();
            preparedStatement = connection.prepareStatement(sqlscripts.USERID);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, userEmail);

            preparedStatement.execute();
            connection.commit();

            //get result
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);

            return userId;
        }

        return userId;
    }

    public Users getuserfromName(String Username) {

        Users user = new Users();
        try {
            connection = DBConnection.ConDB();
            preparedStatement = connection.prepareStatement(sqlscripts.GETUSERFROMNAME);
            connection.setAutoCommit(false);
            preparedStatement.setString(1, Username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getInt(1));
                user.setUserName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
