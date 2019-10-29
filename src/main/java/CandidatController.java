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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class CandidatController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text tel;
    @FXML
    private Text skills;
    @FXML
    private Text id;
    @FXML
    private JFXButton accepter;
    @FXML
    private Text mail;
    @FXML
    private Text langues;
    @FXML
    private ProgressIndicator ringprogress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accepterAction(ActionEvent event) {
    }
    
}
