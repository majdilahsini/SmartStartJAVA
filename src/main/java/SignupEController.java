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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.usersService;
import utils.Verification;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class SignupEController implements Initializable {

    @FXML
    private Label error;
    private JFXTextField fnField;
    private JFXTextField emField;
    private JFXTextField pnField;
    @FXML
    private JFXTextField usrnField;
    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private JFXButton singupBtn2;
    @FXML
    private Hyperlink returntologin;
    private JFXTextField pnField1;
    @FXML
    private JFXTextField emailfield;
    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField fonenumberfield;
    @FXML
    private JFXTextField adresse;
    @FXML
    private ImageView usericon;
    @FXML
    private ImageView telicon;
    @FXML
    private ImageView fullicon;
    @FXML
    private ImageView emailicon;
    @FXML
    private ImageView passicon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void signupentreprise(ActionEvent event) {
        Connection c= ConnexionBD.getInstanceConnexionBD().getConnection();
        usersService u= new usersService();
        users p =new users(usrnField.getText(),pwdField.getText(),emailfield.getText(),fullname.getText(),fonenumberfield.getText(),adresse.getText(),"entreprise");
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
    private void returntologinAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/Login_1.fxml"));
        Scene scene = new Scene(signUpPage);
        stage = (Stage)returntologin.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
       
    }



    @FXML
    private void usrnFieldv(KeyEvent event) {
         Verification v = new Verification();
         if (v.siUsernameExiste(usrnField.getText()) == 0 && usrnField.getText().length()>2) 

                usericon.setImage(new Image("/fxml/assets/ok.png"));
        else 
                usericon.setImage(new Image("/fxml/assets/error.png"));
    }

    @FXML
    private void pwdFieldv(KeyEvent event) {
         if (pwdField.getText().length()>4) 
                passicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                passicon.setImage(new Image("/fxml/assets/error.png"));
    }

    @FXML
    private void emailfield(KeyEvent event) {
          Verification v = new Verification();
         Verification e = new Verification();
          if (v.siEmailExiste(emailfield.getText()) == 0 && emailfield.getText().length()>2 && e.isValid(emailfield.getText()) ) 

                emailicon.setImage(new Image("/fxml/assets/ok.png"));
        else 
                emailicon.setImage(new Image("/fxml/assets/error.png"));
    }

    @FXML
    private void fullname(KeyEvent event) {
         if (fullname.getText().length() > 2 ) 
                fullicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                fullicon.setImage(new Image("/fxml/assets/error.png"));
    }

    @FXML
    private void fonenumberfield(KeyEvent event) {
          if (Pattern.matches("[+]+[0-9]+", fonenumberfield.getText()) && fonenumberfield.getText().length() == 12 ) 
               telicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                telicon.setImage(new Image("/fxml/assets/error.png"));
    }
    
}
