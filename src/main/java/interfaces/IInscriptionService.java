/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Inscription;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IInscriptionService {
    
    public void creerInscription(int user_id,int formation_ref,String lettre_motivation,String specialite,String ecole,Date datecreation,int etat_id) throws SQLException ;
    
    public List<Inscription> afficherInscriptions ();
     public int NbrApplicationformation(int id) ;
     public int afficheetat(int idd,int id);
     
   
}
