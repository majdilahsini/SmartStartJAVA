/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class AjouterOffreController implements Initializable {

    @FXML
    private JFXTextField loginField;
    @FXML
    private JFXPasswordField pwdField;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verifentry(KeyEvent event) {
    }

    @FXML
    private void checkentry(KeyEvent event) {
    }
    
}
