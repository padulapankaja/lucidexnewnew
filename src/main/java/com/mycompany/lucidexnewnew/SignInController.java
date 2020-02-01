package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shesh
 */
public class SignInController implements Initializable {

    @FXML
    private Label lblSgnIn;
    @FXML
    private Label lblUssername;
    @FXML
    private Label lblPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private JFXButton btnSignIn;
    @FXML
    private JFXButton btnForgot;
    @FXML
    private Label lblCreatAcc;
    @FXML
    private JFXButton btnCreatAcc;
    @FXML
    private ImageView signframe;

    /**
     * Initializes the controller class.
     */
    
    
     @FXML
    private void loginhandler(ActionEvent event) throws IOException {
       
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

                Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/MainNav.fxml")));
                scene.getStylesheets().add("/styles/mainnav.css");
                stage.setScene(scene);
                stage.show();

         
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
   

}
