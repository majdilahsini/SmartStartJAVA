/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Entreprise;
import interfaces.iEntreprise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p
 */
public class ServiceEntreprise implements iEntreprise{
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public ServiceEntreprise () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public int ajouterEntreprise(Entreprise e) {
        
        int executeTest = 0; 
       
       try {
          
           String r1 = "INSERT INTO `entreprises` (`nom`,`secteur_id`,`taille`,`categorie_id`,`addresse`,`tel`)"
                     + "VALUES (?,?,?,?,?,?)";
           
           ps = c.prepareStatement(r1);
           ps.setString(1, e.getNom());
           ps.setInt(2, e.getSecteur_id());
           ps.setInt(3, e.getTaille());
           ps.setInt(4, e.getCategorie_id());
           ps.setString(5, e.getAddresse());
           ps.setString(6, e.getTel());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
        
    }

    @Override
    public int modifierEntreprise(Entreprise e) {
        
        int executeTest = 0; 
       
       try {
          
           String r = "UPDATE `entreprises` SET "
                   + "`nom`=?,"
                   + "`secteur_id`=?,"
                   + "`taille`=?,"
                   + "`categorie_id`=?,"
                   + "`addresse`=?,"
                   + "`tel`=?"
                   + " WHERE id = ?";
           
           ps = c.prepareStatement(r);
           ps.setString(1, e.getNom());
           ps.setInt(2, e.getSecteur_id());
           ps.setInt(3, e.getTaille());
           ps.setInt(4, e.getCategorie_id());
           ps.setString(5, e.getAddresse());
           ps.setString(6, e.getTel());
           ps.setInt(7, e.getId());
           
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
        
    }

    @Override
    public void supprimerEntreprise(int id) {
        
        try {
            
            String r = "DELETE FROM `entreprises` WHERE `id` = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Entreprise> AfficherEntreprise() {
        
        List<Entreprise> entreprises = new ArrayList<>();
        Entreprise e = null;
        
        String r = "SELECT * FROM `entreprises`";
        
        try {
            
            res = st.executeQuery(r);
            while(res.next()) {
                e = new Entreprise();
                    e.setId(res.getInt("id"));
                    e.setNom(res.getString("nom"));
                    e.setSecteur_id(res.getInt("secteur_id"));
                    e.setTaille(res.getInt("taille"));
                    e.setCategorie_id(res.getInt("categorie_id"));
                    e.setAddresse(res.getString("addresse"));
                    e.setTel(res.getString("tel"));
                entreprises.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return entreprises;
        
    }

    @Override
    public String getSecteurByID(Entreprise e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCategorieByID(Entreprise e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
