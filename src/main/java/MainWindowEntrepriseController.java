/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class MainWindowEntrepriseController implements Initializable {

    @FXML
    private JFXButton Quit;
    @FXML
    private JFXButton deconnect2;
    @FXML
    private TitledPane monespace;
    @FXML
    private JFXButton deconnect1;
    @FXML
    private JFXButton deconnect1111;
    @FXML
    private JFXButton mes_formations_btn;
    @FXML
    private TitledPane offrebtn;
    @FXML
    private JFXButton creeroffre;
    @FXML
    private JFXButton mesoffres;
    @FXML
    private JFXButton creer_formation_btn;
    @FXML
    private JFXButton afficher_formation_btn;
    @FXML
    private JFXButton deconnect1213;
    @FXML
    private JFXButton deconnect11111;
    @FXML
    private BorderPane borderpane;
    @FXML
    private JFXButton ajoutersujet;
    @FXML
    private JFXButton forum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void quitAction(ActionEvent event) {
          Stage stage = (Stage) Quit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void returntologin(ActionEvent event) throws IOException {
          /* Stage stage;
      //  Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/Forum.fxml"));
       // borderpane.setCenter(signUpPage);
        Scene scene = new Scene(signUpPage);
        stage = (Stage)Quit.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();*/
           
     //   Parent root = FXMLLoader.load(getClass().getResource("/fxml/LesOffres.fxml"));
    }

    @FXML
    private void afficher_mesformation_action(ActionEvent event) {
    }

    @FXML
    private void createoffreAction(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/fxml/AjouterOffre.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void mesoffresAction(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/MesOffre.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void offrebtnAction(MouseEvent event) {
    }

    @FXML
    private void creer_formation_action(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/fxml/ajoutformation.fxml"));
        borderpane.setCenter(root);
    }

    @FXML
    private void afficher_formation_action(ActionEvent event) {
    }

    @FXML
    private void ajoutersujet(ActionEvent event) {
    }

    @FXML
    private void forumAction(ActionEvent event) throws IOException {
        
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/Forum.fxml"));
        borderpane.setCenter(signUpPage);
    }
    
}
