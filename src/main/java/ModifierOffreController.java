/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.common.io.Files;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Offre;
import entities.Session;
import java.awt.Color;
import java.awt.Paint;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import services.ServiceOffre;
import utils.Getlists;
import utils.OfrreSession;


/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class ModifierOffreController implements Initializable {

    @FXML
    private JFXTextField titrefield;
    @FXML
    private ImageView titreicon;
    @FXML
    private ImageView niveauetudeicon;
    @FXML
    private JFXTextField niveaufield;
    @FXML
    private JFXComboBox<String> poste;
    @FXML
    private JFXButton ajouterbsd;
    @FXML
    private JFXTextField niveaufield1;
    @FXML
    private JFXComboBox<String> skillscombo;
    private Text competencestext;
    private VBox vbox;
    @FXML
    private JFXComboBox<String> skillscombo1;
    @FXML
    private JFXComboBox<String> skillscombo2;
    
    private static int[] skillsarray = new int[]{0,0,0};
    @FXML
    private JFXComboBox<String> domaine;
    @FXML
    private JFXComboBox<String> langue;
    @FXML
    private ImageView salaireicon;
    private int[] verif = new int[]{0,0,0,0,0,0,0,0,0};
    private ImageView img;
    private JFXButton uploadimg;
    
    private File file;
    @FXML
    private Text message;
    @FXML
    private Text message1;
    @FXML
    private ImageView typeicon;
    @FXML
    private ImageView domaineicon;
    @FXML
    private ImageView langueicon;
    @FXML
    private ImageView compticon;
    @FXML
    private ImageView im;
    


    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       Getlists gl = new Getlists();
       ServiceOffre se = new ServiceOffre();
        for (Offre e : se.AfficherOffresByID(OfrreSession.getId())) {
            titrefield.setText(e.getTitre());
            niveaufield.setText(Integer.toString(e.getNiveau_etude()));
            niveaufield1.setText(Integer.toString(e.getSalaire()));
            
            im.setImage(new Image(e.getPhoto()));
            
           
        }  
        
    }    

    @FXML
    private void titrefieldoffreverify(KeyEvent event) {
        
        if (titrefield.getText().length()>3) {
            titreicon.setImage(new Image("/fxml/assets/ok.png"));
            verif[0]=1;
        }
                
         else {
            titreicon.setImage(new Image("/fxml/assets/error.png"));    
            verif[0]=0; 
        }
                
        
    }

    /*rivate void niveauetudefieldoffre(KeyEvent event) {

    }
*/
    @FXML
    private void niveaufieldoffreverify(KeyEvent event) {
        
                
         if (Pattern.matches("[0-9]+", niveaufield.getText()) && niveaufield.getText().length() == 1) {
             niveauetudeicon.setImage(new Image("/fxml/assets/ok.png"));
             verif[1]=1;
         }
                
         else  {
             niveauetudeicon.setImage(new Image("/fxml/assets/error.png"));
             verif[1]=0;
         }
                
                
        
    }

    @FXML
    private void typepostshow(Event event) {
        
        Getlists l = new Getlists();
        
        //for(String s : l.getPostes())
        poste.getItems().clear();
            for (String s: l.getPostes())  
                poste.getItems().addAll(s);
                
        
    }

    @FXML
    private void ajouterbsdAction(ActionEvent event) throws MalformedURLException {

        
        if (domaine.getValue() != null) {
            domaineicon.setImage(new Image("/fxml/assets/ok.png"));
            verif[3] = 1;
        } else 
            domaineicon.setImage(new Image("/fxml/assets/error.png"));
                
        if (poste.getValue() != null) {
            typeicon.setImage(new Image("/fxml/assets/ok.png"));
            verif[4] = 1;
        } else
            typeicon.setImage(new Image("/fxml/assets/error.png"));
            
        if (langue.getValue() != null){
            langueicon.setImage(new Image("/fxml/assets/ok.png"));
            verif[5] = 1;
        } else 
            langueicon.setImage(new Image("/fxml/assets/error.png"));
            
        if (skillscombo.getValue() != null) {
            compticon.setImage(new Image("/fxml/assets/ok.png"));
            verif[6] = 1;
        } else {
            compticon.setImage(new Image("/fxml/assets/error.png"));
        }
        
        if (titrefield.getText().length() == 0)
            titreicon.setImage(new Image("/fxml/assets/error.png"));
        if (niveaufield.getText().length() == 0)
            niveauetudeicon.setImage(new Image("/fxml/assets/error.png"));
        if (niveaufield1.getText().length() == 0)
            salaireicon.setImage(new Image("/fxml/assets/error.png"));
            
        
        int s=0;
        for (int i: verif)
            s = s + i;
        
        Getlists gl = new Getlists();
        Offre e;
        ServiceOffre o = new ServiceOffre();
        
        if (s == 7) {
            
            if ( file == null) {
            e = new Offre (OfrreSession.getId(),titrefield.getText(), 
                                 gl.getDomainebynom(domaine.getValue()),
                                 Session.getId(),
                                 Integer.parseInt(niveaufield.getText()),
                                 gl.getLanguebyRef(langue.getValue()),
                                 gl.getTypeDePosteByID(poste.getValue()),
                                 gl.getSkillbynom(skillscombo.getValue()),
                                 gl.getSkillbynom(skillscombo1.getValue()),
                                 gl.getSkillbynom(skillscombo2.getValue()),
                                 Integer.parseInt(niveaufield1.getText()),
                                 "/fxml/assets/No_Image_Available.jpg");
            } else {
                file.renameTo(new File("C:\\wamp64\\www\\"+file.getName()));
                e = new Offre (OfrreSession.getId(),titrefield.getText(), 
                                 gl.getDomainebynom(domaine.getValue()),
                                 Session.getId(),
                                 Integer.parseInt(niveaufield.getText()),
                                 gl.getLanguebyRef(langue.getValue()),
                                 gl.getTypeDePosteByID(poste.getValue()),
                                 gl.getSkillbynom(skillscombo.getValue()),
                                 gl.getSkillbynom(skillscombo1.getValue()),
                                 gl.getSkillbynom(skillscombo2.getValue()),
                                 Integer.parseInt(niveaufield1.getText()),
                                 "file:/C:/wamp64/www/"+file.getName()); 
                                 
            } 
            
          
          if (o.modifierOffre(e) == 1) {
              //message.setText("Votre offre a été crée");
              message.setVisible(true);
              message1.setVisible(false);
              //message.setStyle("-fx-text-inner-color: Green;");
          } else {
              //message.setText("Erreur de création de l'offre");
              message1.setVisible(true);
          }
                
              
        } else {
            //message.setText("Erreur de création de l'offre");
            message1.setVisible(true);
        }

         System.out.println(s);   
       
        
    }

    @FXML
    private void skillscomboshown(Event event) {
        
        Getlists l = new Getlists();
        
        //for(String s : l.getPostes())
        skillscombo.getItems().clear();
            for (String s: l.getSkills()) {
                if (!s.equals(skillscombo1.getValue()) && (!s.equals(skillscombo2.getValue())))
                    skillscombo.getItems().addAll(s);
                }
        
    }

    @FXML
    private void skillscombo1shown(Event event) {
        
        Getlists l = new Getlists();
        
        //for(String s : l.getPostes())
        skillscombo1.getItems().clear();
            for (String s: l.getSkills()) {
                if (!s.equals(skillscombo.getValue()) && (!s.equals(skillscombo2.getValue())))
                    skillscombo1.getItems().addAll(s);
                }
        
    }

    @FXML
    private void skillscombo2shown(Event event) {
        
         Getlists l = new Getlists();
        
        //for(String s : l.getPostes())
        skillscombo2.getItems().clear();
            for (String s: l.getSkills()) {
                if (!s.equals(skillscombo1.getValue()) && (!s.equals(skillscombo.getValue()))) {
                    skillscombo2.getItems().addAll(s);
                } 
            
           
          /*for (int i :skillsarray)
          System.out.println(""+i+"\n");*/
        
    }
 
    }

    @FXML
    private void domaineshow(Event event) {
        
        Getlists l = new Getlists();
        domaine.getItems().clear();
            for (String s: l.getDomaines()) {
                    domaine.getItems().addAll(s);
                }
        
    }
        
    

    @FXML
    private void langueshow(Event event) {
        
        Getlists l = new Getlists();
        langue.getItems().clear();
            for (String s: l.getLangues()) {
                    langue.getItems().addAll(s);
                }
        
    }

    @FXML
    private void Salaireverif(KeyEvent event) {
        
        if (Pattern.matches("[0-9]+", niveaufield1.getText())) {
            salaireicon.setImage(new Image("/fxml/assets/ok.png"));
            verif[2] =1;
        }
                
         else  {
            salaireicon.setImage(new Image("/fxml/assets/error.png"));     
            verif[2] =0;   
        }
                
    }

    @FXML
    private void uploadimgAction(ActionEvent event) throws MalformedURLException {
        
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(uploadimg.getScene().getWindow());
        
        if(file != null){
            Image img1 = new Image(file.toURI().toURL().toExternalForm());
            img.setImage(img1);
            img.setFitWidth(129);
            img.setFitHeight(127);
            img.setPreserveRatio(true);
        }
    }


    
}