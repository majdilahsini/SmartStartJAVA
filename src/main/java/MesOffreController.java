/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class MesOffreController implements Initializable {

    @FXML
    private VBox vbx;
    @FXML
    private Button test;
    @FXML
    private ScrollPane a;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent root2;
        try {
            root2 = FXMLLoader.load(getClass().getResource("/fxml/Offre.fxml"));
            vbx.getChildren().add(root2);
        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void test(ActionEvent event) throws IOException {

    }
    
}
