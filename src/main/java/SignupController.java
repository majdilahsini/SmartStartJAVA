/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Connection.ConnexionBD;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateur;
import entities.users;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import services.ServiceOffre;
import services.usersService;
//import services.ServiceUtilisateur;
import utils.Verification;




/**
 * FXML Controller class
 *
 * @author p
 */
public class SignupController implements Initializable {

    
    private File file;
    @FXML
    private Label error;
    private JFXTextField fnField;
    @FXML
    private JFXTextField pnField;
    @FXML
    private JFXTextField usrnField;
    @FXML
    private JFXPasswordField pwdField;
   
    @FXML
    private Hyperlink returntologin;
    @FXML
    private JFXButton singupBtn2;
    @FXML
    private ImageView usericon;
    @FXML
    private ImageView passicon;
    @FXML
    private ImageView nameicon;
    @FXML
    private ImageView mailicon;
    @FXML
    private ImageView telicon;
   
    
    int intarray[] = new int[20];
    @FXML
    private JFXTextField emailfield;
    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField adressefield;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void returntologinAction(ActionEvent event) throws IOException {
        
        Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(signUpPage);
        stage = (Stage)returntologin.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        
    }


    private void signupbtnAction(ActionEvent event) throws SQLException {
        
     
                
        
    }


    @FXML
    private void pnFieldv(KeyEvent event) {
    }

    @FXML
    private void usrnFieldv(KeyEvent event) {
        
        Verification v = new Verification();
         if (v.siUsernameExiste(usrnField.getText()) == 0 && usrnField.getText().length()>2) 

                usericon.setImage(new Image("/fxml/assets/ok.png"));
        else 
                usericon.setImage(new Image("/fxml/assets/error.png"));
                //System.out.println("0");
        
    }

    @FXML
    private void pwdFieldv(KeyEvent event) {
        
         if (pwdField.getText().length()>4) 
                passicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                passicon.setImage(new Image("/fxml/assets/error.png"));
         
    }

   
    @FXML
    private void signupAction(ActionEvent event) {
           Connection c= ConnexionBD.getInstanceConnexionBD().getConnection();
        usersService u= new usersService();
        users p =new users(usrnField.getText(),pwdField.getText(),emailfield.getText(),fullname.getText(),pnField.getText(),adressefield.getText(),"utilisateur");
        String s=u.ajouterUtilisateur(p);
       if (s.equals("vous ete inscrit"))
      showAlert(Alert.AlertType.INFORMATION, pwdField.getScene().getWindow(), 
    "succes!!", "utilisateur ajoutée");   
    
       else if(s.equals("non valide"))
       showAlert(Alert.AlertType.ERROR, pwdField.getScene().getWindow(), 
    "erreur", "utilisateur déja inscrit");
    
    }
    private void fnField(KeyEvent event) {
        
        
         if (Pattern.matches("[a-zA-Z]+", fnField.getText()) && fnField.getText().length() > 2 ) 
                nameicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                nameicon.setImage(new Image("/fxml/assets/error.png"));
         
    }

    @FXML
    private void emailfield(KeyEvent event) {
    }

    @FXML
    private void fullnamefield(KeyEvent event) {
    }

    @FXML
    private void Adressefield(KeyEvent event) {
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
    
}
}