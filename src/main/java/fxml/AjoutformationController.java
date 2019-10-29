package fxml;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Formation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.DomaineService;
import services.FormationService;
//import services.Upload;

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
  //  Upload u = new Upload();
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
    /**
     * Initializes the controller class.
     */
   private int[] verif=new int[] {0,0,0,0,0,0,0,0 };
    @FXML
    private Button btn_ajouter_pdf;
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
        
         Formation f = new Formation(ds.getDomaineByID(domainecombo.getSelectionModel().getSelectedItem().toString()),txt_nom.getText(),txt_description.getText(),duree,
             d,dd,prix,txt_adresse.getText(),txt_email.getText(),contact);
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
       /*    FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png")
        );
        selectedfilFile = fc.showOpenDialog(null);
        if (selectedfilFile != null) {
            System.out.println("where are u at");
            Upload u = new Upload();
            u.upload(selectedfilFile);
            imageupload.getItems().add(selectedfilFile.getName());
  System.out.println("c bn");
            path_img = selectedfilFile.getAbsolutePath();
            System.out.println("BLess you man");
        } else {
            System.out.println("FICHIER erroné");
        }*/
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
        if (txt_prix.getText().length() < 7 && Pattern.matches("[0-9]+", txt_prix.getText())) {
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

    private void pdf_action(ActionEvent event) {
   //     pdf a = new pdf();
    //    a.creation();
      
    }

    @FXML
    private void ajouter_formation_pdf_action(ActionEvent event) {
    }
    
}
