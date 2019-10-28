/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import static com.sun.glass.ui.Cursor.setVisible;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author lenovo
 */
public class MainWindowUtilisateurController implements Initializable {
    
    private Label label;
    @FXML
    private TitledPane offrebtn;
    @FXML
    private BorderPane borderpane;
    @FXML
    private JFXButton deconnect1;
    @FXML
    private JFXButton deconnect11;
    @FXML
    private JFXButton deconnect2;
    private JFXButton offresbtn;
    @FXML
    private TitledPane monespace;
    @FXML
    private JFXButton deconnect12;
    @FXML
    private JFXButton deconnect121;
    @FXML
    private JFXButton deconnect111;
    @FXML
    private JFXButton deconnect1111;
    @FXML
    private JFXButton consulterlesoffres;
    @FXML
    private JFXButton Quit;

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                       // pane_formation.setVisible(false);

        // TODO
    }    

    private void redirect(ActionEvent event) throws IOException {
       
    }

    private void fermer(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void returntologin(ActionEvent event) throws IOException {
        
        //AnchorPane anchorpane;
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Signup.fxml"));
        //Scene scene = new Scene(root);
        //anchorpane = (Stage)deconnect.getScene().getWindow();
        //anchorpane.hide();
        borderpane.setCenter(root);
        
    }

    @FXML
    private void offrebtnAction(MouseEvent event) {
        
        offrebtn.lookup(".arrow").setVisible(true);

        
    }

    @FXML
    private void consulterlesoffresActions(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/LesOffres.fxml"));
        borderpane.setCenter(root);
        
    }

    @FXML
    private void quitAction(ActionEvent event) {
        
        Stage stage = (Stage) Quit.getScene().getWindow();
        stage.close();
        
    }



    
}
