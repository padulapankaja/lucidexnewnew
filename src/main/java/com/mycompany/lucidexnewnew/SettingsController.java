package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author shesh
 */
public class SettingsController implements Initializable {

    @FXML
    private Label lblUSername;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPassword;
    @FXML
    private JFXButton btnShow;
    @FXML
    private Label lblLoginTime;
    @FXML
    private JFXButton bntSignOut;
    @FXML
    private JFXButton btnPersonalInfo;
    @FXML
    private JFXToggleButton tglGameAlerts;
    @FXML
    private JFXButton btnGameSettings;
    @FXML
    private JFXTextField lblCloseAlert;
    @FXML
    private JFXToggleButton tglGameClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
