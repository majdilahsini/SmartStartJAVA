/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import services.adminService;
import services.usersService;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.mail.MessagingException;
import static services.sendmailtoadmin.sendadmin;
/**
 * FXML Controller class
 *
 * @author firos
 */
public class panelloginadminController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private JFXTextField usernameadmin;
    @FXML
    private JFXPasswordField passadmin;
    @FXML
    private Label error;
    @FXML
    private ImageView verifIcon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginadmin(ActionEvent event) throws SQLException, IOException, MessagingException {
         if (usernameadmin.getText().isEmpty()||passadmin.getText().isEmpty()){
             
        
               showAlert(Alert.AlertType.ERROR, passadmin.getScene().getWindow(), 
    "Form Error!", "Veuillez remplir tous les champs!");
         
         }
         adminService c=new adminService();
            String s=c.validerLogin(usernameadmin.getText(),passadmin.getText());
 
         // validation.setText( s);
        if(s.equals("admin n'existe pas ")){
                showAlert(Alert.AlertType.ERROR, passadmin.getScene().getWindow(), 
    "Form Error!", "admin n'existepas");
        }
        else if(s.equals("admin correct ")){
           adminService a=new adminService();
           String mailadmin=a.Adminemail(usernameadmin.getText());
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/MainWindowAdmin.fxml"));
            Parent root =loader.load();
            Scene tableViewScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
            window.setScene(tableViewScene);
            window.show();
          Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
        String time=sdf.format(cal.getTime());
        InetAddress inetAddress = InetAddress.getLocalHost();
        String IP=inetAddress.getHostAddress()+inetAddress.getHostName();
        sendadmin(mailadmin,IP,time);
        }
        }
             private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}

    @FXML
    private void verifentry(KeyEvent event) {
    }

    @FXML
    private void checkentry(KeyEvent event) {
    }
    
}
