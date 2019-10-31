package fxml;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fxml.Details_formationController;
import fxml.Details_formationController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import services.FormationService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Modif_formationController implements Initializable {

    @FXML
    private AnchorPane pane_modif_formation;
    @FXML
    private Button btn_modif_formation;
    @FXML
    private DatePicker datedeb_txt;
    @FXML
    private DatePicker datefin_txt;
    @FXML
    private Button btn_annuler_formation;
    @FXML
    private Label id_domaine;
    
    @FXML
    private JFXTextField nom_txt;
    @FXML
    private JFXTextArea description_txt;
    @FXML
    private JFXTextField duree_txt;
    @FXML
    private JFXTextField adressse_txt;
    @FXML
    private JFXTextField prix_txt;
    @FXML
    private JFXTextField contact_txt;
    @FXML
    private JFXTextField email_txt;
    private JFXTextField id_domaine_txt;
    @FXML
    private Button btn_retour_formation1;
    @FXML
    private JFXTextField datedebt;
    @FXML
    private JFXTextField datefint;
    @FXML
    private AnchorPane manel;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //   FormationService fs =new FormationService();
        
        // TODO
        //   SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        // java.util.Date date1 = formatter1.parse(datedeb_txt.getValue().toString());
        // java.sql.Date d = new Date(date1.getTime());
        //  java.util.Date date2 = formatter1.parse(datefin_txt.getValue().toString());
        //   java.sql.Date dd = new Date(date2.getTime());
        nom_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getNom()));
        description_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getDescription()));
        duree_txt.setText(Integer.toString(Detail_mes_formationsController.mission.getDuree()));
        adressse_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getAdresse()));
        prix_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getPrix()));
        contact_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getContact()));
        email_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getEmail()));
     //   id_domaine_txt.setText(String.valueOf(Detail_mes_formationsController.mission.getDomaine_id()));
        // datedeb_txt.setDayCellFactory((Callback<DatePicker, DateCell>) d);
        //  datefin_txt.setDayCellFactory((Callback<DatePicker, DateCell>) dd);
        datedebt.setText(String.valueOf(Detail_mes_formationsController.mission.getDate_debut()));
        datefint.setText(String.valueOf(Detail_mes_formationsController.mission.getDate_fin()));
        //  LocalDate localDate = datedeb_txt.getValue();
        //  LocalDate localDate1 = datefin_txt.getValue();
    }    

    @FXML
    private void Modifier_action(ActionEvent event) throws IOException, ParseException, SQLException {
         FormationService ms = new FormationService();
          SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter1.parse(datedeb_txt.getValue().toString());
        java.sql.Date d = new Date(date1.getTime());
         java.util.Date date2 = formatter1.parse(datefin_txt.getValue().toString());
        java.sql.Date dd = new Date(date2.getTime());
        int id = Affich_mes_formationController.i;
        System.out.println(id);
        ms.modifierFormation(
               

                                nom_txt.getText(),

                description_txt.getText(),
                
                Integer.parseInt(duree_txt.getText()),
                d ,
               dd ,
           
                Double.valueOf(prix_txt.getText()),
                     adressse_txt.getText(),
                email_txt.getText(),
     Integer.parseInt(contact_txt.getText()),id

               
        );
        
        JOptionPane.showMessageDialog(null, "Modifier avec succée");
       Parent root=(AnchorPane)   FXMLLoader.load(getClass().getResource("/fxml/detail_mes_formations.fxml"));
     manel.getChildren().clear();
    manel.getChildren().add(root);
      
    }
    

    @FXML
    private void annuler_modif_action(ActionEvent event) throws IOException {
           JOptionPane.showMessageDialog(null, "Modification annulée !");
           Parent root=(AnchorPane)   FXMLLoader.load(getClass().getResource("/fxml/affich_mes_formation.fxml"));
     manel.getChildren().clear();
    manel.getChildren().add(root);
    }
   
    @FXML
    private void retour_modif_action(ActionEvent event) throws IOException {
         Parent root=(AnchorPane)   FXMLLoader.load(getClass().getResource("/fxml/detail_mes_formations.fxml"));
     manel.getChildren().clear();
    manel.getChildren().add(root);
    }
    
}
