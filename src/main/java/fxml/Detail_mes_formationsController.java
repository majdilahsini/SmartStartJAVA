package fxml;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fxml.Affich_formationController;
import entities.Formation;
import fxml.Affich_formationController;
import fxml.Affich_mes_formationController;
import fxml.Affich_mes_formationController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import services.FormationService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Detail_mes_formationsController implements Initializable {

    @FXML
    private Button btn_retour_formation;
    @FXML
    private Label titre;
    private Label prerequis;
    @FXML
    private Label descripton;
    @FXML
    private Label duree;
    @FXML
    private Label datedeb;
    @FXML
    private Label datefin;
    @FXML
    private Label adresse;
    @FXML
    private Label prix;
    @FXML
    private Label contact;
    @FXML
    private Label email;

    
    //   static      int idd = Affich_mes_formationController.missionsel1.getRef();

    /**
     * Initializes the controller class.
     */
//     FilteredList<Formation> filteredData;
   //      private final FormationService fs = new FormationService();
    @FXML
    private AnchorPane pane_detail_formation;
    
     public static int missionID = 0 ;
       FormationService MS;
    static public Formation mission = new Formation();
    private Label idformation;
    @FXML
    private Button btn_modifier;
    @FXML
    private ImageView image_formation;
    @FXML
    private AnchorPane detail_pane;
  
 public Detail_mes_formationsController() throws SQLException {
        this.MS = new FormationService();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficher_detail();
        } catch (SQLException ex) {
            Logger.getLogger(Detail_mes_formationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    private void afficher_detail() throws SQLException {
      //     int idd = Affich_mes_formationController.missionsel1.getRef();
     int idd = Affich_mes_formationController.i;
        //       this.idformation.setText(String.valueOf(idd));
                mission = MS.Get_Mission_by_Id(idd);
                //   idformation.setText("" + mission.getRef());
        titre.setText("" + mission.getNom());
        descripton.setText(""+mission.getDescription());
        duree.setText("" + mission.getDuree()+" heures");
        datedeb.setText("" + mission.getDate_debut());
        datefin.setText("" + mission.getDate_fin());
        adresse.setText("" + mission.getAdresse());
        prix.setText("" + mission.getPrix()+" DT");
        contact.setText("" + mission.getContact());
        email.setText("" + mission.getEmail());

    }

        


    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent root=(AnchorPane)   FXMLLoader.load(getClass().getResource("/fxml/affich_mes_formation.fxml"));
     detail_pane.getChildren().clear();
    detail_pane.getChildren().add(root);
        //   Stage stage;
      //  Parent root = FXMLLoader.load(getClass().getResource("/fxml/affich_formation.fxml"));
      //  Scene scene = new Scene(root);
      //  stage = (Stage)btn_retour_formation.getScene().getWindow();
      //  stage.setScene(scene);
    }

    @FXML
    private void modifier_formation_action(ActionEvent event) throws IOException { 
         Parent root=(AnchorPane)   FXMLLoader.load(getClass().getResource("/fxml/modif_formation.fxml"));
     detail_pane.getChildren().clear();
    detail_pane.getChildren().add(root);
     //   FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/modif_formation.fxml"));
      //  Parent root;

      //  root = loader.load();
      //  btn_modifier.getScene().setRoot(root);
    }

    
}
