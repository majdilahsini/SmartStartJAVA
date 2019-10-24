/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Certificats;
import java.util.List;

/**
 *
 * @author firos
 */
public interface ICertificatsService {
    public void creerCertificats(Certificats p);
    public void modifierCertificats(Certificats p);
    public void supprimerCertificats(Certificats p);
    public List<Certificats> afficherCertificats();
    
}
