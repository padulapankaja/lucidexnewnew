package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.util.UtilFunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JButton;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

/**
 * FXML Controller class
 *
 * @author shesh
 */
public class AllGamesController implements Initializable {

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }
    
    
         
    private void addgame(ActionEvent event) {
            
       
   
            

        
        try {
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
//            stage.close();
//            
//            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/AddGame.fxml")));
//            scene.getStylesheets().add("/styles/addgame.css");
//            stage.setScene(scene);
//            stage.show();
            
            
            
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/fxml/AddGame.fxml"));
            
            /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene((Parent) fxmlLoader.load(), 1085, 768);
            scene.getStylesheets().add("/styles/addgame.css");
            Stage stage = new Stage();
            stage.setTitle("AddGame");
            stage.setScene(scene);
           // stage.initStyle(StageStyle.UNDECORATED);
             stage.resizableProperty().setValue(false);


            stage.show();
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(AllGamesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

        
        
        
        
        
    

}
