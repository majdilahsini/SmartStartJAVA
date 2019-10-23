/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Offre;
import entities.Userskill;
import java.util.List;

/**
 *
 * @author p
 */
public interface iUserskills {
    
    public int ajouterUserskill(Userskill u);
    public int modifierUserskill(Userskill u);
    public void supprimerOffre(int id);
    public List<Userskill> AfficherUserskills();
    
}
