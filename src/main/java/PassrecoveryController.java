/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Window;
//import javax.mail.MessagingException;
//import static services.sendmail.sendto;
import services.usersService;

/**
 * FXML Controller class
 *
 * @author firos
 */
public class PassrecoveryController implements Initializable {

    @FXML
    private JFXButton sendemail;
@FXML
    private JFXTextField textfield1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
    @FXML
    private void sendmailtoclient(ActionEvent event) throws MessagingException {
       String email= textfield1.getText();
       usersService a=new usersService();
       
      int b=a.getiduser(email);
      String h=a.Userpassword(email);
      if(b==0)
       {
       showAlert(Alert.AlertType.ERROR, textfield1.getScene().getWindow(), 
    "Form Error!", "compte non existant");
       
       }
       else{
          sendto(email,h);
          
       showAlert(Alert.AlertType.INFORMATION, textfield1.getScene().getWindow(), 
    "Form Error!", "mot de pass envoyer vers l'email"+email);
       
       }
        
    }*/
     private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}
}