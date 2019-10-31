/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Formation;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IFormationService {
     public void creerFormation(Formation f) throws SQLException;
     public ArrayList<Formation> afficherFormation();
     public void supprimerFormation(Formation f);
    public void modifierFormation(String Nom,String description,int duree,Date date_debut,Date date_fin,Double prix,String adresse,String email,int contact,int ref)throws SQLException ;
  public ArrayList<Formation> affichermesFormation(int id);
}
