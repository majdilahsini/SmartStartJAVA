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
import java.net.MalformedURLException;

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
    private AnchorPane pane_image;
    @FXML
    private Button btn_ajouter_image;
    @FXML
    private JFXTextField txt_Nombres;
    
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
        
        int nombres = Integer.parseInt(txt_Nombres.getText());
        
        //  SimpleDateFormat formatter11 = new SimpleDateFormat("yyyy-MM-dd");
                 // java.util.Date datenow = formatter11.parse(.toString());
                  java.util.Date date=new java.util.Date();  
        java.sql.Date ddd = new Date(date.getTime());

        
        //  file.renameTo(new File("C:\\wamp64\\www\\image"+file.getName()));
         
        int j=0;
        for (int i : verif)
            j=j+i;
         file.renameTo(new File("C:\\wamp64\\www\\pidev2\\web\\images"+file.getName()));
         Formation f = new Formation(Session.getId(),ds.getDomaineByID(domainecombo.getSelectionModel().getSelectedItem().toString()),txt_nom.getText(),txt_description.getText(),duree,
             d,dd,txt_adresse.getText(),prix,contact,txt_email.getText(),file.getName(),nombres,nombres,1,1,ddd);
       
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
        image_formation.setVisible(false);
        
        domainecombo.getSelectionModel().clearSelection();
        datedeb_txt.setValue(null);        datefin_txt.setValue(null);
       formationImage7.setVisible(false);
    
     formationImage8.setVisible(false);;
    
     formationImage1.setVisible(false);;
    
     formationImage2.setVisible(false);;
    
     formationImage3.setVisible(false);;
    
    formationImage4.setVisible(false);;
    
     formationImage5.setVisible(false);;
    
   formationImage6.setVisible(false);;
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
        if (txt_contact.getText().length() == 8 && Pattern.matches("[0-9]+", txt_contact.getText())) {
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
         if (txt_email.getText().length()>8 && txt_email.getText().endsWith("@gmail.com") ) {
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
    private void email_controle12(KeyEvent event) {
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
    private boolean date_control1(KeyEvent event) throws ParseException {return false;
}

    @FXML
    private void date_control2(KeyEvent event) {
    }

    @FXML
    private void descrip_col(KeyEvent event) {
    }

    @FXML
    private void duree_col(MouseEvent event) {
    }

    @FXML
    private void adresse_col(MouseEvent event) {
    }

    @FXML
    private void prix_col(MouseEvent event) {
    }

    @FXML
    private void contact_col(MouseEvent event) {
    }
   /*  private boolean DateCorrect() {

         long millis=System.currentTimeMillis();  
           java.sql.Date date2=new java.sql.Date(millis);  
           String MDP = datefield.getText();
           int MD2 = date2.toLocalDate().getMonthValue();
           int YD2 = date2.toLocalDate().getYear();
           int DD2 = date2.toLocalDate().getDayOfMonth();
        
           int A = Integer.parseInt(MDP.substring(0, 4));
           int M = Integer.parseInt(MDP.substring(5, 7));
           int D = Integer.parseInt(MDP.substring(8,10));
          /* if ( m.find() && m.group().equals(datefield.getText())){*/
   /*            if (A > YD2 ){return true;}
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
   /*     private boolean DateCorrect3() {
            if (Integer.parseInt(datefield.getText().substring(5, 7)) > 12 ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Verifier Date");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
            return false;
         }
            else if (Integer.parseInt(datefield.getText().substring(8, 10)) > 31){
      Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Verifier Date");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
            return false;
    }
            else return true ; 
        }
        private boolean DateCorrect2() {
                     
         if ( datedeb_txt.getValue() == null ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Champ Date vide");
            alert.setContentText("Veuiller selectionner une Date");
            alert.showAndWait();
            return false;
                    }else{
                        return true;
                          }}*/
        private boolean validerDate1() {
            boolean b ;
          long millis=System.currentTimeMillis();  
           java.sql.Date date2=new java.sql.Date(millis);  
           String MDP = datedeb_txt.getValue().toString();
           int MD2 = date2.toLocalDate().getMonthValue();
           int YD2 = date2.toLocalDate().getYear();
           int DD2 = date2.toLocalDate().getDayOfMonth();
        
           int A = Integer.parseInt(MDP.substring(0, 4));
           int M = Integer.parseInt(MDP.substring(5, 7));
           int D = Integer.parseInt(MDP.substring(8,10));
           
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
                   
                   return false;}}
        
         private boolean validerDate2() {
            boolean b ;
          long millis=System.currentTimeMillis();  
           java.sql.Date date2=new java.sql.Date(millis);  
           String MDP = datefin_txt.getValue().toString();
           int MD2 = date2.toLocalDate().getMonthValue();
           int YD2 = date2.toLocalDate().getYear();
           int DD2 = date2.toLocalDate().getDayOfMonth();
        
           int A = Integer.parseInt(MDP.substring(0, 4));
           int M = Integer.parseInt(MDP.substring(5, 7));
           int D = Integer.parseInt(MDP.substring(8,10));
           
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
                   
                   return false;}}

    @FXML
    private void ajouter_formation_image_action(ActionEvent event) throws MalformedURLException {
          FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(btn_ajouter_image.getScene().getWindow());
        
        if(file != null){
            Image img1 = new Image(file.toURI().toURL().toExternalForm());
            image_formation.setImage(img1);
            image_formation.setFitWidth(129);
            image_formation.setFitHeight(127);
            image_formation.setPreserveRatio(true);
        }
    }
      
        
}
