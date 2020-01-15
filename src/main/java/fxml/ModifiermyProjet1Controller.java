/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Projet;
import entities.Session;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import services.ServiceProjet;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifiermyProjet1Controller implements Initializable {
        private int[] verif = new int[]{0,0,0,0,0,0,0,0,0,0,0};

    @FXML
    private JFXButton Suivant1;
    @FXML
    private JFXTextField nptext;
    @FXML
    private JFXTextField telptext;
    @FXML
    private JFXTextField eptext;
    @FXML
    private JFXTextField adtext;
    @FXML
    private JFXComboBox<String> cattext;
    @FXML
    private JFXTextArea Dotext;
    @FXML
    private ImageView imageProjet7;
    @FXML
    private ImageView imageProjet8;
    @FXML
    private ImageView imageProjet9;
    @FXML
    private ImageView imageProjet710;
    @FXML
    private ImageView imageProjet11;
    @FXML
    private ImageView imageProjet12;
    @FXML
    private ImageView image_projet;
    @FXML
    private AnchorPane modifpane1;
    
    @FXML
    private AnchorPane modifpane;
    @FXML
    private AnchorPane ajouteProjet2pane;
    @FXML
    private JFXButton ValideProjet;
    @FXML
    private JFXTextField Votrefinancetext;
    @FXML
    private JFXTextField nbreteamtext;
    @FXML
    private JFXTextField montanttext;
    @FXML
    private JFXTextField comptbancairetext;
    @FXML
    private JFXButton Annule2Projet;
    @FXML
    private JFXDatePicker datedebutprojet;
    @FXML
    private JFXTextField dureeprojet;
    @FXML
    private ImageView imageProjet1;
    @FXML
    private JFXButton uploadimage;
    @FXML
    private ImageView imageProjet2;
    ObservableList<String> obser = FXCollections
            .observableArrayList();
    
    
    @FXML
    private ImageView imageProjet3;
    @FXML
    private ImageView imageProjet4;
    @FXML
    private ImageView imageProjet6;
private int id=0;
    @FXML
    private Label datelabel;
    @FXML
    private ImageView mofifimageimage;
    
     private File file;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 ajouteProjet2pane.setVisible(false);
  modifpane1.setVisible(true); 
        ServiceProjet s=new ServiceProjet();
   List<String> l;
  try {
            l=s.getCategcategoriesCombobox();
            obser.addAll(l);
        } catch (SQLException ex) {
            Logger.getLogger(AjouteProjet2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cattext.setItems(obser);
 String ch= AfficheMyprojectController.missionsell.getEmailProjet();
    System.out.println(ch+"--------------------------");
        Projet p = null;
           

        
      
       
        try {
            id= s.getIdProjet_byEmail(ch);
        } catch (SQLException ex) {
            Logger.getLogger(ModifiermyProjet1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
            try { 
                p = s.getProjet(id);
            } catch (SQLException ex) {
                Logger.getLogger(ModifiermyProjet1Controller.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
    //Image im=new Image(p.getImage());
        
       // mofifimageimage.setImage(im);        
            
            
            
    nptext.setText(p.getNomprojet());
    telptext.setText(Integer.toString(p.getTelProjet()));
    adtext.setText(p.getAdresseProjet());
    Dotext.setText(p.getDescriptionProjet());    
    eptext.setText(p.getEmailProjet());
    datelabel.setText(p.getDateDebutProjet());
   Votrefinancetext.setText(Integer.toString(p.getVotreFinance()));
    nbreteamtext.setText(Integer.toString(p.getNbreTeam()));
    montanttext.setText(Long.toString( p.getMontant()));
    comptbancairetext.setText(Long.toString( p.getCompteBancaire()));
    dureeprojet.setText(Integer.toString(p.getDuree()));
  
  
    }    

    @FXML
    private void Suivant1Action(ActionEvent event) {
        ajouteProjet2pane.setVisible(true);
        modifpane1.setVisible(false);
         
        
    }

    @FXML
    private void nomprojetControl(KeyEvent event) {
         if (nptext.getText().length()>3 ) {
           imageProjet7.setImage(new Image("/fxml/assets/ok.png"));
            verif[4]=1;
            Suivant1.setVisible(true);
        }
                
         else {
           imageProjet7.setImage(new Image("/fxml/assets/error.png"));    
            verif[4]=0; 
                        Suivant1.setVisible(false);

        }
        
    }

    @FXML
    private void telprojetcrole(KeyEvent event) {
         if (Pattern.matches("[0-9]+", telptext.getText()) &&( telptext.getText().length() == 8) && (telptext.getText().startsWith("2", 0) || telptext.getText().startsWith("9", 0) || telptext.getText().startsWith("5", 0) || telptext.getText().startsWith("7", 0))) {
            imageProjet8.setImage(new Image("/fxml/assets/ok.png"));
             verif[8]=1;
                        
         }
                
         else  {
           imageProjet8.setImage(new Image("/fxml/assets/error.png"));
             verif[8]=0;
                        

         }
        
    }

    @FXML
    private void emailcontrole(KeyEvent event) {
         if (eptext.getText().length()>=10 && eptext.getText().endsWith("@gmail.com") ) {
           imageProjet9.setImage(new Image("/fxml/assets/ok.png"));
            verif[5]=1;
                        Suivant1.setVisible(true);

        }
                
         else {
            imageProjet9.setImage(new Image("/fxml/assets/error.png"));    
            verif[5]=0; 
                        Suivant1.setVisible(false);

        }
        
    }

    @FXML
    private void adresseContol(KeyEvent event) {
         if (adtext.getText().length()>10 ) {
            imageProjet710.setImage(new Image("/fxml/assets/ok.png"));
            verif[6]=1;
                        

        }
                
         else {
            imageProjet710.setImage(new Image("/fxml/assets/error.png"));    
            verif[6]=0; 
                      
        }
        
    }

    @FXML
    private void descriptioncontrl(KeyEvent event) {
       if (Dotext.getText().length()>20) {
           imageProjet12.setImage(new Image("/fxml/assets/ok.png"));
            verif[7]=1;
                        

        }
                
         else {
            imageProjet12.setImage(new Image("/fxml/assets/error.png"));    
            verif[7]=0; 
                        

        }  
        
    }

    @FXML
    private void annuler1Action(ActionEvent event) throws IOException {
        
        
         FileChooser fileChooser = new FileChooser();
       file = fileChooser.showOpenDialog(uploadimage.getScene().getWindow());
        
       if(file != null){
           Image img = new Image(file.toURI().toURL().toExternalForm());
          
            image_projet.setImage(img);
          image_projet.setFitWidth(129);
           image_projet.setFitHeight(127);
          image_projet.setPreserveRatio(true);}
        
        
    }

    @FXML
    private void ValideProjetAction(ActionEvent event) throws SQLException {
        ServiceProjet s=new ServiceProjet();
         int i=  Integer.parseInt(telptext.getText());
     int i1=  Integer.parseInt(nbreteamtext.getText());

   int i2=  Integer.parseInt(dureeprojet.getText());
    int i3=  Integer.parseInt(Votrefinancetext.getText());
long i4=  Long.parseLong(montanttext.getText());
long i5=  Long.parseLong(comptbancairetext.getText());
List<String> l;
l=s.getCategcategoriesCombobox();
cattext.getItems().addAll(l);


        file.renameTo(new File("C:\\wamp64\\www\\"+file.getName()));
        Projet p=new Projet();
        p.setIdProjet(id);////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       p.setNomprojet(nptext.getText());
      p.setTelProjet(i);
     p.setEmailProjet(eptext.getText());
     p.setAdresseProjet(adtext.getText());
       p.setDescriptionProjet(Dotext.getText());
       p.setCategorie(cattext.getValue());
       p.setVotreFinance(i3);
        p.setNbreTeam(i1);
        p.setMontant(i4);
        p.setCompteBancaire(i5);
        String date=datedebutprojet.getValue().toString();
       p.setDateDebutProjet(date);
        p.setDuree(i2);
        p.setId_enterprise(Session.getId());
         if(file ==null)
        p.setImage("/fxml/assets/logo.jpg");
        else
           p.setImage("C:\\wamp64\\www\\"+file.getName()); 
       // p.
s.ModifierProjet(p);
        
    }

    @FXML
    private void Votrefinancetext(KeyEvent event) {
         if (Pattern.matches("[0-9]+", Votrefinancetext.getText()) && Votrefinancetext.getText().length() == 4) {
             imageProjet1.setImage(new Image("/fxml/assets/ok.png"));
             verif[9]=1;
         }
                
         else  {
             imageProjet1.setImage(new Image("/fxml/assets/error.png"));
             verif[9]=0;
         }
    }

    @FXML
    private void nbreteamcontrol(KeyEvent event) {
         if (Pattern.matches("[0-9]+", nbreteamtext.getText()) && nbreteamtext.getText().length() >= 1) {
             imageProjet2.setImage(new Image("/fxml/assets/ok.png"));
             verif[0]=1;
         }
                
         else  {
          imageProjet2.setImage(new Image("/fxml/assets/error.png"));
             verif[0]=0;
         }
    }

    @FXML
    private void montantcontroll(KeyEvent event) {
         if (Pattern.matches("[0-9]+", montanttext.getText()) && montanttext.getText().length() == 4) {
             imageProjet3.setImage(new Image("/fxml/assets/ok.png"));
             verif[1]=1;
         }
                
         else  {
             imageProjet3.setImage(new Image("/fxml/assets/error.png"));
             verif[1]=0;
         }
    }

    @FXML
    private void comptebancairecontrol(KeyEvent event) {
         if (Pattern.matches("[0-9]+", comptbancairetext.getText()) && comptbancairetext.getText().length() == 12) {
            imageProjet4.setImage(new Image("/fxml/assets/ok.png"));
             verif[2]=1;
         }
                
         else  {
           imageProjet4.setImage(new Image("/fxml/assets/error.png"));
             verif[2]=0;
         }
    }

    @FXML
    private void Annule2ProjetAction(ActionEvent event) {
         ajouteProjet2pane.setVisible(false);
        modifpane1.setVisible(true);
    }

    @FXML
    private void dureecontrolle(KeyEvent event) {
         if (Pattern.matches("[0-9]+", dureeprojet.getText()) && dureeprojet.getText().length() >= 1 ) {
            imageProjet6.setImage(new Image("/fxml/assets/ok.png"));
             verif[3]=1;
         }
                
         else  {
           imageProjet6.setImage(new Image("/fxml/assets/error.png"));
             verif[3]=0;
         }
    }

    private void uploadimageAction(ActionEvent event) throws MalformedURLException {
       
         FileChooser fileChooser = new FileChooser();
       file = fileChooser.showOpenDialog(uploadimage.getScene().getWindow());
        
       if(file != null){
           Image img = new Image(file.toURI().toURL().toExternalForm());
          
            image_projet.setImage(img);
          image_projet.setFitWidth(129);
           image_projet.setFitHeight(127);
          image_projet.setPreserveRatio(true);
       }
        
        
        
    }

    
}
