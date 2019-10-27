/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Connection.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.users;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;
import services.usersService;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class SignupEController implements Initializable {

    @FXML
    private Label error;
    @FXML
    private JFXTextField fnField;
    @FXML
    private JFXTextField emField;
    @FXML
    private JFXTextField pnField;
    @FXML
    private JFXTextField usrnField;
    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private JFXButton singupBtn2;
    @FXML
    private Hyperlink returntologin;
    @FXML
    private JFXTextField pnField1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnField(KeyEvent event) {
    }

    @FXML
    private void emFieldv(KeyEvent event) {
    }

    @FXML
    private void pnFieldv(KeyEvent event) {
    }

    @FXML
    private void usrnFieldv(KeyEvent event) {
    }

    @FXML
    private void pwdFieldv(KeyEvent event) {
    }

    @FXML
    private void signupentreprise(ActionEvent event) {
        Connection c= ConnexionBD.getInstanceConnexionBD().getConnection();
        usersService u= new usersService();
        users p =new users(usrnField.getText(),pwdField.getText(),fnField.getText(),emField.getText(),pnField.getText(),pnField1.getText(),"entreprise");
        String s=u.ajouterUtilisateur(p);
       if (s.equals("vous ete inscrit"))
      showAlert(Alert.AlertType.INFORMATION, pwdField.getScene().getWindow(), 
    "succes!!", "utilisateur ajoutée");   
    
       else if(s.equals("non valide"))
       showAlert(Alert.AlertType.ERROR, pwdField.getScene().getWindow(), 
    "erreur", "utilisateur déja inscrit");
    
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    
}

    @FXML
    private void returntologinAction(ActionEvent event) {
    }
    
}
