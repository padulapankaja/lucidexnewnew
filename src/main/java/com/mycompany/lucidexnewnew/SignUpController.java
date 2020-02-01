package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.mycompany.model.Users;
import com.mycompany.services.IUserService;
import com.mycompany.services.UserServiceIml;
import com.mycompany.util.DBConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author shesh
 */
public class SignUpController implements Initializable {

    @FXML
    private Label lblSgnIn;
    @FXML
    private Label lblUssername;
    @FXML
    private Label lblPassword;
    @FXML
    private TextField txtUsernameUp;
    @FXML
    private TextField txtEmailUp;
    @FXML
    private PasswordField txtPasswordUp;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private Label lblAlreadyAcc;
    @FXML
    private JFXButton btnff;
    @FXML
    private Label lblPassword1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        System.out.println("This is sign up");
        DBConnection conn = new DBConnection();
        conn.ConDB();
                System.out.println("Connecttojn wada ");

                
    }
    
    
    public void registerUser(){
        String name= txtUsernameUp.getText();
        String email = txtEmailUp.getText();
        String password = txtPasswordUp.getText();
        
        
        Users user = new Users();
        
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        
        IUserService userService = new UserServiceIml();
        
        userService.userRegister(user);
    
    }

}
