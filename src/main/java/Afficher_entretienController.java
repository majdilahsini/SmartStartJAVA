/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fxml.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Entretien;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.EntretienService;
import javafx.scene.Parent;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javax.mail.MessagingException;
import services.Send;
/**
 * FXML Controller class
 *
 * @author User
 */
public class Afficher_entretienController implements Initializable {

    @FXML
    private AnchorPane pane_entretien;
    @FXML
    private JFXButton ajout_entretien_btn;
    @FXML
    private JFXButton actualiser_entretienbtn;
    @FXML
    private TableView<Entretien> tableEntretien;
    @FXML
    private TableColumn<Entretien, Number> refColonne;
    private TableColumn<Entretien, Number> id_entColonne;
    private TableColumn<Entretien, Number> id_userColonne;
    @FXML
    private TableColumn<Entretien, String> posteColonne;
    @FXML
    private TableColumn<Entretien, String> dateColonne;
    @FXML
    private TableColumn<Entretien, String> heureColonne;
    @FXML
    private TableColumn<Entretien, String> descriptionColonne;
        private ListData listdata1 = new ListData();
    EntretienService es = new EntretienService();
    @FXML
    private TableColumn<Entretien, String> NomEntColonne;
    @FXML
    private TableColumn<Entretien, String> Nom_cColonne;
    private TableColumn<Entretien, String> Prenom_cColonne;
    @FXML
    private JFXTextField rechercherText;
    @FXML
    private AnchorPane zone_modifier;
    @FXML
    private JFXTextField postefield;
    @FXML
    private JFXTextField datefield;
    @FXML
    private JFXTextField heurefeild;
    @FXML
    private JFXTextField descriptionfield;
    @FXML
    private JFXButton supprimerbtn;
    @FXML
    private JFXButton modifier_btn;
    @FXML
    private JFXButton valider_modifier_btn;
    @FXML
    private JFXButton annuler_modifier_btn;
    @FXML
    private JFXTextField reffield;
    @FXML
    private BorderPane BorderEntretien;
    @FXML
    private BorderPane BorderEntreprise;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField recipientEmail;
    @FXML
    private JFXTextField ccEmail;
    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextArea message;
    @FXML
    private JFXButton EnvoyerMail;
    @FXML
    private JFXButton AnnulerMail;
    @FXML
    private AnchorPane Mailbox;
    Send s = new Send();

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                        zone_modifier.setVisible(false);
                        Mailbox.setVisible(false);

          tableEntretien.setItems(listdata1.getPersons());
       refColonne.setCellValueFactory(cell -> cell.
                getValue().getref_entProperty());
                NomEntColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_entProperty());
       Nom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_userProperty());
     /*  Prenom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenom_userProperty());*/
        posteColonne.setCellValueFactory(cell -> cell.
                getValue().getposte_entProperty());
        dateColonne.setCellValueFactory(cell -> cell.
                getValue().getdate_entProperty());
        heureColonne.setCellValueFactory(cell -> cell.
                getValue().getHeure_entProperty());
        descriptionColonne.setCellValueFactory(cell -> cell.
                getValue().getdescription_entProperty());
        /*
        FilteredList<Entretien> filteredData = new FilteredList<>(listdata1.getPersons(), b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rechercherText.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (employee.getPoste_ent().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (employee.getHeure_ent().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (employee.getNom_user().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (employee.getPrenom_user().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}

				else if (String.valueOf(employee.getNom_user()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});       
                		SortedList<Entretien> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(tableEntretien.comparatorProperty());

        		tableEntretien.setItems(sortedData);*/

        
      /*      tableEntretien.setItems(listdata1.getPersons());*/

        
        
      /* tableEntretien.setItems(listdata.getPersons());
       refColonne.setCellValueFactory(cell -> cell.
                getValue().getref_entProperty());
        id_entColonne.setCellValueFactory(cell -> cell.
                getValue().getid_entrepriseProperty());
        id_userColonne.setCellValueFactory(cell -> cell.
                getValue().getId_userProperty());
        posteColonne.setCellValueFactory(cell -> cell.
                getValue().getposte_entProperty());
        dateColonne.setCellValueFactory(cell -> cell.
                getValue().getdate_entProperty());
        heureColonne.setCellValueFactory(cell -> cell.
                getValue().getHeure_entProperty());
        descriptionColonne.setCellValueFactory(cell -> cell.
                getValue().getdescription_entProperty());*/
    }    

    @FXML
    private void ajout_entretien_action(ActionEvent event) throws IOException {
       /*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ajouter_entretien_1.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();*/
     /*   Image image = new Image("assests\123.jpg");
        ImageView iv = new ImageView();
        Group singUpPage = new Group();
        singUpPage.getChildren().addAll(iv);*/
      /*  Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/ajouter_entretien_1.fxml"));
       Scene scene = new Scene(signUpPage);
        stage = (Stage)ajout_entretien_btn.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();*/
          Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/ajouter_entretien_1.fxml"));
        BorderEntreprise.setCenter(root1);
    }

    @FXML
    private void actualiser_entretienAction(ActionEvent event) {
                        Entretien ent = tableEntretien.getSelectionModel().getSelectedItem();
           String nom_condidat = ent.getNom_user();
          String email_ent = es.getEmailBynom(nom_condidat);
          recipientEmail.setText(String.valueOf(email_ent));
                  Mailbox.setVisible(true);
    }

    @FXML
    private void recherche_entretien_action(ActionEvent event) {
     
    }

    @FXML
    private void delete_row_Action(ActionEvent event) throws IOException {
 
  
     Entretien ent = tableEntretien.getSelectionModel().getSelectedItem();
     int ref = ent.getRef_ent();
     es.deleteEnt(ref);
     tableEntretien.getItems().removeAll(tableEntretien.getSelectionModel().getSelectedItem());
}

    @FXML
    private void modifier_ent_Action(ActionEvent event) {
                zone_modifier.setVisible(true);
       
        Entretien gets=tableEntretien.getSelectionModel().getSelectedItem();
        reffield.setText(String.valueOf(gets.getRef_ent()));
        postefield.setText(String.valueOf(gets.getPoste_ent()));
        datefield.setText(String.valueOf(gets.getDate_ent()));
         heurefeild.setText(String.valueOf(gets.getHeure_ent()));

        descriptionfield.setText(String.valueOf(gets.getDescription_ent()));
      
        /*duree_modif.setText(String.valueOf(gets.getDuree()));
       desc_modif.setText(gets.getDescription());*/
        
    }

    @FXML
    private void valider_modifEnt_action(ActionEvent event) throws SQLException{
                
        if (HeureCorrect() && DateCorrect()) {
         Entretien e = new Entretien();
              EntretienService as = new EntretienService();
                    es.UpdateEntretien(Integer.parseInt(reffield.getText()),postefield.getText(),datefield.getText(),heurefeild.getText(), descriptionfield.getText());

                                 Afficher();
                     zone_modifier.setVisible(false);
        }
    }
    @FXML
    private void Annuler_modifEnt_Action(ActionEvent event) {
                zone_modifier.setVisible(false);

    }

    private void Afficher() {
             EntretienService as= new EntretienService();
                    int i =   Session.getId();

            ObservableList<Entretien> arrayList = (ObservableList<Entretien>) as.displayAll5(i);
            ObservableList obs = FXCollections.observableArrayList(arrayList);
            tableEntretien.setItems(obs);
                  refColonne.setCellValueFactory(cell -> cell.
                getValue().getref_entProperty());
                NomEntColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_entProperty());
       Nom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_userProperty());
     /*  Prenom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenom_userProperty());*/
        posteColonne.setCellValueFactory(cell -> cell.
                getValue().getposte_entProperty());
        dateColonne.setCellValueFactory(cell -> cell.
                getValue().getdate_entProperty());
        heureColonne.setCellValueFactory(cell -> cell.
                getValue().getHeure_entProperty());
        descriptionColonne.setCellValueFactory(cell -> cell.
                getValue().getdescription_entProperty());
                

    }

    @FXML
    private void rechercher_entretien(KeyEvent event) {
               
                            int i =   Session.getId();

        EntretienService es= new EntretienService();
        ArrayList<Entretien> abonnements = new ArrayList<>();
        try {
            abonnements=(ArrayList<Entretien>) es.rechercheEntretien(
                    rechercherText.getText(),i);
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_entretienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Entretien> obsl = FXCollections.observableArrayList(abonnements);
        tableEntretien.setItems(obsl);
        refColonne.setCellValueFactory(cell -> cell.
                getValue().getref_entProperty());
        NomEntColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_entProperty());
        Nom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getNom_userProperty());
     /*   Prenom_cColonne.setCellValueFactory(cell -> cell.
                getValue().getPrenom_userProperty());*/
        posteColonne.setCellValueFactory(cell -> cell.
                getValue().getposte_entProperty());
        dateColonne.setCellValueFactory(cell -> cell.
                getValue().getdate_entProperty());
        heureColonne.setCellValueFactory(cell -> cell.
                getValue().getHeure_entProperty());
        descriptionColonne.setCellValueFactory(cell -> cell.
                getValue().getdescription_entProperty());
        // prixtotale.setCellValueFactory(new PropertyValueFactory<>("5"));
    }
        private boolean HeureCorrect() {
                Pattern p = Pattern.compile("[0-9][0-9]+([:][0-9][0-9]+)+");
        Matcher m = p.matcher(heurefeild.getText());
        if ( m.find() && m.group().equals(heurefeild.getText())){
            return true ;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Heure");
            alert.setHeaderText("Verifier Heure");
            alert.setContentText("Svp entrer l'heure de forme hh:mm ex: 11:30");
            alert.showAndWait();
            return false;
    } }

    private boolean DateCorrect() {
                        Pattern p = Pattern.compile("[0-9][0-9]+([-][0-9][0-9]+)+([-][0-9][0-9]+)+");
        Matcher m = p.matcher(datefield.getText());
        if ( m.find() && m.group().equals(datefield.getText())){
            return true ;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Verifier Date");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
            return false;
    }
        
    }

    @FXML
    private void Envoyer_Mail_Action(ActionEvent event) throws MessagingException {
                  s.Sender(username.getText(),password.getText(),recipientEmail.getText(),ccEmail.getText(),title.getText(),message.getText());
          Mailbox.setVisible(false);
    }

    @FXML
    private void Annuler_Mail_Action(ActionEvent event) {
                                  Mailbox.setVisible(false);

    }

}

