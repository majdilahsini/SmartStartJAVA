/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import entities.Invesstissement;
import entities.Projet;
import entities.myprojects;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import services.ServiceEmail;
import services.ServiceInvesstissement;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheProjectsController implements Initializable {

   
    @FXML
    private JFXTextField rechercheProjetText;
    @FXML
    private TableView<myprojects> tableaffichemyprojet;
    @FXML
    private TableColumn<myprojects, String> nomprojet_cl;
    @FXML
    private TableColumn<myprojects, String> catregorie_cl;
    @FXML
    private TableColumn<myprojects, String> datedebu_cl;
    @FXML
    private TableColumn<myprojects, String> adresse_cln;
    @FXML
    private TableColumn<myprojects, String> comptbancaire_cl;
    ObservableList<myprojects> obser = FXCollections
            .observableArrayList();
    @FXML
    private TableColumn<myprojects, String> emaimprojet_cl;
    @FXML
    private AnchorPane anchpaneafficheprojects1;
    @FXML
    private Label NomProjetLabel;
    @FXML
    private Label categorielabel;
    @FXML
    private Label adresseprojet;
    @FXML
    private Label emaillabel;
    @FXML
    private Label descriptionlabel;
    @FXML
    private JFXButton Investirbutton;
    @FXML
    private JFXButton retourbutton1;
    @FXML
    private AnchorPane anchpaneafficheprojects2;
    @FXML
    private JFXButton Affichebt;
    @FXML
    private JFXTextField ribtext;
    @FXML
    private JFXTextField montant;
    @FXML
    private JFXButton validerinvestissementbt;
    @FXML
    private AnchorPane investissementpane;
    String email="";
    @FXML
    private JFXComboBox<String> comboxCategorie;
    ObservableList<String> obser1 = FXCollections
            .observableArrayList();
    @FXML
    private ImageView comptebancaireimage;
    @FXML
    private ImageView montantimage;
    @FXML
    private Label erreurlabell;
    @FXML
    private BarChart<?, ?> barchar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        anchpaneafficheprojects1.setVisible(true);
        anchpaneafficheprojects2.setVisible(false);

        ServiceProjet s=new ServiceProjet();
        try {
            List<myprojects> list= s.AffichemyProjet();
             for (int i=0 ;i<list.size();i++){
                myprojects  p;
       ///  c.setNom(r.get(i).getNom());
                p = new myprojects(list.get(i).getNomprojet(),list.get(i).getCategorie(),list.get(i).getDateDebutProjet(),list.get(i).getAdresseProjet(),list.get(i).getDescriptionProjet(),list.get(i).getEmailProjet());
             }
            obser.addAll(list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       nomprojet_cl.setCellValueFactory(new PropertyValueFactory<>("nomprojet"));
        catregorie_cl.setCellValueFactory(new PropertyValueFactory<>("categorie"));
 datedebu_cl.setCellValueFactory(new PropertyValueFactory<>("dateDebutProjet"));
adresse_cln.setCellValueFactory(new PropertyValueFactory<>("adresseProjet"));
comptbancaire_cl.setCellValueFactory(new PropertyValueFactory<>("descriptionProjet"));
emaimprojet_cl.setCellValueFactory(new PropertyValueFactory<>("emailProjet"));
     tableaffichemyprojet.setItems(obser);
      List<String> l;
        try {
            l=s.getCategcategoriesCombobox();
            obser1.addAll(l);
        } catch (SQLException ex) {
            Logger.getLogger(AjouteProjet2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboxCategorie.setItems(obser1);
        }
        // TODO

    @FXML
    private void rechercheProjetPane(ActionEvent event) {
         anchpaneafficheprojects1.setVisible(true);
        anchpaneafficheprojects2.setVisible(false);
for(int i=0;i<tableaffichemyprojet.getItems().size();i++)
            tableaffichemyprojet.getItems().clear();
        ServiceProjet s=new ServiceProjet();
        try {
            List<myprojects> list= s.rechercheUtilisateursSimple(comboxCategorie.getValue(),rechercheProjetText.getText());
           
            
             
            obser.addAll(list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       nomprojet_cl.setCellValueFactory(new PropertyValueFactory<>("nomprojet"));
        catregorie_cl.setCellValueFactory(new PropertyValueFactory<>("categorie"));
 datedebu_cl.setCellValueFactory(new PropertyValueFactory<>("dateDebutProjet"));
adresse_cln.setCellValueFactory(new PropertyValueFactory<>("adresseProjet"));
comptbancaire_cl.setCellValueFactory(new PropertyValueFactory<>("descriptionProjet"));
emaimprojet_cl.setCellValueFactory(new PropertyValueFactory<>("emailProjet"));
     tableaffichemyprojet.setItems(obser);
        
        
    }

    @FXML
    private void Investiraction(ActionEvent event) {
       investissementpane.setVisible(true);
        anchpaneafficheprojects1.setVisible(false);
        anchpaneafficheprojects2.setVisible(false);
       
        
    }

    @FXML
    private void retourAction(ActionEvent event) {
        anchpaneafficheprojects1.setVisible(true);
        anchpaneafficheprojects2.setVisible(false);
    }

    @FXML
    private void AffichebtAction(ActionEvent event) {
        NomProjetLabel.setText( "");
        categorielabel.setText( "");
        adresseprojet.setText( "");
        emaillabel.setText( "");
        descriptionlabel.setText( "");
        anchpaneafficheprojects1.setVisible(false);
        anchpaneafficheprojects2.setVisible(true);
        ObservableList<myprojects> show = tableaffichemyprojet.getSelectionModel().getSelectedItems();
        NomProjetLabel.setText( show.get(0).getNomprojet());
        categorielabel.setText( show.get(0).getCategorie());
        adresseprojet.setText( show.get(0).getAdresseProjet());
        emaillabel.setText( show.get(0).getEmailProjet());
        descriptionlabel.setText( show.get(0).getDescriptionProjet());
        email=show.get(0).getEmailProjet();
    }

    @FXML
    private void validerinvestissementAction(ActionEvent event) throws SQLException {
        NomProjetLabel.setText( "");
        categorielabel.setText( "");
        adresseprojet.setText( "");
        emaillabel.setText( "");
        descriptionlabel.setText( "");
        Invesstissement i;
        ServiceInvesstissement s=new  ServiceInvesstissement() ;
        int id=s.getProjet(s.getProjet(email));
        
        i=new Invesstissement(Integer.parseInt(montant.getText()), Integer.parseInt(ribtext.getText()),id, entities.Session.getId());//////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
        s.ajouterInvesstissement(i);
        final String fromEmail = "sgkoussay@gmail.com"; //"racemcherni1@gmail.com"  ; //requires valid gmail id
        final String password = "27121997sgh"; // correct password for gmail id
	final String toEmail ="koussaysghaier27@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session;
        session = Session.getInstance(props,auth);
		
		ServiceEmail.sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");


        
        
        
        anchpaneafficheprojects1.setVisible(true);
        anchpaneafficheprojects2.setVisible(false);
        investissementpane.setVisible(false);
    }

    @FXML
    private void comboxCategorieAction(ActionEvent event) {
        for(int i=0;i<tableaffichemyprojet.getItems().size();i++)
            tableaffichemyprojet.getItems().clear();
        ServiceProjet s=new ServiceProjet();
        try {
            List<myprojects> list= s.AffichemyProjetcategorie(comboxCategorie.getValue());
             for (int i=0 ;i<list.size();i++){
                myprojects  p;
       ///  c.setNom(r.get(i).getNom());
                p = new myprojects(list.get(i).getNomprojet(),list.get(i).getCategorie(),list.get(i).getDateDebutProjet(),list.get(i).getAdresseProjet(),list.get(i).getDescriptionProjet(),list.get(i).getEmailProjet());
             }
            obser.addAll(list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       nomprojet_cl.setCellValueFactory(new PropertyValueFactory<>("nomprojet"));
        catregorie_cl.setCellValueFactory(new PropertyValueFactory<>("categorie"));
 datedebu_cl.setCellValueFactory(new PropertyValueFactory<>("dateDebutProjet"));
adresse_cln.setCellValueFactory(new PropertyValueFactory<>("adresseProjet"));
comptbancaire_cl.setCellValueFactory(new PropertyValueFactory<>("descriptionProjet"));
emaimprojet_cl.setCellValueFactory(new PropertyValueFactory<>("emailProjet"));
     tableaffichemyprojet.setItems(obser);

    }
    }    

    
   
    
    
    
    
    
    
    
    
    

