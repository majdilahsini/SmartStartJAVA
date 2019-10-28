/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Offre;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.ServiceApplication;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class MesOffreController implements Initializable {

    @FXML
    private VBox vbx;
    @FXML
    private ScrollPane a;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent root2;
        try {
            
           
            ServiceOffre o = new ServiceOffre();
            ServiceApplication a = new ServiceApplication ();
            for (Offre e: o.AfficherOffresByEntreprise(Session.getId())) {
                root2 = FXMLLoader.load(getClass().getResource("/fxml/Offre.fxml"));
                Text t = (Text) root2.lookup("#nom");
                t.setText(e.getTitre());
                Text t2 = (Text) root2.lookup("#id");
                t2.setText(Integer.toString(e.getId()));
                Text nbr = (Text) root2.lookup("#nbr");
                nbr.setText(Integer.toString(a.NbrApplicationOffre(e.getId()))+ " Candidatures");
                Text date = (Text) root2.lookup("#date");
                date.setText("Publié le "+e.getDate_publication());
                
                vbx.getChildren().add(root2);
            }


        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    
}
