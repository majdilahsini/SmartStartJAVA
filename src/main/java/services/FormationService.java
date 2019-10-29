/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import Connection.Generic_Connection;
import entities.Formation;
import interfaces.IFormationService;
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

/**
 *
 * @author lenovo
 */
public class FormationService extends Generic_Connection implements IFormationService {
 Connection conn = DBConnection.getInstance().getConnection();
             Statement ste;

             public FormationService (){
                  try {
              ste = conn.createStatement();
             } 
         catch (SQLException ex) {
                System.out.println(ex);
            }
             }
              @Override
   public void creerFormation (Formation f) throws SQLException {  
  String req="INSERT INTO `formations`(`domaine_id`,`Nom`,`description`,`duree`, `date_debut`, `date_fin`, `prix`,`adresse`,`email` ,`contact`) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?)";
  PreparedStatement pres = conn.prepareStatement(req);
pres.setInt(1, f.getDomaine_id());
pres.setString(2, f.getNom());
pres.setString(3, f.getDescription());
pres.setInt(4,f.getDuree());
pres.setDate(5, f.getDate_debut());
pres.setDate(6,f.getDate_fin());
pres.setDouble(7, f.getPrix());
pres.setString(8, f.getAdresse());
pres.setString(9, f.getEmail());
pres.setInt(10, f.getContact());

System.out.println(pres.executeUpdate());
      System.out.println("formation inseré");
  
  }
 @Override
   public ArrayList<Formation> afficherFormation() {
        ArrayList<Formation> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "select * from formations";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Formation c = new Formation(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getDate(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                mylist.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
   
 @Override
    public void supprimerFormation(Formation f) {
        try {
            PreparedStatement pt = conn.prepareStatement("delete from formations where ref=?");
            pt.setInt(1, f.getRef());
            pt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
  /*  public void modifierFormation(int ref ,int domaine_id , String nom , String prérequis , String description , int duree , Date date_debut , Date date_fin ,Double prix ,String adresse , String email, int contact){
  
 
     try {
         PreparedStatement pres;
         String req="UPDATE formations SET"
          + "`domaine_id`=?"
          + ",`Nom`=?"
        
          + ",`Prérequis`=?"
          + ",`description`=?"
          + ",`duree`=?"
          + ",`date_debut`=?"
          + ",`date_fin`=?"
       
          + ",`prix`=?"
         
       
          + ",`adresse`=?"
          + ",`email`=?"
          + ",`contact`=?"
          + " WHERE ref= ? ";
         pres = conn.prepareStatement(req);
         
pres.setInt(1,domaine_id);
pres.setString(2, nom);
pres.setString(3,prérequis);
pres.setString(4, description);
pres.setInt(5,duree);
pres.setDate(6,date_debut);
pres.setDate(7,date_fin);
pres.setDouble(8,prix);
pres.setString(9,adresse);
pres.setString(10,email);
pres.setInt(11,contact);
 pres.setInt(12,ref);
System.out.println(pres.executeUpdate());
      System.out.println("element modifié");
     }
      catch (SQLException ex) {
         Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
     }
  
   
}*/
     @Override
    public void modifierFormation(int domaine_id,String Nom,String description,int duree,Date date_debut,Date date_fin,Double prix,String adresse,String email,int contact,int ref)throws SQLException {
  String req="UPDATE formations SET "
          + "`domaine_id`=?"
          + ",`Nom`=?"
         
          + ",`description`=?"
          + ",`duree`=?"
          + ",`date_debut`=?"
          + ",`date_fin`=?"
        
          + ",`prix`=?"
          + ",`adresse`=?"
          + ",`email`=?"
          + ",`contact`=?"
          + " WHERE ref= ? ";
 PreparedStatement pres = conn.prepareStatement(req);
pres.setInt(1,domaine_id);
pres.setString(2, Nom);



pres.setString(3,description);
pres.setInt(4,duree);
pres.setDate(5,date_debut);
pres.setDate(6,date_fin);

pres.setDouble(7,prix);

pres.setString(8,adresse);
pres.setString(9,email);
pres.setInt(10,contact);
 pres.setInt(11, ref);


  
System.out.println(pres.executeUpdate());
      System.out.println("element modifié");
  
  }
   
      public Formation Get_Mission_by_Id(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String resq = "select * from formations where ref ='" + id + "'";
        pstmt = conn.prepareStatement(resq);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            return new Formation(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getDate(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getInt(11));

        }
        return new Formation();
    }

   
     public ArrayList<Formation> afficherImage(int id) {
        ArrayList<Formation> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "select image from formations where ref='"+id+"'";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Formation c = new Formation(rs.getString(1));
                mylist.add(c);
                System.out.println("ok");

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
     public void deleteEnt(int ref) {
         try {
       
    String req1 ="DELETE FROM formations WHERE ref= ?";
       
      PreparedStatement ps = conn.prepareStatement(req1);
            ps.setInt(1, ref);

            ps.executeUpdate();
                  System.out.println("entretien supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Override
    public List<Formation> filtrer(String catnom) {
     
         List<Formation> formations = new ArrayList<>();
         Formation p = null ;
         
         String req="SELECT f.Nom,f.duree,f.date_debut,f.date_fin FROM formations f JOIN domaines d  on f.domaine_id = d.id where d.id = (SELECT id as `IdDomaine` from domaine where nom_domaine=?)";
         
         
         
      try {   
         PreparedStatement pstm;
         
         pstm = conn.prepareStatement(req);
         pstm.setString(1,catnom);
         ResultSet res = pstm.executeQuery();
         while (res.next()) {
             
             p = new Formation();
             p.setRef(res.getInt("Ref"));
          p.setNom(res.getString("Nom") );
             p.setDomaine_id(res.getInt("domaine_id"));
             p.setDescription(res.getString("description") );
             p.setDuree(res.getInt("duree"));
             p.setDate_debut(res.getDate("date_debut"));
             p.setDate_fin(res.getDate("date_fin"));
           p.setPrix(res.getInt("prix"));
            p.setAdresse(res.getString("adresse"));
             p.setEmail(res.getString("email"));
           p.setContact(res.getInt("contact"));
             
             
             
             
             formations.add(p);
             
             
         }
         
      
     } catch (SQLException ex) {
         Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
     }
     return formations ;
    }
    public ArrayList<Formation> afficherFormation_Combo(String ch) {
        DomaineService s=new DomaineService();
        int id=s.getDomaineByID(ch);
        ArrayList<Formation> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "select * from formations where domaine_id='"+id+"'";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Formation c = new Formation(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getDate(7),rs.getDouble(8),rs.getString(9),rs.getString(10),rs.getInt(11));
                mylist.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
    
    
    
}