/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Entreprise;
import java.util.List;

/**
 *
 * @author p
 */
public interface iEntreprise {
    
    public int ajouterEntreprise(Entreprise e);
    public int modifierEntreprise(Entreprise e);
    public void supprimerEntreprise(int id);
    public List<Entreprise> AfficherEntreprise();
    public String getSecteurByID(Entreprise e);
    public String getCategorieByID(Entreprise e);
    
}
