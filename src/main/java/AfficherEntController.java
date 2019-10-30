/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fxml.*;
import entities.Entretien;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javax.mail.MessagingException;
import services.EntretienService;
import services.Send;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AfficherEntController implements Initializable {

    @FXML
    private TableColumn<Entretien, String> NomEntColonne;
    @FXML
    private TableColumn<Entretien, String> Nom_cColonne;
    @FXML
    private TableColumn<Entretien, String> PosteColonne;
    @FXML
    private TableColumn<Entretien, String> DateColonne;
    @FXML
    private TableColumn<Entretien, String> HeureColone;
    @FXML
    private TableColumn<Entretien, String> DescriptionColonne;
    private ListData2 listdata = new ListData2();
       private ListData listdata1 = new ListData();

    @FXML
    private TableView<Entretien> tableEnt;
        EntretienService es = new EntretienService();
    @FXML
    private JFXButton deletebtn;
    @FXML
    private TableColumn<Entretien, Number> refColonne;
    @FXML
    private AnchorPane EmailBox;
    @FXML
    private JFXButton EnvoyerBtn;
    @FXML
    private JFXButton AnnulerMail_btn;
    @FXML
    private JFXButton ConfirmerMail_btn;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField recipientEmail;
    @FXML
    private JFXTextArea message;
    @FXML
    private JFXTextField ccEmail;
    @FXML
    private JFXTextField title;
Send s = new Send();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

       tableEnt.setItems(listdata.getPersons());
       refColonne.setCellValueFactory(cell -> cell.
                getValue().getref_entProperty());
                NomEntColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_entProperty());
       Nom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_userProperty());
     /*  Prenom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenom_userProperty());*/
        PosteColonne.setCellValueFactory(cell -> cell.
                getValue().getposte_entProperty());
        DateColonne.setCellValueFactory(cell -> cell.
                getValue().getdate_entProperty());
        HeureColone.setCellValueFactory(cell -> cell.
                getValue().getHeure_entProperty());
        DescriptionColonne.setCellValueFactory(cell -> cell.
                getValue().getdescription_entProperty());
          EmailBox.setVisible(false);
    }    

    @FXML
    private void delete_row1_Action(ActionEvent event) {
             Entretien ent = tableEnt.getSelectionModel().getSelectedItem();
     int ref = ent.getRef_ent();
     es.deleteEnt(ref);
          tableEnt.getItems().removeAll(tableEnt.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void envoyer_btn_Action(ActionEvent event) throws MessagingException {



          s.Sender(username.getText(),password.getText(),recipientEmail.getText(),ccEmail.getText(),title.getText(),message.getText());
          EmailBox.setVisible(false);

    }
    @FXML
    private void AnnulerMail_btn_Action(ActionEvent event) {
                          EmailBox.setVisible(false);

    }

    @FXML
    private void confirmer_mail_Action(ActionEvent event)  {
   
                Entretien ent = tableEnt.getSelectionModel().getSelectedItem();
           String nom_ent = ent.getNom_ent();
          String email_ent = es.getEmailBynom(nom_ent);
          recipientEmail.setText(String.valueOf(email_ent));
                  EmailBox.setVisible(true);

    }
    
}
