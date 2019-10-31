/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Connection.DBConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Formation;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.FormationService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Affich_mes_formationController implements Initializable {

    @FXML
    private AnchorPane formation_afficher1;
    @FXML
    private TableView<Formation> table_formation;
    @FXML
    private TableColumn<Formation, String> titre_formation;
 ////   @FXML
  //  private TableColumn<Formation, Button> consult;
 ////   @FXML
  //  private TableColumn<Formation, Button> sup;
  //  @FXML
  //  private TableColumn<Formation, Button> modif;
    private Button btn_lien_ajout_formation;
    private Button btn_lien_rech_formation;
     static public Formation missionsel1;
   static      int i ;


    /**
     * Initializes the controller class.
     */
      private static Connection conn;
       DBConnection db = DBConnection.getInstance();
    @FXML
    private Button suuprimer_btn;
    @FXML
    private Button detail_btn;
    @FXML
    private TableColumn<Formation, Button> date_deb;
    @FXML
    private TableColumn<Formation, Button> date_fin;
    @FXML
    private JFXTextField rechercher_txt;
    @FXML
    private Button btn_lien_inscri_formation;
    @FXML
    private Button btn_categorie_formation1;
   
    @FXML
    private AnchorPane koussay2;
    @FXML
    private TableColumn<Formation, Integer> nbres_inscrits;
  
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FormationService f = new FormationService();
         ArrayList<Formation> r = f.affichermesFormation(12);
          ObservableList<Formation> list =FXCollections.observableArrayList();
           for (int i=0 ;i<r.size();i++){
                 Formation c = new Formation(r.get(i).getRef(),r.get(i).getEntreprise_id(),r.get(i).getDomaine_id(),r.get(i).getNom(),r.get(i).getDescription(), r.get(i).getDuree(),r.get(i).getDate_debut(),r.get(i).getDate_fin(),r.get(i).getAdresse(),r.get(i).getPrix(),r.get(i).getContact(),r.get(i).getEmail(),r.get(i).getNbres_inscrits());
     
                       list.add(c);
        System.out.println(list);
                    }
            titre_formation.setCellValueFactory(new PropertyValueFactory<Formation,String>("Nom"));
    date_deb.setCellValueFactory(new PropertyValueFactory<Formation,Button>("date_debut"));
   date_fin.setCellValueFactory(new PropertyValueFactory<Formation,Button>("date_fin")); 
      nbres_inscrits.setCellValueFactory(new PropertyValueFactory<Formation,Integer>("Nbres_inscrits")); 

    table_formation.setItems(list);
                   
           }
          
    

   

  


  

    @FXML
    private void supprimer_action(ActionEvent event) throws IOException {
        /*       ObservableList<Formation> selectedRows, allFormation;
               
        allFormation = table_formation.getItems();
        selectedRows=table_formation.getSelectionModel().getSelectedItems();
        FormationService p=new FormationService();
        for(Formation formation :selectedRows){
            allFormation.remove(formation);
         
        p.supprimerFormation(formation);*/
        FormationService es = new FormationService(); 
     Formation ent = table_formation.getSelectionModel().getSelectedItem();
     int ref = ent.getRef();
     es.deleteEnt(ref);
        JOptionPane.showMessageDialog(null, "supprimer");
         Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affich_mes_formation.fxml"));
     koussay2.getChildren().clear();
     koussay2.getChildren().add(root);
      //      Alert alert = new Alert(Alert.AlertType.WARNING);
    //    alert.setTitle("Information Dialog");
    //    alert.setHeaderText(null);
    //    alert.setContentText("Formation supprimé!");
    //    alert.show();
    }
    

    @FXML
    private void detail_action(ActionEvent event)throws IOException {
       missionsel1 = table_formation.getSelectionModel().getSelectedItem();
      i = Affich_mes_formationController.missionsel1.getRef();
    Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/detail_mes_formations.fxml"));
     koussay2.getChildren().clear();
     koussay2.getChildren().add(root);
      // FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/details_formation.fxml"));
       // Parent root;

       // root = loader.load();
     //   detail_btn.getScene().setRoot(root);
    
    }

    @FXML
    private void rechercherff(KeyEvent event) {
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
        }

    @FXML
    private void lien_inscri_action(ActionEvent event) throws IOException {
     Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/inscritauxformation.fxml"));
     koussay2.getChildren().clear();
     koussay2.getChildren().add(root);
    }

  

  

    @FXML
    private void lien_domaine_action(ActionEvent event) throws IOException {
            Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affich_domaines.fxml"));
     koussay2.getChildren().clear();
     koussay2.getChildren().add(root);
    }
}
    
 
    
    