package com.mycompany.lucidexnewnew;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import com.mycompany.model.UserAudit;
import com.mycompany.services.IUserAuditService;
import com.mycompany.services.IUserService;
import com.mycompany.services.UserAuditServiceIml;
import com.mycompany.services.UserServiceIml;
import com.mycompany.util.DBConnection;
import com.mycompany.util.UtilFunctions;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DBConnection conn = new DBConnection();
        conn.ConDB();

    }

    //handle login 
    @FXML
    private void loginhandler(ActionEvent event) throws IOException {

        UtilFunctions utilFunctions = new UtilFunctions();
        UserAudit useraudit = new UserAudit();
        //get user input
        String Username = txtUsername.getText();
        String Password = txtPassword.getText();

        //password hash
        String password = utilFunctions.get_SHA_256_SecurePassword(txtPassword.getText());

        IUserService userService = new UserServiceIml();
        IUserAuditService userAudit = new UserAuditServiceIml();

        //check user already exist
        int users = userService.checkuseravailable(Username, password);

        //if user valid map to main nav
        if (users > 0) {

            LocalDate currentTime = java.time.LocalDate.now();

           

            Calendar calendar = Calendar.getInstance();

            SimpleDateFormat formatter = new SimpleDateFormat("YYY-MM-DD HH:mm:ss");

            useraudit.setId(userService.getUserId(Username));
            useraudit.setDate(currentTime.toString());
            useraudit.setTime(formatter.format(calendar.getTime()));

            userAudit.lastLoginDetails(useraudit);

            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/MainNav.fxml")));
            scene.getStylesheets().add("/styles/mainnav.css");
            stage.setScene(scene);
            stage.show();
        } else {
            //if user invalid print error message
            JOptionPane.showMessageDialog(null, "Sorry You Have No Account ", "  " + "Warning  !", JOptionPane.INFORMATION_MESSAGE);
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }

    }

    //if user  did not have account then goto sign up
    @FXML
    private void gotosignup(ActionEvent event) {

        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            Scene scene = new Scene((Parent) FXMLLoader.load(getClass().getResource("/fxml/SignUp.fxml")));
            scene.getStylesheets().add("/styles/signUp.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
