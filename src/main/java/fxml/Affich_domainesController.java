/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import fxml.*;
import com.jfoenix.controls.JFXTextField;
import entities.Domaine;
import entities.Formation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.DomaineService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Affich_domainesController implements Initializable {

    @FXML
    private AnchorPane pane_domaine;
    @FXML
    private TableView<Domaine> tab_domaine;
    private TableColumn<Domaine, Integer> id_domaine_cln;
    @FXML
    private TableColumn<Domaine, String> nom_domaine_cln;
    @FXML
    private JFXTextField domaine_txt;
    @FXML
    private Button btn_ajouter_domaine;

    /**
     * Initializes the controller class.
     */
     DomaineService ds = new DomaineService();
    @FXML
    private AnchorPane majdi;
    @FXML
    private Button btn_retour_action;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
        Domaine i = new Domaine();
      
                 ObservableList<Domaine> data2 = FXCollections.observableArrayList();
        List<Domaine> domaines = ds.affichercategories(2);
        data2= FXCollections.observableArrayList(domaines);
         
           
         nom_domaine_cln.setCellValueFactory(new PropertyValueFactory<Domaine,String>("nom_domaine"));
           tab_domaine.setItems(data2);
        
    }    

    @FXML
    private void ajouter_domaine_action(ActionEvent event) throws SQLException, IOException {
         Domaine d = new Domaine(2,domaine_txt.getText());
           ds.creerDomaine(d);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Domaine insérée avec succés!");
        alert.show();
        Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affich_domaines.fxml"));
     majdi.getChildren().clear();
     majdi.getChildren().add(root);
        
        
    }

    @FXML
    private void retour_domaine_action(ActionEvent event) throws IOException {
         Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affich_mes_formation.fxml"));
     majdi.getChildren().clear();
     majdi.getChildren().add(root);
    }
    
}
