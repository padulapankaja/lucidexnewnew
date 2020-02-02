/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.UserAudit;
import com.mycompany.util.DBConnection;
import com.mycompany.util.SqlScripts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserAuditServiceIml implements IUserAuditService{

    private static Connection connection;    //conncection object create
    private PreparedStatement preparedStatement;  //preparedStatement object create
    private SqlScripts sqlscripts; //sqlscripts object create
    @Override
    
    public boolean lastLoginDetails(UserAudit useraudit) {
        
        
        
           try {

            //create database connection
            connection = DBConnection.ConDB();
            preparedStatement = connection.prepareStatement(sqlscripts.USERAUDITINSERT);
            connection.setAutoCommit(false);
            //set valus to user object
            preparedStatement.setInt(1, useraudit.getId());
            preparedStatement.setString(2, useraudit.getDate());
            preparedStatement.setString(3, useraudit.getTime());

            preparedStatement.execute();
            connection.commit();

            System.out.println("Add sucess user udit");

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceIml.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Add unsucessfully");
            return false;
        }

        return true;
        
    }
    
}
