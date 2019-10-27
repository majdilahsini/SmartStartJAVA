/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Offre;
import java.util.List;

/**
 *
 * @author p
 */
public interface iOffre {
    
    public int ajouterOffre(Offre e);
    public int modifierOffre(Offre e);
    public void supprimerOffre(int id);
    public List<Offre> AfficherOffres();
    public List<Offre> AfficherOffresByEntreprise(int id);
    public String getDomaineByID(Offre e);
    public String getEntrepriseByID(Offre e);
    public String getLangueByRef(Offre e);
    public String getTypeDePosteByID(Offre e);
}
