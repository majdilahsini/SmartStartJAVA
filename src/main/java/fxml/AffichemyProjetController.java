/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXButton;
import entities.Projet;
import entities.myprojects;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffichemyProjetController implements Initializable {

    @FXML
    private AnchorPane anchpaneafficheprojects2;
    @FXML
    private Label NomProjetLabel;
    @FXML
    private Label categorielabel;
    @FXML
    private Label adresseprojet;
    @FXML
    private Label emaillabel;
    @FXML
    private Label descriptionlabel;
    @FXML
    private JFXButton retourbutton1;
    @FXML
    private ImageView imageaffiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ////////////////////////////////////////////////////////////////////////////////////////////:::::::::
         myprojects p= AfficheMyprojectController.missionsell;

        NomProjetLabel.setText( "");
        categorielabel.setText( "");
        adresseprojet.setText( "");
        emaillabel.setText( "");
        descriptionlabel.setText( "");
       ServiceProjet s=new ServiceProjet();
       Projet p1 = null;
        try {
            p1 = s.getProjet(p.getEmailProjet());
        } catch (SQLException ex) {
            Logger.getLogger(AffichemyProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(p1.getImage());
        
        //System.out.println(p1.getImage());
       //Image im=new Image(p1.getImage());
        
       //imageaffiche.setImage(im);
        NomProjetLabel.setText( p.getNomprojet());
        categorielabel.setText( p.getCategorie());
        adresseprojet.setText( p.getAdresseProjet());
        emaillabel.setText( p.getEmailProjet());
        descriptionlabel.setText( p.getDescriptionProjet());
    }    

    @FXML
    private void retourAction(ActionEvent event) throws IOException {
        Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/afficheMyproject.fxml"));
    
      anchpaneafficheprojects2.getChildren().clear();
      anchpaneafficheprojects2.getChildren().add(root);
        
        
        
    }

    
}
