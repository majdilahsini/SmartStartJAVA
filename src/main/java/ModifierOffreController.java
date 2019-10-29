/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class ModifierOffreController implements Initializable {

    @FXML
    private JFXTextField titrefield;
    @FXML
    private JFXComboBox<?> domaine;
    @FXML
    private JFXComboBox<?> langue;
    @FXML
    private JFXComboBox<?> poste;
    @FXML
    private JFXButton ajouterbsd;
    @FXML
    private ImageView titreicon;
    @FXML
    private ImageView niveauetudeicon;
    @FXML
    private JFXTextField niveaufield;
    @FXML
    private JFXTextField niveaufield1;
    @FXML
    private JFXComboBox<?> skillscombo;
    @FXML
    private JFXComboBox<?> skillscombo1;
    @FXML
    private JFXComboBox<?> skillscombo2;
    @FXML
    private ImageView salaireicon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void titrefieldoffreverify(KeyEvent event) {
    }

    @FXML
    private void domaineshow(Event event) {
    }

    @FXML
    private void langueshow(Event event) {
    }

    @FXML
    private void typepostshow(Event event) {
    }

    @FXML
    private void ajouterbsdAction(ActionEvent event) {
    }

    @FXML
    private void niveaufieldoffreverify(KeyEvent event) {
    }

    @FXML
    private void Salaireverif(KeyEvent event) {
    }

    @FXML
    private void skillscomboshown(Event event) {
    }

    @FXML
    private void skillscombo1shown(Event event) {
    }

    @FXML
    private void skillscombo2shown(Event event) {
    }
    
}
