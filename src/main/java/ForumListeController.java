/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Offre;
import entities.Session;
import entities.Forum;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.ForumService;
import services.ServiceApplication;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author radhwen
 */
public class ForumListeController implements Initializable {

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
       /*  Parent root2;
        System.out.println(Session.getId());
        try {
            
           Forum f= new Forum();
            //ServiceOffre o = new ServiceOffre();
            ForumService o = new ForumService ();
            for (Offre e: o.AfficherCommentaire(Session.getId())) {
                root2 = FXMLLoader.load(getClass().getResource("/fxml/Offre_Utilisateur.fxml"));
                Text t = (Text) root2.lookup("#nom");
                t.setText(e.getTitre());

            
                Text entreprise = (Text) root2.lookup("#commentaire");
                entreprise.setText(o.get));
                
                Text contrat = (Text) root2.lookup("#contrat");
                contrat.setText(o.getTypeDePosteByID(e));
                
                Text domaine = (Text) root2.lookup("#domaine");
                domaine.setText(o.getDomaineByID(e));
                
                
             
                ImageView img = (ImageView) root2.lookup("#img");
                Image im = new Image(e.getPhoto());
                img.setImage(im);
                
                vbx.getChildren().add(root2);
            }


        } catch (IOException ex) {
            Logger.getLogger(MesOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }    
       
      
}

