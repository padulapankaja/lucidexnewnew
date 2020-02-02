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
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import com.mycompany.util.UtilFunctions;

/**
 * FXML Controller class
 *
 * @author shesh
 */
public class MainNavController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnGames;
    @FXML
    private JFXButton btnPlayTime;
    @FXML
    private JFXButton btnHelp;
    @FXML
    private JFXButton btnSettings;
    @FXML
    private AnchorPane ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
 

    @FXML
    private void gohome(ActionEvent event) {
        
             bp.setCenter(ap);
//         loadPage("AllGames");
//         btnHome.requestFocus();

    }
    
    UtilFunctions kk = new UtilFunctions();
    

    @FXML
    private void gogames(ActionEvent event) {
          kk.loadPage("AllGames",  bp);
             btnGames.requestFocus();
    }

    @FXML
    private void goplaytimes(ActionEvent event) {
          kk.loadPage("AllGames",  bp);
         btnPlayTime.requestFocus();
    }

    @FXML
    private void gohelp(ActionEvent event) {
          kk.loadPage("Help", bp);
          btnHelp.requestFocus();
    }

    @FXML
    private void gosettings(ActionEvent event) {
          kk.loadPage("Settings",  bp);
            btnSettings.requestFocus();
    }

}
