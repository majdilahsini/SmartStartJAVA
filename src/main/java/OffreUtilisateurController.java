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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import utils.Getlists;
import utils.OfrreSession;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class OffreUtilisateurController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text id;
    @FXML
    private Text skills;
    @FXML
    private Text date;
    @FXML
    private Text nbr;
    @FXML
    private JFXButton voirplus;
    @FXML
    private Text entreprise;
    @FXML
    private Text domaine;
    @FXML
    private Text contrat;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void voirplusAction(ActionEvent event) throws IOException {
        
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/DetailsOffrePostulation.fxml"));
        borderpane.setCenter(root);*/
        OfrreSession.setId(Integer.parseInt(id.getText()));
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/DetailsOffrePostulation.fxml"));
        BorderPane bp;
        
        bp = (BorderPane) id.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
        bp.setCenter(root);
        
        
        
    }

    
}
