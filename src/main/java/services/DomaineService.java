/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import Connection.Generic_Connection;
import entities.Domaine;
import entities.Formation;
import interfaces.IDomaineService;
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
 * @author lenovo
 */
public class DomaineService extends Generic_Connection implements IDomaineService{
    Connection conn = DBConnection.getInstance().getConnection();
             Statement ste;
   
    
    @Override
     public  int getDomaineByID(String nom) {
        
       String r = "SELECT id FROM domaines WHERE nom_domaine ='"+nom+"'" ;
            
         try {
            this.setPs(conn.prepareStatement(r));
             DomaineService.setRs(this.getPs().executeQuery());

            while (FormationService.getRs().next()) {
             int id = FormationService.getRs().getInt(1);
      
             return id; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(DomaineService.class.getName()).log(Level.SEVERE, null, ex);
        }
     return 0;
    }
    @Override
      public List<String> getFormationType()
    {
        
            String req = "Select nom_domaine from domaines";
             List<String> LTE = new ArrayList<>();
        
     try {
            this.setPs(conn.prepareStatement(req));
             DomaineService.setRs(this.getPs().executeQuery());

            while (FormationService.getRs().next()) {
              String TE = FormationService.getRs().getString(1);
                LTE.add(TE);
                
          }
            
            return LTE;
         
        } catch (SQLException ex) {
            Logger.getLogger(DomaineService.class.getName()).log(Level.SEVERE, null, ex);
        }
             return LTE;
    }
       public  ArrayList<Domaine> afficherDomaine() {
        ArrayList<Domaine> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "select * from domaines";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Domaine d = new Domaine(rs.getInt(1),rs.getString(2));
                mylist.add(d);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
        public void creerDomaine (Domaine d) throws SQLException {  
  String req="INSERT INTO `domaines`(`nom_domaine`) VALUES"
                + "(?)";
  PreparedStatement pres = conn.prepareStatement(req);
pres.setString(1, d.getNom_domaine());


System.out.println(pres.executeUpdate());
      System.out.println("domaine  inseré");
  
  }
          @Override
    public List<Domaine> affichercategories() {
            List<Domaine> categories = new ArrayList<>();
      Domaine c = null ;
      String req2="select * from Domaine";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              c = new Domaine();
                      c.setId( res.getInt("id"));
                      c.setNom_domaine(
                              res.getString("nom_domaine"));
              categories.add(c);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return categories;
    }
}
