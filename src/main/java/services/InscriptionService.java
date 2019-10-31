/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IInscriptionService;
import entities.Formation;
import entities.Inscription;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.DBConnection;
import Connection.Generic_Connection;
import entities.Formation_user;
import entities.Utilisateur;
import entities.inscrits_formation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author lenovo
 */
public class InscriptionService extends Generic_Connection implements IInscriptionService {
  Connection c = DBConnection.getInstance().getConnection();
            Statement ste;
            
            public InscriptionService() {
         try {
              ste = c.createStatement();
             } 
         catch (SQLException ex) {
                System.out.println(ex);
            }
}

    @Override
    public void creerInscription(int user_id,int entreprise_id,int formation_ref,String lettre_motivation) throws SQLException {
         String req="INSERT INTO `inscriptions`(`user_id`, `entreprise_id`, `formation_ref`, `lettre_motivation`)  VALUES"
                + "(?,?,?,?)";
  PreparedStatement pres = c.prepareStatement(req);
  
pres.setInt(1,user_id);
pres.setInt(2,entreprise_id);
pres.setInt(3, formation_ref);
pres.setString(4, lettre_motivation);


System.out.println(pres.executeUpdate());
      System.out.println("inscription inseré");
  
  }

   

   

    @Override
    public List<Inscription> afficherInscriptions() {
       
  List<Inscription> inscriptions = new ArrayList<>();
        String req2="select * from inscriptions";
                try {
                    ResultSet res=  ste.executeQuery(req2);
                      while (res.next()) { 
                     Inscription f = new Inscription();
                      f.setId(res.getInt("id"));
                      f.setUser_id(res.getInt("user_id") );
                      f.setFormation_ref(res.getInt("formation_ref"));
                      f.setLettre_motivation(res.getString("lettre_motivation"));
                      inscriptions.add(f);
          }

                } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
     return inscriptions;


}
    
      public ArrayList<Inscription> affichermesInscriptions(int id) {
        ArrayList<Inscription> mylist = new ArrayList();
        try {
            Statement st = c.createStatement();
            String req = "SELECT `id`, `user_id`, `entreprise_id`, `formation_ref`, `lettre_motivation` FROM `inscriptions` WHERE  user_id='" + id + "'";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Inscription i = new Inscription(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
                mylist.add(i);

            }
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
    
    public String getNom_formationByID (int ref ) {
         String Nom_formation = null ;
        String r ="SELECT Nom FROM formations WHERE ref='"+ref+"'";
                
         try {
            this.setPs(c.prepareStatement(r));
             InscriptionService.setRs(this.getPs().executeQuery());

            while (InscriptionService.getRs().next()) {
             Nom_formation = InscriptionService.getRs().getString(1);
      
             return Nom_formation; 
                
          }
             
        } catch (SQLException ex) {
            Logger.getLogger(DomaineService.class.getName()).log(Level.SEVERE, null, ex);
        }
      return null;
     
    }
    
    public String getutilisateurByID (Inscription i){
                 String Nom_utilisateur = null ;

     try {
            String r ="SELECT nom FROM utilisateurs WHERE id= ?";
              PreparedStatement   ps = c.prepareStatement(r);
              ps.setInt(1,  i.getUser_id());
              ResultSet rs = ps.executeQuery();
                while (rs.next()) 
                Nom_utilisateur = rs.getString(1);
                } catch (SQLException ex) {
            Logger.getLogger(InscriptionService.class.getName()).log(Level.SEVERE, null, ex);
            InscriptionService is = new InscriptionService();
           
        }
return Nom_utilisateur ;
        }
    
    @Override
    public int NbrApplicationformation(int id) {
        int count = 0;      
        String r = "SELECT COUNT(*) FROM `inscriptions` WHERE `formation_ref` = ?";
        PreparedStatement ps; ResultSet res;
        try {
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                count = res.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return count;
    }
    
 public List<Inscription> afficherInscriptions(int id) {
       
  List<Inscription> inscriptions = new ArrayList<>();
        String req2="select * from inscriptions where id_user="+id+";";
                try {
                    ResultSet res=  ste.executeQuery(req2);
                      while (res.next()) { 
                     Inscription f = new Inscription(res.getInt(2),res.getInt(3),res.getString(4));
                     
                      inscriptions.add(f);
          }

                } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
     return inscriptions;


}
 
 public List<Formation_user> afficherFormation(int id) {
         List<Formation_user> list = new ArrayList<>();

 
        String req2="select f.Nom,f.duree,f.date_debut,f.date_fin,d.nom_domaine FROM formations f,domaines d,inscriptions i where i.user_id="+id+" AND f.domaine_id=d.id AND i.formation_ref=f.ref";
         Formation_user fr=null;
                try {
                    ResultSet res=  ste.executeQuery(req2);
                      while (res.next()) { 
                     fr = new Formation_user(res.getString(1),res.getString(5),res.getDate(3),res.getDate(4),res.getInt(2));
                    
                      list.add(fr);
          }

                } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
    return list ;
 }
 
 
 
public List<inscrits_formation> afficher_inscrit_Formation(int id) {
         List<inscrits_formation> list = new ArrayList<>();

 
        String req2="select u.fullname,u.tel,i.lettre_motivation,f.Nom FROM formations f,users u,inscriptions i where i.entreprise_id='"+id+"' AND i.formation_ref=f.ref AND u.id=i.user_id And u.role='entreprise' ";
         inscrits_formation fr=null;
                try {
                    ResultSet res=  ste.executeQuery(req2);
                      while (res.next()) { 
                     fr = new inscrits_formation(res.getString(1),res.getInt(2),res.getString(3),res.getString(4));
                              System.out.println(fr);

                      list.add(fr);
          }

                } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
    return list ;
    
}
 
 
public void update_nombreins(int id ,int i) throws SQLException
{
    String req2="UPDATE `formations` SET `Nbres inscrits`=`Nbres inscrits`+"+i+" WHERE `ref`="+id+";";
               
                     ste.executeQuery(req2);
                      
    
    
    
}
 public int getID_formationByNom (String ch ) {
         int id = 0 ;
        String r ="SELECT ref FROM formations WHERE Nom='"+ch+"'";
                
        try {
                    ResultSet res=  ste.executeQuery(r);
                      while (res.next()) { 
                    id=res.getInt(1);
          }

                } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
     return id;
    }
 public int getIdentrepriseByRef (int id) {
     int id_entreprise = 0;
     String r ="Select entreprise_id From formations where ref='"+id+"'" ;
     
     try {
         
          ResultSet res= ste.executeQuery(r);
          while (res.next()) {
           id_entreprise=res.getInt(1);
          }
          } catch (SQLException ex) {
          System.out.println(ex.getMessage());
                }
     return id_entreprise;
    }
 }
 
 
 
   
     
      

    
    

   

