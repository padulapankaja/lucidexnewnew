/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DBConnection {

    Connection conn = null;
    Statement stmt = null;

    public static Connection ConDB() {
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gametracking?characterEncoding=latin1", "root", "admin");

            System.out.println("Hey DB Connect Successfully");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Where is the MySQL JDBC Driver?" + ex);
        }
        return null;

    }

    //Method to update/delete/insert operation
    public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt;
        try {

            ConDB();
            stmt = ConDB().createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.err.println("Problem Occured at dbExecuteQuery operation" + e);
            throw e;
        }

    }

    //Method to retrive data from database
    public static ResultSet execQuery(String query) {
        Statement stmt;
        ResultSet rs = null;

        try {
            ConDB();
            stmt = ConDB().createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            System.err.println("Error occured in dbExecute operation");
        }
        return rs;
    }
}
