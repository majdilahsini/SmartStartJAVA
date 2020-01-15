/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import entities.Formation;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import services.FormationService;
import services.InscriptionService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Detail_inscrire_formationController implements Initializable {

    @FXML
    private Button btn_sincrire_formation;
    @FXML
    private Label titre;
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
    @FXML
    private ImageView image_formation;
    @FXML
    private Button btn_annuler_inscription;
    @FXML
    private AnchorPane detail_pane;
    
    
  //   static int idd = Affiche_formations_usersController.missionsel1.getRef();
     
     
    /**
     * Initializes the controller class.
     * 
     */
      public static int missionID = 0 ;
       FormationService MS;
              InscriptionService IS;

    static public Formation mission = new Formation();
     public Detail_inscrire_formationController() throws SQLException {
        this.MS = new FormationService();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            afficher_detail();
        } catch (SQLException ex) {
            Logger.getLogger(Details_formationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    
 private void afficher_detail() throws SQLException {
      //    int i = Affiche_formations_usersController.missionsel1.getRef();
        //       this.idformation.setText(String.valueOf(idd));
         int idd = Affiche_formations_usersController.i;
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
    private void inscription_action(ActionEvent event) throws IOException, SQLException{
        
                 int idd = Affiche_formations_usersController.i;
                                // mission = MS.Get_Mission_by_Id(idd);
  //int k = IS.afficheetat(idd,Session.getId());
  //System.out.println(k);
    /*   if (IS.afficheetat(idd, Session.getId()) == idd){
      JOptionPane.showMessageDialog(null, "deja inscrit");
}
else {*/
          Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/form_inscription_formation.fxml"));
     detail_pane.getChildren().clear();
     detail_pane.getChildren().add(root);

    }

    @FXML
    private void annuler_inscription_action(ActionEvent event) throws IOException {
          Parent root=(AnchorPane) FXMLLoader.load(getClass().getResource("/fxml/affiche_formations_users.fxml"));
     detail_pane.getChildren().clear();
     detail_pane.getChildren().add(root);
       
    }
    
}
