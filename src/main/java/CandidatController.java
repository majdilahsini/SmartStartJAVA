/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import entities.Session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javax.mail.MessagingException;
import services.ServiceOffre;
import static utils.Notifieroffremail.notifier;


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
    private Text mail;
    @FXML
    private Text langues;
    @FXML
    private ProgressIndicator ringprogress;
    @FXML
    private Text message;
    @FXML
    private JFXButton notifermail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void notierAction(ActionEvent event) throws MessagingException {
        
        ServiceOffre s = new ServiceOffre();
        BorderPane bp;
        
        bp = (BorderPane) id.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
        Text t = (Text) bp.lookup("#nom");
        
        
        notifier(mail.getText(),nom.getText(),t.getText(),s.getEntrepriseByID(Session.getId()));
        notifermail.setVisible(false);
        message.setVisible(true);
        
        
    }
    
}
