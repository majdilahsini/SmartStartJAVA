/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author p
 */
public class SignupController implements Initializable {

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
    private JFXButton uploadImg;
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

    /*
     * Initializes the controller class.
     */
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

    @FXML
    private void uploadImage(ActionEvent event) {
    }

    @FXML
    private void signupbtnAction(ActionEvent event) throws IOException {
        
        Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/MainWindowUtilisateur.fxml"));
        Scene scene = new Scene(signUpPage);
        stage = (Stage)singupBtn2.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
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
        
         if (usrnField.getText().length()>4) 
                usericon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                usericon.setImage(new Image("/fxml/assets/error.png"));
        
    }

    @FXML
    private void pwdFieldv(KeyEvent event) {
        
 
        
    }
    
}
