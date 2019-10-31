/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import entities.Formation;
import entities.Formation_user;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.FormationService;
import services.InscriptionService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Affich_inscriptionController implements Initializable {

    @FXML
    private TableView<Formation_user> tab_inscriscrptions;
    @FXML
    private TableColumn<Formation_user, String> nom_formation;
    @FXML
    private AnchorPane affich_inscription_pane;
    @FXML
    private TableColumn<Formation_user, String> nom_domaine;
    @FXML
    private TableColumn<Formation_user, Date> date_debut;
    @FXML
    private TableColumn<Formation_user, Date> date_fin;
    @FXML
    private TableColumn<Formation_user, Integer> duree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

 InscriptionService f = new InscriptionService();
 
         List<Formation_user> r = f.afficherFormation(2);
          ObservableList<Formation_user> list =FXCollections.observableArrayList();
          list.addAll(r);
        System.out.println(list);
                    
            nom_formation.setCellValueFactory(new PropertyValueFactory<Formation_user,String>("Nom_formation"));
   // consult.setCellValueFactory(new PropertyValueFactory<Formation,Button>("detail_btn"));
                        nom_domaine.setCellValueFactory(new PropertyValueFactory<Formation_user,String>("domaine"));
                     

    date_debut.setCellValueFactory(new PropertyValueFactory<Formation_user,Date>("date_debut"));
   date_fin.setCellValueFactory(new PropertyValueFactory<Formation_user,Date>("date_fin")); 
      duree.setCellValueFactory(new PropertyValueFactory<Formation_user,Integer>("Duree"));
    tab_inscriscrptions.setItems(list);
                   


    }



   
}
