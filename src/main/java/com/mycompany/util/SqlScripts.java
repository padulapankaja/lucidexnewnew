/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

/**
 *
 * @author User
 */
public class SqlScripts {

    //user insert
    public static final String INSERTUSERS = "INSERT INTO users(UserName, UserEmail, UserPassword) VALUES(?, ?, ?)";

    //check user already have account or not (signin and signup purposes)
    public static final String USERAVAILABLE = "Select count(*) from users where UserEmail = ? and UserPassword = ? ;";
    
    
        public static final String USERID = "select Id from users where UserEmail = ? ";

    
    public static final String USERAUDITINSERT = "INSERT INTO useraudit (uid, date, time) VALUES ( ? , ? , ?)";
    
    public static final String GETUSERFROMNAME = " Select * from users where UserEmail = ? ";


    
    
    
    
    
    

}
