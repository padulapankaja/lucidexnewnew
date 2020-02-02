package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXButton;
import com.mycompany.model.Users;
import com.mycompany.services.IUserService;
import com.mycompany.services.UserServiceIml;
import com.mycompany.util.DBConnection;
import com.mycompany.util.UtilFunctions;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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

    //Signup btn functoin
    @FXML
    public void registerUser(ActionEvent event) throws IOException {

        UtilFunctions utilfunction = new UtilFunctions();  //create util class object

        //get user inputs
        String name = txtUsernameUp.getText();
        String email = txtEmailUp.getText();
        String password = utilfunction.get_SHA_256_SecurePassword(txtPasswordUp.getText());  //password hash using SHA256 method

        Users user = new Users();  //create user object

        //add user inputs to user object
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        //create user servicce implementation objects
        IUserService userService = new UserServiceIml();

        boolean isUserRegister = userService.userRegister(user);

        //check user registration process is sucess or not
        if (isUserRegister == true) {

            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

                Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/SignIn.fxml")));
                scene.getStylesheets().add("/styles/mainnav.css");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Invalid Credentials", "InfoBox: " + "Warning !", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    @FXML
    private void gotoSign(ActionEvent event) {
        
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/SignIn.fxml")));
            scene.getStylesheets().add("/styles/mainnav.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
