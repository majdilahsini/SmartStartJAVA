/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Application;
import interfaces.iApplication;
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
public class ServiceApplication implements iApplication{
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
        public ServiceApplication () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public int ajouterApplication(Application a) {
      
        int executeTest = 0; 
       
       try {
          
           String r = "INSERT INTO `applications`(`offre_id`, `user_id`, `lettre_motivation`) "
                    + "VALUES (?, ?, ?)";
           
           ps = c.prepareStatement(r);
           ps.setInt(1, a.getOffre_id());
           ps.setInt(2, a.getUser_id());
           ps.setString(3, a.getLettre_motivation());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
        
    }

    @Override
    public void supprimerApplication(int id) {
        
        try {
            
            String r = "DELETE FROM `applications` WHERE `id` = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Application> AfficherApplication() {
        List<Application> applications = new ArrayList<>();
        Application a = null;
        
        String r = "SELECT * FROM `applications`";
        
        try {
            
            res = st.executeQuery(r);
            while(res.next()) {
                a = new Application();
                    a.setId(res.getInt("id"));
                    a.setOffre_id(res.getInt("offre_id"));
                    a.setUser_id(res.getInt("user_id"));
                    a.setLettre_motivation(res.getString("lettre_motivation"));
                applications.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return applications;
    }

    @Override
    public List<Application> AfficherApplicationById_O(int id) {
               List<Application> applications = new ArrayList<>();
        Application a = null;
        
        String r = "SELECT * FROM `applications` where offre_id = ?";
        
        try {
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                a = new Application();
                    a.setId(res.getInt("id"));
                    a.setOffre_id(res.getInt("offre_id"));
                    a.setUser_id(res.getInt("user_id"));
                    a.setLettre_motivation(res.getString("lettre_motivation"));
                applications.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return applications;
    }

    @Override
    public List<Application> AfficherApplicationById_u(int id) {
               List<Application> applications = new ArrayList<>();
        Application a = null;
        
        String r = "SELECT * FROM `applications` WHERE `user_id` = ?";
        
        try {
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                a = new Application();
                    a.setId(res.getInt("id"));
                    a.setOffre_id(res.getInt("offre_id"));
                    a.setUser_id(res.getInt("user_id"));
                    a.setLettre_motivation(res.getString("lettre_motivation"));
                applications.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return applications;
    }

    @Override
    public String getOffreByID(Application a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUtilisateurByID(Application a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
