/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import entities.Userlangues;
import entities.Userskill;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import services.ServiceUserskill;
import services.Serviceuserlangues;
import utils.Getlists;

/**
 * FXML Controller class
 *
 * @author p
 */
public class ModifierprofilController implements Initializable {

    @FXML
    private JFXTextField emailfield;
    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField pnField;
    @FXML
    private JFXTextField usrnField;
    @FXML
    private JFXPasswordField pwdField;
    @FXML
    private JFXTextField adressefield;
    @FXML
    private Line line1;
    @FXML
    private Line line2;
    @FXML
    private JFXButton ajoutskill;
    @FXML
    private JFXButton ajoutlangue;
    @FXML
    private JFXComboBox<String> skillscombo;
    @FXML
    private JFXComboBox<String> skillscombo1;
    @FXML
    private JFXComboBox<String> skillscombo2;
    @FXML
    private JFXComboBox<String> languecombo1;
    @FXML
    private JFXComboBox<String> languecombo2;
    @FXML
    private Text c1;
    @FXML
    private Text c2;
    @FXML
    private Text c3;
    @FXML
    private Text l1;
    @FXML
    private Text l2;
    @FXML
    private JFXComboBox<?> languecombo11;
    @FXML
    private JFXButton confirmer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void emailfield(KeyEvent event) {
    }

    @FXML
    private void fullnamefield(KeyEvent event) {
    }

    @FXML
    private void pnFieldv(KeyEvent event) {
    }

    @FXML
    private void usrnFieldv(KeyEvent event) {
    }

    @FXML
    private void pwdFieldv(KeyEvent event) {
    }

    @FXML
    private void Adressefield(KeyEvent event) {
    }

    @FXML
    private void ajoutskillAction(ActionEvent event) {
        c1.setVisible(true);
        c2.setVisible(true);
        c3.setVisible(true);
        line1.setVisible(true);
        skillscombo.setVisible(true);
        skillscombo1.setVisible(true);
        skillscombo2.setVisible(true);
    }

    @FXML
    private void ajoutlangueAction(ActionEvent event) {
        
        l1.setVisible(true);
        l2.setVisible(true);
        line2.setVisible(true);
        languecombo1.setVisible(true);
        languecombo2.setVisible(true);
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
    private void langue2shown(Event event) {
        
        Getlists l = new Getlists();
        languecombo2.getItems().clear();
            for (String s: l.getLangues()) {
                if (!s.equals(languecombo1.getValue()))
            
                    languecombo2.getItems().addAll(s);
                }
    }

    @FXML
    private void langue1comboshown(Event event) {
        
        Getlists l = new Getlists();
        languecombo1.getItems().clear();
            for (String s: l.getLangues()) {
                if (!s.equals(languecombo2.getValue()))
            
                    languecombo1.getItems().addAll(s);
                }
    }

    @FXML
    private void confirmerAction(ActionEvent event) {
        Getlists gl = new Getlists ();
        Userskill us = new Userskill(Session.getId(), gl.getSkillbynom(skillscombo.getValue()),gl.getSkillbynom(skillscombo1.getValue()),gl.getSkillbynom(skillscombo2.getValue()));
        ServiceUserskill s = new ServiceUserskill ();
        s.ajouterUserskill(us);

        Userlangues ul = new Userlangues(Session.getId(), gl.getLanguebyRef(languecombo1.getValue()), gl.getLanguebyRef(languecombo2.getValue()));
        Serviceuserlangues s2 = new Serviceuserlangues ();
        s2.ajouterUserslangue(ul);
    }
    
}
