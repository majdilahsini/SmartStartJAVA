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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class OffreController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text date;
    @FXML
    private Text nbr;
    @FXML
    private JFXButton consulteroffre;
    @FXML
    private Text id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulteroffreAction(ActionEvent event) {
    }
    
}
