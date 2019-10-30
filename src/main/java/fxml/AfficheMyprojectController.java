/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Projet;
import entities.Session;
import entities.myprojects;
import fxml.AfficheProjectsController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheMyprojectController implements Initializable {
static public myprojects missionsell;

    @FXML
    private TableView<myprojects> tableaffichemyprojet;
    @FXML
    private TableColumn<myprojects, String> nomprojet_cl;
    @FXML
    private TableColumn<myprojects, String> catregorie_cl;
    @FXML
    private TableColumn<myprojects, String> datedebu_cl;
    @FXML
    private TableColumn<myprojects, String> adresse_cln;
    @FXML
    private TableColumn<myprojects, String> comptbancaire_cl;
    @FXML
    private TableColumn<myprojects, String> emaimprojet_cl;
 ObservableList<myprojects> obser = FXCollections
            .observableArrayList();
    @FXML
    private JFXButton Afficherbutton;
    @FXML
    private JFXButton modifierbutton;
    @FXML
    private JFXButton Supprimerbutton;
    @FXML
    private AnchorPane afficheMyprojectpane;
    @FXML
    private AnchorPane affichePane;
    int id=0;
    @FXML
    
    private JFXButton ValideProjet;
    @FXML
    private JFXTextField Votrefinancetext;
    @FXML
    private JFXTextField nbreteamtext;
    @FXML
    private JFXTextField montanttext;
    @FXML
    private JFXTextField comptbancairetext;
    @FXML
    private JFXButton Annule2Projet;
    @FXML
    private JFXDatePicker datedebutprojet;
    @FXML
    private JFXTextField dureeprojet;
    @FXML
    private AnchorPane ajouteProjet2pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
       ServiceProjet s=new ServiceProjet();
        try {
            List<myprojects> list= s.AffichemyProjet(Session.getId());/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
             
            obser.addAll(list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nomprojet_cl.setCellValueFactory(new PropertyValueFactory<>("nomprojet"));
        catregorie_cl.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        datedebu_cl.setCellValueFactory(new PropertyValueFactory<>("dateDebutProjet"));
        adresse_cln.setCellValueFactory(new PropertyValueFactory<>("adresseProjet"));
        comptbancaire_cl.setCellValueFactory(new PropertyValueFactory<>("descriptionProjet"));
        emaimprojet_cl.setCellValueFactory(new PropertyValueFactory<>("emailProjet"));
        tableaffichemyprojet.setItems(obser);
    }    

    @FXML
    private void AfficherAction(ActionEvent event) throws SQLException, IOException {
   missionsell=tableaffichemyprojet.getSelectionModel().getSelectedItem();
      Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affichemyProjetVFinale.fxml"));
    
      afficheMyprojectpane.getChildren().clear();
      afficheMyprojectpane.getChildren().add(root);

    }

    @FXML
    private void modifierAction(ActionEvent event) throws SQLException, IOException {
    missionsell=tableaffichemyprojet.getSelectionModel().getSelectedItem();

        Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/modifierMyProjectVfFinale.fxml"));
    
      afficheMyprojectpane.getChildren().clear();
      afficheMyprojectpane.getChildren().add(root);
      
     /*ajouteprojet1pane.setVisible(true);
    affichePane.setVisible(false);
        ServiceProjet s=new ServiceProjet();
        Projet p=null;
        ObservableList<myprojects> show = tableaffichemyprojet.getSelectionModel().getSelectedItems();
        p=s.getProjet(show.get(0).getEmailProjet());
       id= p.getIdProjet();
       
          nptext.setText(p.getNomprojet());
        telptext.setText(Integer.toString(p.getTelProjet()));
         adtext.setText(p.getAdresseProjet());
          Dotext.setText(p.getDescriptionProjet());
         
        */
        
    }

    @FXML
    private void SupprimerAction(ActionEvent event) throws SQLException {
        
        ServiceProjet s=new ServiceProjet();
        Projet p=null;
        ObservableList<myprojects> show = tableaffichemyprojet.getSelectionModel().getSelectedItems();
        p=s.getProjet(show.get(0).getEmailProjet());
       id= p.getIdProjet();
       s.SupprimerProjet(id);
        id=0;
       
        
        

        
        
    }

  /*  private void Suivant1Action(ActionEvent event) throws SQLException {
         ServiceProjet s=new ServiceProjet();
        Projet p=null;
        ObservableList<myprojects> show = tableaffichemyprojet.getSelectionModel().getSelectedItems();
        p=s.getProjet(show.get(0).getEmailProjet());
       id= p.getIdProjet();
        ajouteProjet2pane.setVisible(true);
         ajouteprojet1pane.setVisible(false);
    affichePane.setVisible(false);
    Votrefinancetext.setText(Integer.toString(p.getVotreFinance()));
             nbreteamtext.setText(Integer.toString(p.getNbreTeam()));
              montanttext.setText(Long.toString( p.getMontant()));
               comptbancairetext.setText(Long.toString( p.getCompteBancaire()));
                dureeprojet.setText(Integer.toString(p.getDuree()));
        
    }

    private void annuler1Action(ActionEvent event) {
         ajouteProjet2pane.setVisible(false);
         ajouteprojet1pane.setVisible(false);
    affichePane.setVisible(true);
        
    }

    @FXML
    private void ValideProjetAction(ActionEvent event) throws SQLException {
        ServiceProjet s=new ServiceProjet();
         int i=  Integer.parseInt(telptext.getText());
     int i1=  Integer.parseInt(nbreteamtext.getText());

   int i2=  Integer.parseInt(dureeprojet.getText());
    int i3=  Integer.parseInt(Votrefinancetext.getText());
int i4=  Integer.parseInt(montanttext.getText());
int i5=  Integer.parseInt(comptbancairetext.getText());
List<String> l;
l=s.getCategcategoriesCombobox();
cattext.getItems().addAll(l);
        Projet p=new Projet();
        p.setIdProjet(id);
       p.setNomprojet(nptext.getText());
      p.setTelProjet(i);
     p.setEmailProjet(eptext.getText());
     p.setAdresseProjet(adtext.getText());
       p.setDescriptionProjet(Dotext.getText());
       p.setCategorie("informatique");
       p.setVotreFinance(i3);
        p.setNbreTeam(i1);
        p.setMontant(i4);
        p.setCompteBancaire(i5);
        
       p.setDateDebutProjet("01,06,2019");
        p.setDuree(i2);
        p.setId_enterprise(2);
s.ModifierProjet(p);




    }

    @FXML
    private void Annule2ProjetAction(ActionEvent event) {
         ajouteProjet2pane.setVisible(false);
         ajouteprojet1pane.setVisible(false);
    affichePane.setVisible(true);
    
    }

    */

    @FXML
    private void ValideProjetAction(ActionEvent event) {
    }

    @FXML
    private void Annule2ProjetAction(ActionEvent event) {
    }
}
