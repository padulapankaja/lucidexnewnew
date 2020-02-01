/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author User
 */
public class UtilFunctions {
    
     public void loadPage(String page, BorderPane bp) {
        try {
            Parent root;

            root = FXMLLoader.load(getClass().getResource("/fxml/" + page + ".fxml"));

            bp.setCenter(root);
        } catch (IOException ex) {
            System.out.println("com.mycompany.util.UtilFunctions.loadPage()" +ex);
        }

    }
     
     
     
}
