/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Connection.DBConnection;
import entities.Offre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.ServiceOffre;

/**
 *
 * @author Sadbo
 */
public class Getlists {
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
     public Getlists () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     
    public List<String> getPostes () {
        List<String> l = new ArrayList<String>();
        
        String r = "SELECT `name` FROM `type_post`";
        
        try {
            ps = c.prepareStatement(r);
            res = ps.executeQuery();
            
            while (res.next()) 
                 l.add(res.getString(1));

        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
         return l;
    }
    
    
       public int getTypeDePosteByID(String nom) {
       
        int i = -1;
        
        try {
            
            String r = "SELECT `id` FROM `type_post` WHERE name = ?";
            
            ps = c.prepareStatement(r);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                i = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }
    
    public List<String> getLangues () {
       
        List<String> l = new ArrayList<String>();
        
        String r = "SELECT `nom` FROM `langues`";
        
        try {
            ps = c.prepareStatement(r);
            res = ps.executeQuery();
            
            while (res.next()) 
                 l.add(res.getString(1));

        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
         return l;
    }
    
    
}
