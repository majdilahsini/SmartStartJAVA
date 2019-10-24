package services;

import entities.Certificats;
import interfaces.ICertificatsService;
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
import Connection.ConnexionBD;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author firos
 */
public class CertificatsService implements ICertificatsService {
    private static CertificatsService instance;
    private Statement st;
    private ResultSet rs;
    Connection c = ConnexionBD
           .getInstanceConnexionBD()
           .getConnection();
    Statement ste;

    public CertificatsService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     *
     * @param p
     */
    @Override
    public void creerCertificats(Certificats p) {
        try {
            String req1;
            req1 = "INSERT INTO `certificats` "
                    + "(`nom_certif`, `nom_formateur`,`nom_entreprise`,`domaine`,`description`,`date_obtention`)"
                    + "VALUES ( '"+p.getNom_certif()+"', '"
                    +p.getNom_formateur()+"','"
                    +p.getNom_entreprise()+"','"
                    +p.getDomaine()+"','"
                    +p.getDescription()+"','"
                    +p.getDate_obtention()+"');";
    
          System.out.println(ste.executeUpdate(req1));
        } catch (SQLException ex) {
            Logger.getLogger(CertificatsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }
    
       

    
     @Override
    public void modifierCertificats(Certificats p) {
  try {
            String req1="UPDATE `certificats` SET `nom_certif`=?,`nom_formateur`=?,`nom_entreprise`=?,`domaine`=?,`description`=?,`date_obtention`=? WHERE `id`=?";

      PreparedStatement ps = c.prepareStatement(req1);
      ps.setString(1,p.getNom_certif());
      ps.setInt(7,p.getId());
      ps.setString(2,encrypt(p.getNom_formateur()));
      ps.setString(3,encrypt(p.getNom_entreprise()));
      ps.setString(4,encrypt(p.getDomaine()));
      ps.setString(5,encrypt(p.getDescription()));
      ps.setString(6,encrypt(p.getDate_obtention()));
   
   System.out.println(ps.executeUpdate());
           
        } catch (SQLException ex) {
            Logger.getLogger(CertificatsService.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("modification mate9letech");

        }

    
    }

    public void supprimerCertificats(Certificats p) {
        try {
            String req1="delete from certificats where"
                    + " nom_entreprise=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setString(1, p.getNom_entreprise());
            System.out.println(ps.executeUpdate());
         
           
        } catch (SQLException ex) {
            Logger.getLogger(CertificatsService.class.getName()).log(Level.SEVERE, null, ex);
        } //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates. //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Certificats> afficherCertificats() {
        List<Certificats> certifs = new ArrayList<>();
      Certificats p = null ;
      String req2="select * from certificats";
      try {
         

          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              p = new Certificats();
                      p.setId( res.getInt("id"));
                      p.setNom_certif( res.getString("nom_certif") );
                      p.setNom_formateur(res.getString("nom_formateur"));
                      p.setNom_entreprise(res.getString("nom_entreprise"));
                      p.setDomaine(res.getString("domaine"));
                      p.setDescription(res.getString("description"));
                      p.setDate_obtention(res.getString("date_obtention"));
              certifs.add(p);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return certifs;
    }

    public String encrypt(String password){
        String crypte= "";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)^2; 
            crypte=crypte+(char)c;
        }
        return crypte;
    }   
    public String decrypt(String password){
        String aCrypter="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)/2; 
            aCrypter=aCrypter+(char)c;
        }
        return aCrypter;
    }
     public ObservableList<Certificats> displayAll() {
        String req="select * from certificats";
        ObservableList<Certificats> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Certificats p=new Certificats();
                p.setNom_certif(rs.getString("nom_certif"));
                p.setNom_formateur(rs.getString("nom_formateur"));
                p.setNom_entreprise(rs.getString("nom_entreprise"));
                p.setDomaine(rs.getString("domaine"));
                p.setDescription(rs.getString("description"));
                p.setDate_obtention(rs.getString("date_obtention"));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CertificatsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
    
    
     


