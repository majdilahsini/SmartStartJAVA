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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
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
    
           public int getLanguebyRef(String nom) {
       
        int i = -1;
        
        try {
            
            String r = "SELECT `ref` FROM `langues` WHERE nom = ?";
            
            ps = c.prepareStatement(r);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                i = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
        
    }
           
           
        public List<String> getSkills () {
       
        List<String> l = new ArrayList<String>();
        
        String r = "SELECT `name` FROM `skills`";
        
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
         
         public int getSkillbynom(String nom) {
       
        int i = -1;
        
        try {
            
            String r = "SELECT `id` FROM `skills` WHERE name = UPPER(?)";
            
            ps = c.prepareStatement(r);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                i = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
         
         
         
    }   
         
         public List<String> getDomaines () {
       
        List<String> l = new ArrayList<String>();
        
        String r = "SELECT `nom` FROM `domaines1`";
        
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
    
         
        public int getDomainebynom(String nom) {
       
        int i = -1;
        
        try {
            
            String r = "SELECT `id` FROM `domaines1` WHERE nom = ?";
            
            ps = c.prepareStatement(r);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                i = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
         
 }   
        
        public int getNoteSkills (int id1, int id2) {
       
        int note = 0;
        int[] a = {0,0,0};
        int[] a2 = {0,0,0};
        
        
        String r = "SELECT `skill1_id`, `skill2_id`, `skill3_id` FROM user_skills WHERE `user_id` = ?";
        String r2 = "SELECT `skill1_id`, `skill2_id`, `skill3_id` FROM offres WHERE id = ?";
        
        try {
            ps = c.prepareStatement(r);
            ps.setInt(1, id1);
            res = ps.executeQuery();
            
            while (res.next()) {
                
                for (int i=0; i<3; i++) {
                    a[i] = res.getInt(i+1);
                    System.out.println(res.getInt(i+1));
                }
                    
                    

            }
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ps = c.prepareStatement(r2);
            ps.setInt(1, id2);
            res = ps.executeQuery();
            
            while (res.next()) {
                for (int i=0; i<3; i++)
                    a2[i] = res.getInt(i+1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        for (int k: a) {
            //System.out.println(k);
            for (int j: a2) {
                //System.out.println(j);
                if (j == k && j != -1) {
                    note++;
                  }
                    
            }
        }
        
        return (int) note;
        
        
        }
        
        public Set<String> getSkillsOffre (int id) {
       
        Set<String> l = new HashSet<String>();
        
        String r = "SELECT `skill1_id`, `skill2_id`, `skill3_id` FROM offres WHERE id = ?";
        
        try {
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            
            while (res.next()) {
                l.add(res.getString(1));
                l.add(res.getString(2));
                l.add(res.getString(3));
            }
                 

        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
         return l;
        
        }
        
                
        
        
        public int getNoteLangues (int id1, int id2) {
       
        int note = 0;
        int[] a = {0,0};
        int a2 = 0;
        
        
        String r = "SELECT `langue1_ref`, `langue2_ref` FROM user_langues WHERE `user_id` = ?";
        String r2 = "SELECT `langue_ref` FROM offres WHERE id = ?";
        
        try {
            ps = c.prepareStatement(r);
            ps.setInt(1, id1);
            res = ps.executeQuery();
            
            while (res.next()) {
                for (int i=0; i<2; i++)
                    a[i] = res.getInt(i+1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ps = c.prepareStatement(r2);
            ps.setInt(1, id2);
            res = ps.executeQuery();
            
            while (res.next()) {
                
                    a2 = res.getInt(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        for (int k: a) {
            //System.out.println(k);
                   //System.out.println(j);
                if (k == a2)
                    note++;
            }
        
        
        return (int) Math.ceil(note);
        
        
        }
        
        public int sicandidater(int offre, int id){
            
            int si = 0;
            String r = "SELECT COUNT(*) FROM `applications` WHERE `user_id` = ? AND `offre_id` = ?";
            
            
        try {
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ps.setInt(2, offre);
            res = ps.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (res.next())
            si = res.getInt(1);
        } catch (SQLException ex) {
           Logger.getLogger(Getlists.class.getName()).log(Level.SEVERE, null, ex);
        }
          return si;  
        }
        
    
    
}
