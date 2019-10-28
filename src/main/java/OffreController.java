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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class OffreController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text date;
    @FXML
    private Text nbr;
    @FXML
    private Text id;
    @FXML
    private JFXButton voirplus;
    @FXML
    private Text entreprise;
    @FXML
    private Text domaine;
    @FXML
    private Text skills;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    private void supprimeroffreAction(ActionEvent event) throws IOException {
        
        ServiceOffre so = new ServiceOffre();
        so.supprimerOffre(Integer.parseInt(id.getText()));
     }

    @FXML
    private void voirplusAction(ActionEvent event) {
        
        
        
    }
    
}
