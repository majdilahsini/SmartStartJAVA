/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author radhwen
 */
public class Forum_1Controller implements Initializable {

    @FXML
    private Text nomUtilisateur;
    @FXML
    private Text date;
    @FXML
    private ImageView img;
    @FXML
    private Text id;
    @FXML
    private JFXButton Supprimer;
    @FXML
    private Text Commentaire;
    @FXML
    private JFXButton Modifier;
    @FXML
    private JFXButton Rel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerCom(MouseEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }
    
}
