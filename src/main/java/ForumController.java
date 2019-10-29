/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Connection.DBConnection;
import entities.Forum;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.ForumService;
import entities.Session;
import services.usersService;
//import LoginController1;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author radhwen
 */
public class ForumController implements Initializable {
    public ObservableList<Forum> data=FXCollections.observableArrayList();
    @FXML
    private TextArea commentaire;
    @FXML
    private Button Ajouter;
    @FXML
    private TableView<Forum> table;
    @FXML
    private TableColumn<Forum, String> nom;
    @FXML
    private TableColumn<Forum, String> com;
    
    
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField nomCom;
    @FXML
    private Label nomLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          System.out.println("You clicked me!");
       // label.setText("Hello World!");
        
       try{
         Connection con =  DBConnection.getInstance().getConnection();
               
           
            ResultSet rs = con.createStatement().executeQuery("select * from forum");
            while(rs.next()){
                data.add(new Forum(rs.getString("nom"),rs.getString("commentaire")));
               }
        }
        catch(SQLException e){ Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
      //  nom.setCellFactory(new PropertyValueFactory<>("nom"));
        
         nom.setCellValueFactory(new PropertyValueFactory("nom"));
         com.setCellValueFactory(new PropertyValueFactory("commentaire"));
         table.setItems(data);
    }

  /* private void AjouterCom(MouseEvent event) throws SQLException {
         usersService m=new usersService();
         int i=Session.getId();
         
         //   Session.getId()=m.getIdUtilisateur(loginField.getText(),pwdField.getText());
       String k= m.getUsername(i);
      
       
        Forum b= new Forum("hfs","ezfze");
        ForumService a= new ForumService();
        a.AjouterCommentaire(b);
        try {//FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
*/
    /*private void ajouter(ActionEvent event) throws SQLException {
         usersService m=new usersService();
         int i=Session.getId();
         
         //   Session.getId()=m.getIdUtilisateur(loginField.getText(),pwdField.getText());
         String k= m.getUsername(i);
         System.out.println(k);
       /*  if (commentaire.getText() == null) {
            new Alert(Alert.AlertType.ERROR, "Aucun msg").showAndWait();
           //  showAlert(Alert.AlertType.ERROR, "Aucun msg")
        }*/
       
        /*Forum b= new Forum(k,commentaire.getText());
        ForumService a= new ForumService();
        a.AjouterCommentaire(b);
        try {
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
              
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
*/
    @FXML
    private void fetch(MouseEvent event) {
       nomLabel.setText(table.getSelectionModel().getSelectedItem().getNom());
       commentaire.setText(table.getSelectionModel().getSelectedItem().getCommentaire());
       String b=table.getSelectionModel().getSelectedItem().getCommentaire();
    }

    @FXML
    private void modifierCom(MouseEvent event) {
        Forum b= new Forum("test",commentaire.getText());
        ForumService a= new ForumService();
        a.ModifierCommentaire(b);
        try {
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
              
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }

    @FXML
    private void modifier(ActionEvent event) {
         Connection con =  DBConnection.getInstance().getConnection();
        usersService m=new usersService();
         int i=Session.getId();
         
         
         //   Session.getId()=m.getIdUtilisateur(loginField.getText(),pwdField.getText());
         String k= m.getUsername(i);
          if (!(nomLabel.getText().equals(k))||(commentaire.getText().equals("")) ) {
            showAlert(Alert.AlertType.ERROR, commentaire.getScene().getWindow(), 
    "impossible de modifier ", "tu n'as pas de permission pour modifier");
        }
        else{
          ForumService a= new ForumService();
         String h=table.getSelectionModel().getSelectedItem().getCommentaire();

          int r = a.FindIdCommentaire(h);
        System.out.println("r=");
          System.out.println(r);
        Forum b= new Forum(k,r,commentaire.getText());
     //   System.out.println(commentaire.getText());
      
        
        a.ModifierCommentaire(b);
        try {//FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
       
            
          
    }

    @FXML
    private void SupprimerCom(MouseEvent event) {
       
        Connection con =  DBConnection.getInstance().getConnection();
        usersService m=new usersService();
         int i=Session.getId();
         
         //   Session.getId()=m.getIdUtilisateur(loginField.getText(),pwdField.getText());
         String k= m.getUsername(i);
          if (!(nomLabel.getText().equals(k)) ) {
            showAlert(Alert.AlertType.ERROR, commentaire.getScene().getWindow(), 
    "impossible de supprimer ", "tu n'as pas de permission");
        }
        else{
        
        Forum b= new Forum(k,commentaire.getText());
        ForumService a= new ForumService();
        a.SupprimerCommentaire(b);
        try {//FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }

    @FXML
    private void ajouter(MouseEvent event) throws SQLException {
        Connection con =  DBConnection.getInstance().getConnection();
        usersService m=new usersService();
         int i=Session.getId();
         
         //   Session.getId()=m.getIdUtilisateur(loginField.getText(),pwdField.getText());
         String k= m.getUsername(i);
         System.out.println(k);
        if ((commentaire.getText().equals("") )||(commentaire.getText().equals("9a7ba"))) {
            showAlert(Alert.AlertType.ERROR, commentaire.getScene().getWindow(), 
    "erreur d'ajouter", "impossible d'ajouter un message vide");
        }
        else{
        Forum b= new Forum(k,commentaire.getText());
        ForumService a= new ForumService();
        a.AjouterCommentaire(b);
        try {
                Parent page2 = FXMLLoader.load(getClass().getResource("Forum.fxml"));
              
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ForumController.class.getName()).log(Level.SEVERE, null, ex);
    }
        //message _ affichage direct dans la scene
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
    
    }    

 

