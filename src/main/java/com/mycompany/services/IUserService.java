/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.model.Users;

/**
 *
 * @author User
 */
public interface IUserService {
    //user registration function
    public boolean userRegister(Users user);
}
