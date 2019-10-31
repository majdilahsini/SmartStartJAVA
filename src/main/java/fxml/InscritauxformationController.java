/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;


import fxml.*;
import entities.Formation;
import entities.Inscription;
import entities.Utilisateur;
import entities.inscrits_formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.InscriptionService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class InscritauxformationController implements Initializable {

    @FXML
    private AnchorPane pane_inscri_formation;
    private Button btn_retour_inscrip;
    @FXML
    private TableView<inscrits_formation> tab_inscri_formation;
    @FXML
    private TableColumn<inscrits_formation, String> nom_inscri;
   
    @FXML
    private TableColumn<inscrits_formation, Integer> tel_inscri;
    @FXML
    private TableColumn<inscrits_formation, String> nom_formation;
    @FXML
    private TableColumn<inscrits_formation, String> lettre_inscri;
    @FXML
    private Button btn_retour_inscp;
    @FXML
    private AnchorPane firas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        InscriptionService f = new InscriptionService();
 
         List<inscrits_formation> r = f.afficher_inscrit_Formation(2);
          ObservableList<inscrits_formation> list =FXCollections.observableArrayList();
          list.addAll(r);
        System.out.println(list);
      
               

        nom_inscri.setCellValueFactory(new PropertyValueFactory<inscrits_formation,String>("Nom"));
    
       
       
         tel_inscri.setCellValueFactory(new PropertyValueFactory<inscrits_formation,Integer>("telephone"));
         nom_formation.setCellValueFactory(new PropertyValueFactory<inscrits_formation,String>("Nom_formation"));
            lettre_inscri.setCellValueFactory(new PropertyValueFactory<inscrits_formation,String>("lettre_motivation"));

          
            tab_inscri_formation.setItems(list);
        // TODO
    }    

    @FXML
    private void retour_inscri_action(ActionEvent event) throws IOException {
        Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affich_mes_formation.fxml"));
     firas.getChildren().clear();
     firas.getChildren().add(root);
    }
   
    
}
