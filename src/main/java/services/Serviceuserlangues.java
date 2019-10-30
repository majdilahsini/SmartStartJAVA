/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Userlangues;
import entities.Userskill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p
 */
public class Serviceuserlangues {
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public Serviceuserlangues () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUserskill.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int ajouterUserslangue(Userlangues u) {
        
       int executeTest = 0; 
       
       try {
          
           String r1 = "INSERT INTO `user_langues`(`user_id`, `langue1_ref`, `langue2_ref`) "
                     + "VALUES (?,?,?)";
           
           ps = c.prepareStatement(r1);
           ps.setInt(1, u.getUser_id());
           ps.setInt(2, u.getLangue1_id());
           ps.setInt(3, u.getLangue2_id());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceUserskill.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
    }
    
}
