/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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
import utils.Getlists;
import static utils.Getlists.contient;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class AjouterOffreController implements Initializable {

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
    


    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void titrefieldoffreverify(KeyEvent event) {
        
        if (titrefield.getText().length()>3) 
                titreicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                titreicon.setImage(new Image("/fxml/assets/error.png"));
        
    }

    /*rivate void niveauetudefieldoffre(KeyEvent event) {

    }
*/
    @FXML
    private void niveaufieldoffreverify(KeyEvent event) {
        
                
         if (Pattern.matches("[0-9]+", niveaufield.getText()) && niveaufield.getText().length() == 1) 
                niveauetudeicon.setImage(new Image("/fxml/assets/ok.png"));
         else 
                niveauetudeicon.setImage(new Image("/fxml/assets/error.png"));
        
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
    private void ajouterbsdAction(ActionEvent event) {
        Getlists l = new Getlists();
        
        /*skillsarray[0] = l.getSkillbynom(skillscombo.getValue());
        System.out.println(skillsarray[0]);*/
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
}
