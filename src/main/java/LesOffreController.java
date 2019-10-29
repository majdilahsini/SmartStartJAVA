/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.ServiceApplication;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Sadbo
 */
public class LesOffreController implements Initializable {

    @FXML
    private ScrollPane a;
    @FXML
    private VBox vbx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent root2;
        //System.out.println(Session.getId());
        try {
            
           
            ServiceOffre o = new ServiceOffre();
            ServiceApplication a = new ServiceApplication ();
            for (Offre e: o.AfficherOffres2(Session.getId())) {
                root2 = FXMLLoader.load(getClass().getResource("/fxml/Offre_Utilisateur.fxml"));
                Text t = (Text) root2.lookup("#nom");
                t.setText(e.getTitre());
                Text t2 = (Text) root2.lookup("#id");
                t2.setText(Integer.toString(e.getId()));
                Text nbr = (Text) root2.lookup("#nbr");
                nbr.setText(Integer.toString(a.NbrApplicationOffre(e.getId()))+ " Candidatures");
                Text date = (Text) root2.lookup("#date");
                date.setText("Publié le "+e.getDate_publication());
                
                Text entreprise = (Text) root2.lookup("#entreprise");
                entreprise.setText(o.getEntrepriseByID(e));
                
                Text contrat = (Text) root2.lookup("#contrat");
                contrat.setText(o.getTypeDePosteByID(e));
                
                Text domaine = (Text) root2.lookup("#domaine");
                domaine.setText(o.getDomaineByID(e));
                
                
                Text skills = (Text) root2.lookup("#skills");
                skills.setText("Les compétences :"+ o.getSkillByID(e.getSkill1_id())+ o.getSkillByID(e.getSkill2_id())+ o.getSkillByID(e.getSkill3_id()));
                
                vbx.getChildren().add(root2);
            }


        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
