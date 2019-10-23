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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class MainWindowUtilisateurController implements Initializable {
    
    private Label label;
    @FXML
    private JFXButton monespacebtn;
    @FXML
    private JFXButton offrebtn;
    @FXML
    private JFXButton formationbtn;
    @FXML
    private Pane indicateur;
    @FXML
    private JFXButton forumbtn;
    @FXML
    private JFXButton crowdbtn;
    @FXML
    private JFXButton accueilbtn;
    @FXML
    private JFXButton deconnect;
    @FXML
    private BorderPane borderpane;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                       // pane_formation.setVisible(false);

        // TODO
    }    

    private void redirect(ActionEvent event) throws IOException {
       
    }

    private void fermer(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void monespaceAction(ActionEvent event) {
        indicateur.setLayoutY(monespacebtn.getLayoutY()+10);
    }

    @FXML
    private void OffreMenuAction(ActionEvent event) {
        indicateur.setLayoutY(offrebtn.getLayoutY()+10);
        
    }
    
    @FXML
    private void FormationMenuAction(ActionEvent event) {

        indicateur.setLayoutY(formationbtn.getLayoutY()+10);
         /*if (event.getTarget() == formationbtn) {
             pane_formation.setVisible(true);
            
             }*/
          
    }

    @FXML
    private void forumMenuAction(ActionEvent event) {
        indicateur.setLayoutY(forumbtn.getLayoutY()+10);
    }

    @FXML
    private void crowdmenuAction(ActionEvent event) {
        indicateur.setLayoutY(crowdbtn.getLayoutY()+10);
    }

    @FXML
    private void accueilAction(ActionEvent event) throws IOException {
        indicateur.setLayoutY(accueilbtn.getLayoutY()+10);
        //Stage stage;
        //window.clearConstraints();
        //stage = (Stage)deconnect.getScene().getWindow();
        //window.clearConstraints(window);
         Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
         borderpane.setCenter(root);
    }

    @FXML
    private void returntologin(ActionEvent event) throws IOException {
        
        //AnchorPane anchorpane;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml"));
        //Scene scene = new Scene(root);
        //anchorpane = (Stage)deconnect.getScene().getWindow();
        //anchorpane.hide();
        borderpane.setCenter(root);
        
    }


    
}
