/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Utilisateur;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceOffre;
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
    @FXML
    private ImageView imgphoto;
    
    int intarray[] = new int[20];

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
        
        
         if (Pattern.matches("[a-zA-Z]+", fnField.getText()) && fnField.getText().length() > 2) 
                nameicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                nameicon.setImage(new Image("/fxml/assets/error.png"));
         
                
        
    }

    @FXML
    private void emFieldv(KeyEvent event) {
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
    private void uploadImageAction(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        //FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        //fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showOpenDialog(uploadImg.getScene().getWindow());
        if(file != null){
            Image img = new Image(file.toURI().toString(),100,150,true,true);
            imgphoto.setImage(img);
            imgphoto.setFitWidth(200);
            imgphoto.setFitHeight(126);
            imgphoto.setPreserveRatio(true);
        }
        System.out.println(file);
        
    }

 /*   @FXML
    private void signupAction(ActionEvent event) {
        
       ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u = new Utilisateur(fnField.getText(), fnField.getText(), emField.getText(), "tounes", pnField.getText());
        
        System.out.println(su.ajouterUtilisateur(u));
        
    }*/
    
}