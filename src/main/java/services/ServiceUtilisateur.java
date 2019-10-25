/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Offre;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sadbo
 */
public class ServiceUtilisateur {
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
     public ServiceUtilisateur () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     public int ajouterUtilisateur(Utilisateur e) {
     
       int executeTest = 0; 
       
       try {
          
           String r1 = "INSERT INTO `utilisateurs`(`nom`, `prenom`, `addresse`, `mail`, `tel`) "
                   + "VALUES (?,?,?,?,?)";
           
           ps = c.prepareStatement(r1);
           ps.setString(1, e.getNom());
           ps.setString(2, e.getPrenom());
           ps.setString(3, e.getMail());
           ps.setString(4, e.getAddresse());
           ps.setString(5, e.getTel());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
    }
    
}
