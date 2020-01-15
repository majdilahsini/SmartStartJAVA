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
import javafx.scene.chart.XYChart;

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
     
  String req="INSERT INTO `formations`(`entreprise_id`,`domaine_id`,`Nom`,`description`,`duree`, `date_debut`, `date_fin`,`adresse`,`prix`,`contact`,`email`,`image`,`Nombres`,`etat_formation`,`etat_nombres`,`datecreationformation`,`NombresTotale`) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  PreparedStatement pres = conn.prepareStatement(req);
 pres.setInt(1,f.getEntreprise_id()); 
pres.setInt(2, f.getDomaine_id());
pres.setString(3, f.getNom());
pres.setString(4, f.getDescription());
pres.setInt(5,f.getDuree());
pres.setDate(6, f.getDate_debut());
pres.setDate(7,f.getDate_fin());

pres.setString(8, f.getAdresse());
pres.setDouble(9, f.getPrix());
pres.setInt(10, f.getContact());
pres.setString(11, f.getEmail());
pres.setString(12, f.getImage());
pres.setInt(13, f.getNbres_inscrits());
pres.setInt(14, f.getEtat_formation());
pres.setInt(15, f.getEtat_nombres());
pres.setDate(16, f.getDatecreation());
pres.setInt(17, f.getNbres_totales());





System.out.println(pres.executeUpdate());
      System.out.println("formation inseré");
  
  }
 /*@Override
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
    }*/
   
      @Override

   public ArrayList<Formation> afficherFormation() {
        ArrayList<Formation> mylist = new ArrayList();
        FormationService f = new FormationService();
        DomaineService s=new DomaineService();
        try {
            Statement st = conn.createStatement();
            String req = "SELECT `ref`, `entreprise_id`, `domaine_id`, `Nom`, `description`, `duree`, `date_debut`, `date_fin`, `adresse`, `prix`, `contact`, `email` FROM `formations`  ";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Formation c = new Formation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getDate(8),rs.getString(9),rs.getDouble(10),rs.getInt(11),rs.getString(12));
          c.setNomentreprise(f.getentrepriseByID(rs.getInt(2)));
     c.setNomdomaine(s.getDomaineByID(rs.getInt(3)));
         
                mylist.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mylist;
    }
      @Override

   public ArrayList<Formation> affichermesFormation(int id) {
        ArrayList<Formation> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "SELECT `ref`, `entreprise_id`, `domaine_id`, `Nom`, `description`, `duree`, `date_debut`, `date_fin`,`adresse`, `prix`,`contact`, `email`,`Nombres` FROM `formations` where entreprise_id='" + id + "'";
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
         Formation c = new Formation(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getDate(8),rs.getString(9),rs.getDouble(10),rs.getInt(11),rs.getString(12),rs.getInt(13));
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
     
 
     @Override
    public void modifierFormation(String Nom,String description,int duree,Date date_debut,Date date_fin,Double prix,String adresse,String email,int contact,int ref)throws SQLException {
  String req="UPDATE formations SET "
         
          + "`Nom`=?"
         
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

pres.setString(1, Nom);



pres.setString(2,description);
pres.setInt(3,duree);
pres.setDate(4,date_debut);
pres.setDate(5,date_fin);

pres.setDouble(6,prix);

pres.setString(7,adresse);
pres.setString(8,email);
pres.setInt(9,contact);
 pres.setInt(10, ref);


  
System.out.println(pres.executeUpdate());
      System.out.println("element modifié");
  
  }
   
      public Formation Get_Mission_by_Id(int id) throws SQLException {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String resq = "SELECT `Nom`, `description`, `duree`, `date_debut`, `date_fin`, `prix`, `adresse`, `email`, `contact` FROM `formations` where ref ='" + id + "'";
        pstmt = conn.prepareStatement(resq);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            return new Formation(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getDate(5),rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getInt(9));

        }
        return new Formation();
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
  
         
   
    public ArrayList<Formation> afficherFormation_Combo(String ch) {
        DomaineService s=new DomaineService();
        int id=s.getDomaineByID(ch);
        ArrayList<Formation> mylist = new ArrayList();
        try {
            Statement st = conn.createStatement();
            String req = "SELECT `entreprise_id`, `domaine_id`, `Nom`, `description`, `duree`, `date_debut`, `date_fin`, `prix`, `adresse`, `email`, `contact` FROM `formations` WHERE  domaine_id='"+id+"'";
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
    
      public String getentrepriseByID (int i){
                 String Nom_entreprise = null ;

     try {
            String r ="SELECT fullname FROM userj WHERE id=?";
              PreparedStatement   ps = conn.prepareStatement(r);
              ps.setInt(1,  i);
              ResultSet rs = ps.executeQuery();
                while (rs.next()) 
                Nom_entreprise = rs.getString(1);
                } catch (SQLException ex) {
            Logger.getLogger(FormationService.class.getName()).log(Level.SEVERE, null, ex);
                      
        }
return Nom_entreprise ;
        }
         public     XYChart.Series<String, Integer>  statformations(int id) throws SQLException {
       
        String req =" SELECT `Nom`,`Nombres`,`NombresTotale` from `formations` where `entreprise_id`="+id+" ";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        
             PreparedStatement ste = (PreparedStatement) conn.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                
                
                series.getData().add(new XYChart.Data<>(rs.getString("Nom"), rs.getInt("NombresTotale")-rs.getInt("Nombres")));
            }
            //barChart.getData().add(series);
        
        return series;
       
   }
    
}