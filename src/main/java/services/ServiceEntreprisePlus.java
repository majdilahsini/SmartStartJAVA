/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import Connection.Generic_Connection;
import interfaces.iServiceEntreprisePlus;
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
public class ServiceEntreprisePlus extends Generic_Connection implements iServiceEntreprisePlus{
     Connection conn = DBConnection.getInstance().getConnection();
             Statement ste;
             
   public ServiceEntreprisePlus () {
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprisePlus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public int getEntByID(String nomh) {
        
       String r = "SELECT id FROM users WHERE fullname ='"+nomh+"'" ;
            
         try {
            this.setPs(conn.prepareStatement(r));
             ServiceEntreprisePlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
             int id = EntretienService.getRs().getInt(1);
      
             return id; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprisePlus.class.getName()).log(Level.SEVERE, null, ex);
        }
     return 0;
    }
              public String getNomEntByID(int idE) {
                    String xx = "sdf";

       String r = "SELECT fullname FROM users WHERE users.id ='"+idE+"'" ;
         try {
            this.setPs(conn.prepareStatement(r));
             ServiceEntreprisePlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
             String n = EntretienService.getRs().getString(1);
      
             return n; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprisePlus.class.getName()).log(Level.SEVERE, null, ex);
        }
     return xx;
    }
      
          public List<String> getNomEntType()
    {
        
            String req = "Select nom from entreprises";
             List<String> LTE = new ArrayList<>();
        
     try {
            this.setPs(conn.prepareStatement(req));
             ServiceEntreprisePlus.setRs(this.getPs().executeQuery());

            while (EntretienService.getRs().next()) {
              String TE = EntretienService.getRs().getString(1);
                LTE.add(TE);
                
          }
            
            return LTE;
         
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEntreprisePlus.class.getName()).log(Level.SEVERE, null, ex);
        }
             return LTE;
    }
    
}
