package interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Projet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface InterfaceServiceProjet {
     public void ajouterProjet(Projet p) throws SQLException;
     public void SupprimerProjet(int id) throws SQLException;
     public void ModifierProjet(Projet p) throws SQLException;
     public List<Projet> AfficheProjet() throws SQLException;
     public List<Projet> RechercheProjet(int id,String nom,String categorie) throws SQLException;
}
