/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lucidexnewnew;

import com.mycompany.model.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {

    Users user = new Users();
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        username.setText("Hi " +user.getUserName() + " This is time to track your playing time");
        
        System.out.println("User Email : -" +user.getUserName());
    //    System.out.println(user.getEmail());

        
    }    
    
    
}
