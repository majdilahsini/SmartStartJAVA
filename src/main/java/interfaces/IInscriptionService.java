/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Inscription;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IInscriptionService {
    
   public void creerInscription(int user_id,int entreprise_id,int formation_ref,String lettre_motivation) throws SQLException ;
    
    public List<Inscription> afficherInscriptions ();
     public int NbrApplicationformation(int id) ;
     
   
}
