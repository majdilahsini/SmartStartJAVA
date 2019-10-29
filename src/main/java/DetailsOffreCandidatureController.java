/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Candidat;
import entities.Offre;
import entities.Session;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.ServiceApplication;
import services.ServiceCandidat;
import services.ServiceOffre;
import utils.OfrreSession;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class DetailsOffreCandidatureController implements Initializable {

    @FXML
    private Text nom;
    @FXML
    private Text date;
    @FXML
    private Text id;
    @FXML
    private Text nbr;
    @FXML
    private ScrollPane a;
    @FXML
    private VBox vbx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Parent root2;
        try {
            
           
            ServiceOffre o = new ServiceOffre();
            ServiceApplication a = new ServiceApplication ();
            for (Offre e: o.AfficherOffresByID(OfrreSession.getId())) {
                root2 = FXMLLoader.load(getClass().getResource("/fxml/Offre_Utilisateur.fxml"));

                nom.setText(e.getTitre());

                id.setText(Integer.toString(e.getId()));
                System.out.println(id.getText());

                nbr.setText(Integer.toString(a.NbrApplicationOffre(e.getId()))+ " Candidatures");

                date.setText("Publié le "+e.getDate_publication());
                
                 
            }


        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Parent root;
        try {
            
           
            ServiceCandidat sc = new ServiceCandidat();
            ServiceOffre o = new ServiceOffre();
            for (Candidat c: sc.AfficherCandidat(OfrreSession.getId())) {
                root2 = FXMLLoader.load(getClass().getResource("/fxml/Candidat.fxml"));
                
                Text t = (Text) root2.lookup("#nom");
                t.setText(c.getFullname());
                
                Text t2 = (Text) root2.lookup("#id");
                t2.setText(Integer.toString(c.getId()));
                
   
                Text t3 = (Text) root2.lookup("#tel");
                t3.setText(c.getTel());
                
                Text t4 = (Text) root2.lookup("#mail");
                t4.setText(c.getEmail()); 
                
                ProgressIndicator p = (ProgressIndicator) root2.lookup("#ringprogress");
                p.setProgress(c.getMatch());
                
                Text langues = (Text) root2.lookup("#langues");
                langues.setText("Les Langues :"+ o.getLangueByRef(c.getLangue1())+ ", "+c.getLangue2());
                
                Text skills = (Text) root2.lookup("#skills");
                skills.setText("Les compétences :"+ o.getSkillByID(c.getSkill1())+ o.getSkillByID(c.getSkill2())+ o.getSkillByID(c.getSkill3()));
                
                vbx.getChildren().add(root2);
            }


        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
