/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Userskill;
import interfaces.iUserskills;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p
 */
public class ServiceUserskill implements iUserskills{
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public ServiceUserskill () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUserskill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @Override
    public int ajouterUserskill(Userskill u) {
        
       int executeTest = 0; 
       
       try {
          
           String r1 = "INSERT INTO `user_skills`(`user_id`, `skill_id`) "
                     + "VALUES (?,?)";
           
           ps = c.prepareStatement(r1);
           ps.setInt(1, u.getUser_id());
           ps.setInt(2, u.getSkill_id());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceUserskill.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
    }

    @Override
    public int modifierUserskill(Userskill e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerOffre(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Userskill> AfficherUserskills() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
