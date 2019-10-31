package fxml;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Formation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import services.DomaineService;

import services.FormationService;
import entities.Session;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AjoutformationController implements Initializable {

    @FXML
    private AnchorPane pane_ajout_formation;
    @FXML
    private Button btn_ajouter_formation;
    @FXML
    private Button btn_img;
    @FXML
    private DatePicker datedeb_txt;
    @FXML
    private DatePicker datefin_txt;
    @FXML
    private JFXComboBox<String> domainecombo;
    @FXML
    private JFXTextField txt_nom;
    @FXML
    private JFXTextArea txt_description;
    @FXML
    private JFXTextField txt_duree;
    @FXML
    private JFXTextField txt_adresse;
    @FXML
    private JFXTextField txt_prix;
    @FXML
    private JFXTextField txt_contact;
    @FXML
    private JFXTextField txt_email;

    FormationService fs = new FormationService();
    DomaineService ds = new DomaineService();
    private Button btn_retour_formation;
      File selectedfilFile;
    String path_img;
  
    @FXML
    private ImageView image_formation;
    @FXML
    private ImageView formationImage7;
    @FXML
    private ImageView formationImage8;
    @FXML
    private ImageView formationImage1;
    @FXML
    private ImageView formationImage2;
    @FXML
    private ImageView formationImage3;
    @FXML
    private ImageView formationImage4;
    @FXML
    private ImageView formationImage5;
    @FXML
    private ImageView formationImage6;
    
    private File file;
    /**
     * Initializes the controller class.
     */
   private int[] verif=new int[] {0,0,0,0,0,0,0,0 };
    @FXML
    private Button btn_ajouter_pdf;
    @FXML
    private Button email_btn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
          ObservableList obs = FXCollections.observableArrayList(ds.getFormationType());
        domainecombo.setItems(obs);
    }    

    @FXML
    private void ajouter_formation_action(ActionEvent event) throws ParseException, SQLException {
         
          SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter1.parse(datedeb_txt.getValue().toString());
        java.sql.Date d = new Date(date1.getTime());
          java.util.Date date2 = formatter1.parse(datefin_txt.getValue().toString());
        java.sql.Date dd = new Date(date2.getTime());
          double prix = Double.parseDouble(txt_prix.getText());
     int contact = Integer.parseInt(txt_contact.getText());
        int duree = Integer.parseInt(txt_duree.getText());
        int j=0;
        for (int i : verif)
            j=j+i;
        
         Formation f = new Formation(Session.getId(),ds.getDomaineByID(domainecombo.getSelectionModel().getSelectedItem().toString()),txt_nom.getText(),txt_description.getText(),duree,
             d,dd,txt_adresse.getText(),prix,contact,txt_email.getText());
if(j==8)
        fs.creerFormation(f);

         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Formation insérée avec succés!");
        alert.show(); 
        txt_nom.setText("");
        txt_description.setText("");
        txt_duree.setText("");txt_prix.setText("");txt_adresse.setText("");txt_email.setText("");txt_contact.setText("");
        
        domainecombo.getSelectionModel().clearSelection();
        datedeb_txt.setValue(null);        datefin_txt.setValue(null);

       
    }

    @FXML
    private void browse(ActionEvent event) throws IOException {
         FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(btn_img.getScene().getWindow());
        if(file != null){
            Image img1 = new Image(file.toURI().toURL().toExternalForm());
            image_formation.setImage(img1);
            image_formation.setFitWidth(129);
            image_formation.setFitHeight(127);
            image_formation.setPreserveRatio(true);
        }
        
    }
    

    private void retour_formation_action(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/affich_formation.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage)btn_retour_formation.getScene().getWindow();
        stage.setScene(scene);
    }

 

    @FXML
    private void nom_formation_controle(KeyEvent event) {
        formationImage1.setImage(new Image("/fxml/assets/error.png"));
         if ( txt_nom.getText().length()>=3  ) {
            formationImage7.setImage(new Image("/fxml/assets/ok.png"));
            
            verif[0]=1;
        }
                
         else {
            formationImage7.setImage(new Image("/fxml/assets/error.png"));    
            verif[0]=0; 
        }
    }

    @FXML
    private void description_controle(KeyEvent event) {
         if (txt_description.getText().length()>=8) {
            formationImage8.setImage(new Image("/fxml/assets/ok.png"));
            verif[1]=1;
        }
                
         else {
            formationImage8.setImage(new Image("/fxml/assets/error.png"));    
            verif[1]=0; 
        }
    }

    @FXML
    private void duree_controle(KeyEvent event) {
        if (Pattern.matches("[0-9]+", txt_duree.getText()) && txt_duree.getText().length() == 2) {
             formationImage2.setImage(new Image("/fxml/assets/ok.png"));
             verif[2]=1;
         }
                
         else  {
             formationImage2.setImage(new Image("/fxml/assets/error.png"));
             verif[2]=0;
         }
    }

    @FXML
    private void adresse_controle(KeyEvent event) {
        if (txt_adresse.getText().length()>=3) {
            formationImage3.setImage(new Image("/fxml/assets/ok.png"));
            verif[6]=1;
        }
                
         else {
            formationImage3.setImage(new Image("/fxml/assets/error.png"));    
            verif[6]=0; 
        }
    }

    @FXML
    private void prix_controle(KeyEvent event) {
        if (Pattern.matches("[0-9]+", txt_prix.getText()) && txt_prix.getText().length() >=2 && txt_prix.getText().length() <=4 ) {
             formationImage4.setImage(new Image("/fxml/assets/ok.png"));
             verif[3]=1;
         }
                
         else  {
             formationImage4.setImage(new Image("/fxml/assets/error.png"));
             verif[3]=0;
         }
    }

    @FXML
    private void contact_controle(KeyEvent event) {
        if (txt_contact.getText().length() < 7 && Pattern.matches("[0-9]+", txt_contact.getText())) {
            formationImage5.setImage(new Image("/fxml/assets/ok.png"));
            verif[4]=1;
        }
                
         else {
            formationImage5.setImage(new Image("/fxml/assets/error.png"));    
            verif[4]=0; 
        }
    }

    @FXML
    private void email_controle(KeyEvent event) {
        
    }

    @FXML
    private void email_controle1(KeyEvent event) {
         if (txt_email.getText().length()>15 && txt_email.getText().endsWith("@gmail.com") ) {
            formationImage6.setImage(new Image("/fxml/assets/ok.png"));
            verif[5]=1;
        }
                
         else {
            formationImage6.setImage(new Image("/fxml/assets/error.png"));    
            verif[5]=0; 
        }
    }

    @FXML
    private void domainecomboAction(ActionEvent event) {
        if(domainecombo.getValue()!=null){
                        formationImage1.setImage(new Image("/fxml/assets/ok.png"));
        
                    verif[7]=1; 

        
        }

        
        
    }

  
    @FXML
    private void ajouter_formation_pdf_action(ActionEvent event) throws FileNotFoundException, DocumentException, ParseException, IOException {
          SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = formatter1.parse(datedeb_txt.getValue().toString());
        java.sql.Date d = new Date(date1.getTime());
          java.util.Date date2 = formatter1.parse(datefin_txt.getValue().toString());
        java.sql.Date dd = new Date(date2.getTime());
    
   
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
            String par2=" \n \n \n  FORMATION : "+txt_nom.getText();
                        
            String para1="\n \n           Domaine : "+domainecombo.getSelectionModel().getSelectedItem().toString()
                    + "\n \n              Description de la formation :  "+txt_description.getText()
                    + "\n \n              Duree:   "+txt_duree.getText()+" heures"
                    + "\n \n              Date debut :   "+d
                    + "\n \n              Date  fin :   "+dd 
                    + "\n \n              Adresse :   "+txt_adresse.getText()
                    + "\n \n              Prix formation :   "+ txt_prix.getText()+" DT"
                    + "\n \n              Vous pouvez nous contacter sur  :  "+txt_contact.getText()
                    + "\n \n              Notre email :   "+txt_email.getText()
              
                    
                    
                    
                    + "\n \n              Vous étes les bienvenus venus ";
                   
        

            Paragraph paragraph = new Paragraph(par2);
                        Paragraph paragraph2 = new Paragraph(para1);

                       // paragraph.setAlignment(Element.ALIGN_CENTER);
                        paragraph2.setAlignment(Element.TITLE);

                        paragraph2.setAlignment(Element.ALIGN_LEFT);
    //                       ImageData imageData = ImageDataFactory.create("logo.png");
   //Image pdfImg = new Image(imageData);
    
  // document.add((Element) pdfImg);
           
            document.add(paragraph);
              document.add(paragraph2);      
            document.close();
            fil.close();
    }
    
}

   

    @FXML
    private void browse(MouseEvent event) {
    }
}
