/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.scenario.effect.ImageData;
import entities.Projet;
import entities.myprojects;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceProjet;
import java.io.*;
import com.itextpdf.io.image.*;
import com.itextpdf.kernel.pdf.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entities.Session;
import java.net.MalformedURLException;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import static org.joda.time.format.ISODateTimeFormat.date;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouteProjet2Controller implements Initializable {

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
    private JFXButton annuler1;
    @FXML
    private AnchorPane ajouteProjet2pane;
    @FXML
    private AnchorPane ajouteprojet1pane;
ObservableList<String> obser = FXCollections
            .observableArrayList();
    @FXML
    private AnchorPane ajouteProjetPane;
    @FXML
    private JFXButton uploadimage;
    
        private int[] verif = new int[]{0,0,0,0,0,0,0,0,0,0,0};
    @FXML
    private ImageView imageProjet1;
    @FXML
    private ImageView imageProjet2;
    @FXML
    private ImageView imageProjet3;
    @FXML
    private ImageView imageProjet4;
    @FXML
    private ImageView imageProjet5;
    @FXML
    private ImageView imageProjet6;
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
    private JFXButton annuler11;
    @FXML
    private JFXButton PDFbUTTON;

    private File file;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceProjet s=new ServiceProjet();

        ajouteprojet1pane.setVisible(true);
        ajouteProjet2pane.setVisible(false);
        List<String> l;
        try {
            l=s.getCategcategoriesCombobox();
            obser.addAll(l);
        } catch (SQLException ex) {
            Logger.getLogger(AjouteProjet2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cattext.setItems(obser);
        
    }    

    @FXML
    private void ValideProjetAction(ActionEvent event) throws SQLException, IOException {
        ServiceProjet s=new ServiceProjet();
         int i=  Integer.parseInt(telptext.getText());
     int i1=  Integer.parseInt(nbreteamtext.getText());

   int i2=  Integer.parseInt(dureeprojet.getText());
    int i3=  Integer.parseInt(Votrefinancetext.getText());
long i4=  Long.parseLong(montanttext.getText());
long  i5=  Long.parseLong(comptbancairetext.getText());
List<String> l;
l=s.getCategcategoriesCombobox();
if(cattext.getValue()!=null)
    verif[10]=1;

        int j=0;
        for (int k: verif)
            j = j + k;
        
        file.renameTo(new File("C:\\wamp64\\www\\"+file.getName()));
           
        if(j==11){
        Projet p=new Projet();
        if(!nptext.getText().isEmpty())
       p.setNomprojet(nptext.getText());
        else{
         Suivant1.disableProperty().set(true);
        }
      p.setTelProjet(i);
     p.setEmailProjet(eptext.getText());
     p.setAdresseProjet(adtext.getText());
       p.setDescriptionProjet(Dotext.getText());
       p.setCategorie(cattext.getValue());
       p.setVotreFinance(i3);
        p.setNbreTeam(i1);
        p.setMontant(i4);
        p.setCompteBancaire(i5);
       
        p.setDuree(i2);
        p.setId_enterprise(Session.getId());
        if(file ==null)
        p.setImage("/fxml/assets/logo.jpg");
        else
           p.setImage("D:\\XAMPP\\htdocs"+file.getName());
        
        if(DateCorrect())
        {
             String date=datedebutprojet.getValue().toString();
       p.setDateDebutProjet(date);
       s.ajouterProjet(p);
        }
            
       
            
        

        }
    }

    @FXML
    private void Annule2ProjetAction(ActionEvent event) {
        ajouteprojet1pane.setVisible(true);
        ajouteProjet2pane.setVisible(false);
        
    }

    @FXML
    private void Suivant1Action(ActionEvent event) {
         ajouteprojet1pane.setVisible(false);
        ajouteProjet2pane.setVisible(true);
        
    }

    @FXML
    private void annuler1Action(ActionEvent event) throws MalformedURLException {
         FileChooser fileChooser = new FileChooser();
       file = fileChooser.showOpenDialog(annuler11.getScene().getWindow());
        
       if(file != null){
           Image img = new Image(file.toURI().toURL().toExternalForm());
          
            image_projet.setImage(img);
          image_projet.setFitWidth(129);
           image_projet.setFitHeight(127);
          image_projet.setPreserveRatio(true);
        
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
         if (Pattern.matches("[0-9]+", telptext.getText()) &&( telptext.getText().length() == 7) && (telptext.getText().startsWith("2", 0) || telptext.getText().startsWith("9", 0) || telptext.getText().startsWith("5", 0) || telptext.getText().startsWith("7", 0))) {
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
         if (eptext.getText().length()>=5 && eptext.getText().endsWith("@gmail.com") ) {
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
    private void PDFACTION(ActionEvent event) throws FileNotFoundException, DocumentException, IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
        fc.setTitle("save tp pdf");
        fc.setInitialFileName("untitiled.pdf");
        Stage window = new Stage();

           
            File file=fc.showSaveDialog(window);
            String str = file.getAbsolutePath();
            if(file!=null)
            {
                OutputStream fil = new FileOutputStream(new File(str));


            Document document = new Document();

            PdfWriter.getInstance(document, fil);


            document.open();
            String para1="                Nom projet : "+nptext.getText().isEmpty()
                    + "\n \n              categorie : "+cattext.getValue()
                    + "\n \n              tel_projet :  "+telptext.getText()
                    + "\n \n              email_projet : "+eptext.getText()
                    + "\n \n              Adresse :      "+adtext.getText()
                    + "\n \n              votre_finance : "+ Votrefinancetext.getText()
                    + "\n \n              nbre_team :    "+nbreteamtext.getText()
                   
                    + "\n \n              montant :      "+montanttext.getText()
                    + "\n \n              compte_bancaire :    "+comptbancairetext.getText()
                   
                    + "\n \n              date_debut :   "+"01,06,2019"
                    + "\n \n              duree :   "+dureeprojet.getText();
        

            Paragraph paragraph = new Paragraph(para1);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph);
       
            document.close();
            fil.close();
            }
        
    }
private boolean DateCorrect() {

         long millis=System.currentTimeMillis();  
           java.sql.Date date2=new java.sql.Date(millis);  
           String MDP = datedebutprojet.getValue().toString();
           int MD2 = date2.toLocalDate().getMonthValue();
           int YD2 = date2.toLocalDate().getYear();
           int DD2 = date2.toLocalDate().getDayOfMonth();
        
           int A = Integer.parseInt(MDP.substring(0, 4));
           int M = Integer.parseInt(MDP.substring(5, 7));
           int D = Integer.parseInt(MDP.substring(8,10));
          /* if ( m.find() && m.group().equals(datefield.getText())){*/
               if (A > YD2 ){return true;}
               else if (A==YD2){  
                       if (M > MD2 ){return true;}
                       else if ( M==MD2 ){
                           if (D>DD2){return true;}
                           else  {   
                               Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                               
                               
                               return false;} 
                                      }
                       else  { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                           return false;} //if (M<MD2)
                                   }
               else  {
                         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                   
                   return false;} }
        
    @FXML
    private void uploadimageAction(ActionEvent event) {
    }

    
    
   

    
}
