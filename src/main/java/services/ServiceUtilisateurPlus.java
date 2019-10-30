/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import Connection.Generic_Connection;
import interfaces.iServiceUtilisateurPlus;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ServiceUtilisateurPlus extends Generic_Connection implements iServiceUtilisateurPlus{
        Connection conn = DBConnection.getInstance().getConnection();
             Statement ste;
             
   public ServiceUtilisateurPlus () {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public int getUserByID(String nomh) {
        
       String r = "SELECT id FROM users WHERE fullname ='"+nomh+"'" ;
            
         try {
            this.setPs(conn.prepareStatement(r));
             ServiceUtilisateurPlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
             int id = EntretienService.getRs().getInt(1);
      
             return id; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
     return 0;
    }
      public List<String> getNomUserType()
    {
        
            String req = "select fullname from users where users.role='utilisateur'";
             List<String> LTE = new ArrayList<>();
        
     try {
            this.setPs(conn.prepareStatement(req));
             ServiceUtilisateurPlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
              String TE = EntretienService.getRs().getString(1);
                LTE.add(TE);
                
          }
            
            return LTE;
         
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
             return LTE;
    }
      
      
      
      
            public List<String> getPrenomUserType()
    {
        
            String req = "Select prenom from utilisateurs";
             List<String> LTE = new ArrayList<>();
        
     try {
            this.setPs(conn.prepareStatement(req));
             ServiceUtilisateurPlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
              String TE = EntretienService.getRs().getString(1);
                LTE.add(TE);
                
          }
            
            return LTE;
         
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
             return LTE;
    }
            
            
            
            
  public int getPUserByID(String nomh ) {
        
       String r = "SELECT id FROM utilisateurs WHERE nom ='"+nomh+"' " ;
            
         try {
            this.setPs(conn.prepareStatement(r));
             ServiceUtilisateurPlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
             int id = EntretienService.getRs().getInt(1);
      
             return id; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
     return 0;
    }
  
  
              public List<String> getPUserType(int id_user)
    {
        
            String req = "Select prenom from utilisateurs WHERE id ='"+id_user+"'  ";
             List<String> LTE = new ArrayList<>();
        
     try {
            this.setPs(conn.prepareStatement(req));
             ServiceUtilisateurPlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
              String TE = EntretienService.getRs().getString(1);
                LTE.add(TE);
                
          }
            
            return LTE;
         
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateurPlus.class.getName()).log(Level.SEVERE, null, ex);
        }
             return LTE;
    }
    
}
