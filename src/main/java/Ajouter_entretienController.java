/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import fxml.*;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.Entretien;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import services.EntretienService;
import services.ServiceEntreprise;
import services.ServiceEntreprisePlus;
import services.ServiceUtilisateur;
import services.ServiceUtilisateurPlus;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Ajouter_entretienController implements Initializable {

    private JFXTextField ReferenceText;
    private JFXTextField IdentText;
    private JFXTextField IduserText;
    private JFXTextField PosteText;
    @FXML
    private JFXTextArea DescriptionText;
    private DatePicker DatePicker;
    @FXML
    private JFXTextField HeureText;
    @FXML
    private Button effectuer_ajout_Btn;
    private JFXTextField DateText;
    @FXML
    private JFXComboBox<String> nom_utlisateurCombo;
    private JFXComboBox<String> prenom_utlisateurCombo;
    @FXML
    private JFXDatePicker date_ent;
    
    EntretienService es = new EntretienService();
    ServiceEntreprisePlus se = new ServiceEntreprisePlus();
    ServiceUtilisateurPlus su = new ServiceUtilisateurPlus();
    @FXML
    private JFXTextField postText;
    @FXML
    private ImageView retourbtn;
    @FXML
    private JFXButton retourbutton;
    @FXML
    private JFXTextField nomEnt_Text;
    @FXML
    private BorderPane BorderAjoutEntretien;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
     /*   ObservableList obs = FXCollections.observableArrayList(se.getNomEntType());
        entrepriseCombo.setItems(obs);*/
                         int i =   Session.getId();

                nomEnt_Text.setText(String.valueOf(se.getNomEntByID(i)));

        ObservableList obs1 = FXCollections.observableArrayList(su.getNomUserType());
        nom_utlisateurCombo.setItems(obs1);
        
  /*      ObservableList obs2 = FXCollections.observableArrayList(su.getPrenomUserType());
        prenom_utlisateurCombo.setItems(obs2); */
       } 
        
    @FXML
    private void ajouter_entretien_Action(ActionEvent event) throws ParseException, SQLException, IOException {
        /*SimpleDateFormat changerl = new SimpleDateFormat("yyyy-MM-dd");
                 date1 = date_ent.getValue().toString();
validerHeure() &&
         java.sql.Date d = new Date(datel.getTime());*/
       if (  validerCombo1Vide() && validerPosteVide() && DateCorrect2() && validerDate() && validerHeure()   && validerDescriptionVide()  ) {
         String date1 = date_ent.getValue().toString();
         Entretien e = new Entretien (se.getEntByID(nomEnt_Text.getText()),
                 su.getUserByID(nom_utlisateurCombo.getSelectionModel().getSelectedItem().toString()),
                 postText.getText(),
                 date1, HeureText.getText(),DescriptionText.getText());
         
          /*        Entretien e = new Entretien (se.getEntByID(entrepriseCombo.getSelectionModel().getSelectedItem().toString()),
                 su.getUserByID(nom_utlisateurCombo.getSelectionModel().getSelectedItem().toString(),prenom_utlisateurCombo.getSelectionModel().getSelectedItem().toString()),
                 postText.getText(),
                 DateeText.getText(), HeureText.getText(),DescriptionText.getText());*/
         es.CreerEntretien(e);
     /*    entrepriseCombo.getSelectionModel().clearSelection();*/
         nom_utlisateurCombo.getSelectionModel().clearSelection();
               /*  prenom_utlisateurCombo.getSelectionModel().clearSelection();*/
        Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/afficher_entretien.fxml"));
        BorderAjoutEntretien.setCenter(root1);
                  
                /* Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/afficher_entretien.fxml"));
        Scene scene = new Scene(signUpPage);
        stage = (Stage)effectuer_ajout_Btn.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();     */
    }  
    }
    
       
        
        
       /* effectuer_ajout_Btn.setOnAction(event -> {
            
            Entretien e = new Entretien (PosteText.getText(),DateText.getText(),HeureText.getText(),DescriptionText.getText());
            EntretienService pdao = EntretienService.getInstance();
             try {
                 pdao.insert(e);
             } catch (SQLException ex) {
                 Logger.getLogger(Ajouter_entretienController.class.getName()).log(Level.SEVERE, null, ex);
             }
             });*/

    @FXML
    private void retour_Action(MouseEvent event) throws IOException {
  
    }

    @FXML
    private void retourbtn_Action(ActionEvent event) throws IOException {
            Alert alert = new Alert(AlertType.CONFIRMATION); 
            alert.setContentText("Confirmer sortie");
            alert.setTitle("Retour");
            alert.setHeaderText("Vous etes sure de sortir sans enregister modifications ?");
           /* alert.showAndWait();*/
            Optional<ButtonType> result = alert.showAndWait();
      if ( result.isPresent() && result.get() == ButtonType.OK){
         Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/afficher_entretien.fxml"));
        BorderAjoutEntretien.setCenter(root1);
         
          /*Stage stage;
        Parent signUpPage = FXMLLoader.load(getClass().getResource("/fxml/afficher_entretien.fxml"));
        Scene scene = new Scene(signUpPage);
        stage = (Stage)retourbtn.getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();   */
    }
    

    }

    private boolean validerHeure() {
        Pattern p = Pattern.compile("[0-9][0-9]+([:][0-9][0-9]+)+");
        Matcher m = p.matcher(HeureText.getText());
        if ( m.find() && m.group().equals(HeureText.getText())){
            return true ;
        }else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("valider Heure");
            alert.setHeaderText("Verifier Heure");
            alert.setContentText("Svp entrer l'heure de forme hh:mm ex: 11:30");
            alert.showAndWait();
            return false;
        }
        }
    
     private boolean DateCorrect2() {
                     
         if ( date_ent.getValue() == null ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Champ Date vide");
            alert.setContentText("Veuiller selectionner une Date");
            alert.showAndWait();
            return false;
                    }else{
                        return true;
                          }}
        
        
        private boolean validerDate() {
            boolean b ;
          long millis=System.currentTimeMillis();  
           java.sql.Date date2=new java.sql.Date(millis);  
           String MDP = date_ent.getValue().toString();
           int MD2 = date2.toLocalDate().getMonthValue();
           int YD2 = date2.toLocalDate().getYear();
           int DD2 = date2.toLocalDate().getDayOfMonth();
        
           int A = Integer.parseInt(MDP.substring(0, 4));
           int M = Integer.parseInt(MDP.substring(5, 7));
           int D = Integer.parseInt(MDP.substring(8,10));
           
           if (A > YD2 ){return true;}
               else if (A==YD2){  
                       if (M > MD2 ){return true;}
                       else if ( M==MD2 ){
                           if (D>DD2){return true;}
                           else  {   
                               Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                               
                               
                               return false;} 
                                      }
                       else  { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                           return false;} //if (M<MD2)
                                   }
               else  {
                         Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("valider Date");
            alert.setHeaderText("Daté depassé");
            alert.setContentText("Svp entrer date de forme YYYY-MM-DD ex: 2019-10-08");
            alert.showAndWait();
                   
                   return false;}}
        
        
                private boolean validerPosteVide() {
              Pattern p = Pattern.compile("");
        Matcher m = p.matcher(postText.getText());
        if ( m.find() && m.group().equals(postText.getText())){

                       Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("valider Poste");
            alert.setHeaderText("Verifier le champ poste");
            alert.setContentText("Veuiller remplir tous les champs vides");
            alert.showAndWait();
                        return false ;

        }else{
 
            return true;
        }
        }
                              private boolean validerDescriptionVide() {
              Pattern p = Pattern.compile("");
        Matcher m = p.matcher(DescriptionText.getText());
        if ( m.find() && m.group().equals(DescriptionText.getText())){

                       Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("valider Description");
            alert.setHeaderText("Verifier le champ Description");
            alert.setContentText("Veuiller remplir tous les champs vides");
            alert.showAndWait();
                        return false ;

        }else{
 
            return true;
        }
        }
     
         private boolean validerCombo1Vide() {
        if ( nom_utlisateurCombo.getValue() == null ){

                       Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("valider Nom Condidat");
            alert.setHeaderText("Verifier le champ Nom Condidat");
            alert.setContentText("Veuiller remplir tous les champs vides");
            alert.showAndWait();
                        return false ;

        }else{
 
            return true;
        }
        }
                
                
     /*  private boolean validerposte() {
 
        }*/
        
 /*       private boolean ChampsVideNULL() {
                    String date1 = date_ent.getValue().toString();

        Pattern p = Pattern.compile("[0-9][0-9][0-9][0-9]+([-][0-9][0-9]+)+([-][0-9][0-9]+)+");
        Matcher m = p.matcher(date1);
                        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(PosteText.getText());
        if ( m.find() && m.group().equals(PosteText.getText())){
                        Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Champs vides");
            alert.setHeaderText("Verifier champ Poste");
            alert.setContentText("Veuiller remplir le champ POSTE");
            alert.showAndWait();
            return false;
        }else{

                        return true ;

        }
        }*/
        
    

    @FXML
    private void nom_utlisateurCombo_Action(ActionEvent event) {
        String nom_user = nom_utlisateurCombo.getSelectionModel().getSelectedItem().toString();
        int i = su.getPUserByID(nom_user);
        
        ObservableList obs2 = FXCollections.observableArrayList(su.getPUserType(i));
        prenom_utlisateurCombo.setItems(obs2);
        
    }

   
    }
 

