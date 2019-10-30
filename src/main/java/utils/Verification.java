/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceOffre;

/**
 *
 * @author Sadbo
 */
public class Verification {
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public Verification () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    
    public int siUsernameExiste(String s) {
        
        String r = "SELECT COUNT(*) FROM `users` WHERE `username`= ?";
        int a = -1;
        
        try {
            ps = c.prepareStatement(r);
            ps.setString(1, s);
            res = ps.executeQuery();
            
            if (res.next()) {
                
                //System.out.println(res.getInt(1));
                
                a = res.getInt(1);
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;

}
     public int siEmailExiste(String s) {
        
        String r = "SELECT COUNT(*) FROM `users` WHERE `email`= ?";
        int a = -1;
        
        try {
            ps = c.prepareStatement(r);
            ps.setString(1, s);
            res = ps.executeQuery();
            
            if (res.next()) {
                
                //System.out.println(res.getInt(1));
                
                a = res.getInt(1);
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Verification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;

}
     public boolean isValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
    
}
