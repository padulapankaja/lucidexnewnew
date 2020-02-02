/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author User
 */
public class UtilFunctions {
    
    //create page load function to load pages from btn clicks
     public void loadPage(String page, BorderPane bp) {
        try {
            Parent root;

            root = FXMLLoader.load(getClass().getResource("/fxml/" + page + ".fxml"));

            bp.setCenter(root);
        } catch (IOException ex) {
            System.out.println("com.mycompany.util.UtilFunctions.loadPage()" +ex);
        }

    }
     //password hash function
     	public static String get_SHA_256_SecurePassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
     
}
