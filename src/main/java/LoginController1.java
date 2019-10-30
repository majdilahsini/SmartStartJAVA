/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.loginservice;
import services.usersService;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class LoginController1 implements Initializable {

    @FXML
    private JFXButton loginbtn;
    @FXML
    private Hyperlink fgtPwdLink;
    @FXML
    private JFXTextField loginField;
    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private JFXButton normaluser;
    @FXML
    private JFXButton entrepriseinscrit;
    @FXML
    private Hyperlink adminlogin;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginbtnAction(ActionEvent event) throws IOException, SQLException {
        
     if (loginField.getText().isEmpty()||pwdField.getText().isEmpty()){
               showAlert(Alert.AlertType.ERROR, pwdField.getScene().getWindow(), 
    "Form Error!", "Veuillez remplir tous les champs!");
         
         }
         usersService c=new usersService();
            String s=c.validerLogin(loginField.getText(),pwdField.getText());
 
         // validation.setText( s);
        if(s.equals("utilisateur n'existe pas ")){
                showAlert(Alert.AlertType.ERROR, pwdField.getScene().getWindow(), 
    "Form Error!", "utilisateur n'existepas");
        }
        else if(s.equals("utilisateur correct ")){
                
        
            String a=c.getRole(loginField.getText());
            
          Session.id=c.getIdUtilisateur(loginField.getText(),pwdField.getText());
          
          Session.role=c.getRole(loginField.getText());
          System.out.println(a);
          String b="utilisateur";
          String h="entreprise";
           // System.out.println(Session.id_utilisateur);
            if (a.compareTo(b)==0){
            Stage stage;
            Parent mainutil = FXMLLoader.load(getClass().getResource("/fxml/MainWindowUtilisateur.fxml"));
            Scene scene = new Scene(mainutil);
            stage = (Stage)loginField.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();
  
            }
            if (a.compareTo(h)==0){
            Stage stage;
            Parent mainE= FXMLLoader.load(getClass().getResource("/fxml/MainWindowEntreprise.fxml"));
            Scene scene = new Scene(mainE);
            stage = (Stage)loginField.getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.show();

            }
          }
           
    
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
    private void verifentry(KeyEvent event) {
    }

    @FXML
    private void checkentry(KeyEvent event) {
    }

    @FXML
    private void signuputilisateur(ActionEvent event) throws IOException {
        Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml"));
        // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)loginField.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void entreprisebtn(ActionEvent event) throws IOException  {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/SignupE.fxml"));
            Parent root =loader.load();
            Scene tableViewScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
            window.setScene(tableViewScene);
            window.show();
            
    }

    @FXML
    private void recovery(ActionEvent event) throws IOException {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/passrecovery.fxml"));
            Parent root =loader.load();
            Scene tableViewScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void paneladmin(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/panelloginadmin.fxml"));
            Parent root =loader.load();
            Scene tableViewScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
            window.setScene(tableViewScene);
            window.show();
    }
    
}
