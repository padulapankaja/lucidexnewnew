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
    @FXML
    private Label lblusernamreq;
    @FXML
    private Label lblemailreq;
    @FXML
    private Label lblpwdreq;

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
        int error = 0;
        UtilFunctions utilfunction = new UtilFunctions();  //create util class object
        IUserService userService = new UserServiceIml();

        //get user inputs
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";  //check email valid or not
        String name = txtUsernameUp.getText();
        String email = txtEmailUp.getText();
        String password = utilfunction.get_SHA_256_SecurePassword(txtPasswordUp.getText());  //password hash using SHA256 method

        //check user inputs null or not
        if (name.equalsIgnoreCase("")) {

            lblusernamreq.setText("required");
            error++;
        } else {
            lblusernamreq.setText("");
        }

        if (email.equalsIgnoreCase("")) {
            lblemailreq.setText("required");
            error++;

        } else {
            lblemailreq.setText("");
        }

        if (txtPasswordUp.getText().equalsIgnoreCase("")) {
            lblpwdreq.setText("required");
            error++;

        } else {
            lblpwdreq.setText(" ");
        }

        if (email.matches(regex)) {
            lblemailreq.setText("");
        } else {
            lblemailreq.setText("Invalid email");
            error++;
        }

        int users = userService.checkuseravailable(email, password);

        if (users > 0) {

            JOptionPane.showMessageDialog(null, "Hey " + name + "  Already you have account  ", " " + "Thank You !", JOptionPane.INFORMATION_MESSAGE);
            error++;

            //clear user inputs
            txtUsernameUp.setText("");
            txtEmailUp.setText("");
            txtPasswordUp.setText("");
            txtUsernameUp.requestFocus();

        }

        System.out.println("Users Count : " + users);

        System.out.println("Error Couunt : " + error);

        //if no any error create user object and set values
        if (error == 0) {
            Users user = new Users();  //create user object

            //add user inputs to user object
            user.setUserName(name);
            user.setEmail(email);
            user.setPassword(password);
            //create user servicce implementation objects

            boolean isUserRegister = userService.userRegister(user);
            //check user registration process is sucess or not
            if (isUserRegister == true) {
                JOptionPane.showMessageDialog(null, "Hey " + name + "  Welcome to Game Tracking System ", " " + "Thank You !", JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.showMessageDialog(null, "Something went to wrong !!", "  " + "Try Again !", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Please fill correctly !!", "  " + "Try Again !", JOptionPane.INFORMATION_MESSAGE);
        }

        if (error > 0) {
            JOptionPane.showMessageDialog(null, "Please fill correctly !!", "  " + "Try Again !", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //if already have and account then goto signin page
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
