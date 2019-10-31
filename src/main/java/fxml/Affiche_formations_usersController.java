/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Domaine;
import entities.Formation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import services.DomaineService;
import services.FormationService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Affiche_formations_usersController implements Initializable {

    @FXML
    private JFXComboBox<String> domaine_combox;
    @FXML
    private TableView<Formation> Tab_formations;
    @FXML
    private TableColumn<Formation, String> titre;
    @FXML
    private TableColumn<Formation, Date> datedeb;
    @FXML
    private TableColumn<Formation, Date> datefin;
    private TableColumn<Formation, Integer> duree;
    @FXML
    private Button btn_consulte_formation;
    @FXML
    private JFXTextField recherche_formation_txt;
    @FXML
    private AnchorPane affch_formation_pane;
    
    static public Formation missionsel1;
     static      int i ;
    /**
     * Initializes the controller class.
     */
    DomaineService ds = new DomaineService();
    @FXML
    private TableColumn<Formation, String> entreprise_txt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ObservableList obs = FXCollections.observableArrayList(ds.getFormationType());
        domaine_combox.setItems(obs);
        // TODO
        ////////////////////////////////////////////////////
           FormationService f = new FormationService();
         ArrayList<Formation> r = f.afficherFormation();
          ObservableList<Formation> list =FXCollections.observableArrayList();
           for (int i=0 ;i<r.size();i++){
                 Formation c = new Formation(r.get(i).getRef(),r.get(i).getDomaine_id(),r.get(i).getNom(),r.get(i).getDescription(), r.get(i).getDuree(),r.get(i).getDate_debut(),r.get(i).getDate_fin(),r.get(i).getPrix(),r.get(i).getAdresse(),r.get(i).getEmail(),r.get(i).getContact());
         c.setNomentreprise(f.getentrepriseByID(r.get(i).getEntreprise_id()));

                       list.add(c);
        System.out.println(list);
                    }
            titre.setCellValueFactory(new PropertyValueFactory<Formation,String>("nom"));
   // consult.setCellValueFactory(new PropertyValueFactory<Formation,Button>("detail_btn"));
    datedeb.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_debut"));
   datefin.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_fin"));  
    entreprise_txt.setCellValueFactory(new PropertyValueFactory<Formation,String>("nomentreprise")); 
    Tab_formations.setItems(list);
    }    

    @FXML
    private void consulte_formation_action(ActionEvent event) throws IOException {
      //  missionsel1 = Tab_formations.getSelectionModel().getSelectedItem();
        missionsel1 = Tab_formations.getSelectionModel().getSelectedItem();
      i = Affiche_formations_usersController.missionsel1.getRef();
          Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/detail_inscrire_formation.fxml"));
     affch_formation_pane.getChildren().clear();
     affch_formation_pane.getChildren().add(root);
    }

    @FXML
    private void recherche_formation_action(KeyEvent event) {
        
         FormationService f = new FormationService();
     ArrayList<Formation> r = f.afficherFormation_Combo(domaine_combox.getValue());
      ArrayList<Formation> listf= new ArrayList<Formation>();
      Formation fo=null;
for (int i=0 ;i<r.size();i++){
    fo=r.get(i);
    if(fo.getNom().startsWith(recherche_formation_txt.getText()))
             listf.add(fo);
    
         
     }
          ObservableList<Formation> list =FXCollections.observableArrayList();
           for (int i=0 ;i<listf.size();i++){
                 Formation c = new Formation(listf.get(i).getRef(),listf.get(i).getEntreprise_id(),listf.get(i).getDomaine_id(),listf.get(i).getNom(),listf.get(i).getDescription(),listf.get(i).getDuree(),listf.get(i).getDate_debut(),listf.get(i).getDate_fin(),listf.get(i).getAdresse(),listf.get(i).getPrix(),listf.get(i).getContact(),listf.get(i).getEmail());
        c.setNomentreprise(f.getentrepriseByID(r.get(i).getEntreprise_id()));
                       list.add(c);
                    }
            titre.setCellValueFactory(new PropertyValueFactory<Formation,String>("nom"));
   // consult.setCellValueFactory(new PropertyValueFactory<Formation,Button>("detail_btn"));
    datedeb.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_debut"));
   datefin.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_fin")); 
   entreprise_txt.setCellValueFactory(new PropertyValueFactory<Formation,String>("nomentreprise")); 
    Tab_formations.setItems(list);
        /////////////////////////////////////////////////////////////
        /*
          ObservableList<Formation> data2 = FXCollections.observableArrayList();
                Formation e = new Formation();
        FormationService sc = new FormationService();
        List<Formation> Formation = sc.afficherFormation();
        data2= FXCollections.observableArrayList(Formation);
FilteredList<Formation> filterData = new FilteredList<>(data2, p -> true);
rechercher_txt.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
     filterData.setPredicate(pers -> {
                
                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedText = newvalue.toLowerCase();
         if (pers.getNom().toLowerCase().startsWith(typedText)) {
                    
                    return true;
                }
                
                
                return false;
            });
});
       SortedList<Formation> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(table_formation.comparatorProperty());
            table_formation.setItems(sortedList);
        */
        
    }

    @FXML
    private void domaine_combo_Action(ActionEvent event) {
     FormationService f = new FormationService();
     ArrayList<Formation> r = f.afficherFormation_Combo(domaine_combox.getValue());
     
          ObservableList<Formation> list =FXCollections.observableArrayList();
           for (int i=0 ;i<r.size();i++){
                 Formation c = new Formation(r.get(i).getRef(),r.get(i).getEntreprise_id(),r.get(i).getDomaine_id(),r.get(i).getNom(),r.get(i).getDescription(), r.get(i).getDuree(),r.get(i).getDate_debut(),r.get(i).getDate_fin(),r.get(i).getAdresse(),r.get(i).getPrix(),r.get(i).getContact(),r.get(i).getEmail());
        c.setNomentreprise(f.getentrepriseByID(r.get(i).getEntreprise_id()));
                       list.add(c);
                    }
            titre.setCellValueFactory(new PropertyValueFactory<Formation,String>("nom"));
   // consult.setCellValueFactory(new PropertyValueFactory<Formation,Button>("detail_btn"));
    datedeb.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_debut"));
   datefin.setCellValueFactory(new PropertyValueFactory<Formation,Date>("date_fin")); 
   entreprise_txt.setCellValueFactory(new PropertyValueFactory<Formation,String>("nomentreprise")); 

    Tab_formations.setItems(list);


        
        
    }
    
}
