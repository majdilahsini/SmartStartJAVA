/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Application;
import java.util.List;

/**
 *
 * @author p
 */
public interface iApplication {
    
    public int ajouterApplication(Application a);
    public void supprimerApplication(int id);
    public List<Application> AfficherApplication();
    public List<Application> AfficherApplicationById_O(int id);
    public List<Application> AfficherApplicationById_u(int id);
    public String getOffreByID(Application a);
    public String getUtilisateurByID(Application a);

}
