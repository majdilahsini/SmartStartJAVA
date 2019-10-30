/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Connection.DBConnection;
import entities.Offre;
import interfaces.iOffre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p
 */
public class ServiceOffre implements iOffre{
    
    Connection c = DBConnection.getInstance().getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet res = null;
    
    public ServiceOffre () {
        try {
            st = c.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public int ajouterOffre(Offre e) {
     
       int executeTest = 0; 
       
       try {
          
           String r1 = "INSERT INTO `offres` "
                    + "(`titre`,`domaine_id`,`entreprise_id`,`date_publication`,`niveau_etude`,`langue_ref`,`type_post_id`,`skill1_id`, `skill2_id`, `skill3_id`, `salaire`, `photo`)"
                    + " VALUES (?,?,?,SYSDATE(),?,?,?,?,?,?,?,?)";
           
           ps = c.prepareStatement(r1);
           ps.setString(1, e.getTitre());
           ps.setInt(2, e.getDomaine_id());
           ps.setInt(3, e.getEntreprise_id());
           ps.setInt(4, e.getNiveau_etude());
           ps.setInt(5, e.getLangue_ref());
           ps.setInt(6, e.getType_post_id());
           ps.setInt(7, e.getSkill1_id());
           ps.setInt(8, e.getSkill2_id());
           ps.setInt(9, e.getSkill3_id());
           ps.setInt(10, e.getSalaire());
           ps.setString(11, e.getPhoto());
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
    }
    

    @Override
    public int modifierOffre(Offre e) {
      
       int executeTest = 0; 
       
       try {
          
           String r = "UPDATE `offres` SET "
                   + "`titre`=?,"
                   + "`domaine_id`=?,"
                   + "`entreprise_id`=?,"
                   + "`date_publication`=STR_TO_DATE(?,'%d,%m,%Y'),"
                   + "`niveau_etude`=?,"
                   + "`langue_ref`=?,"
                   + "`type_post_id`=?,"
                   + "`description`=?"
                   + " WHERE id = ?";
           
           ps = c.prepareStatement(r);
           ps.setString(1, e.getTitre());
           ps.setInt(2, e.getDomaine_id());
           ps.setInt(3, e.getEntreprise_id());
          // ps.setString(4, e.getDate_publication());
           ps.setInt(5, e.getNiveau_etude());
           ps.setInt(6, e.getLangue_ref());
           ps.setInt(7, e.getType_post_id());
           //ps.setString(8, e.getDescription());
           ps.setInt(9, e.getId());
           
           executeTest = ps. executeUpdate();
           
    } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
       return executeTest;
    }
    

    @Override
    public void supprimerOffre(int id) {
        
       
        try {
            
            String r = "DELETE FROM `offres` WHERE `id` = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    @Override
    public List<Offre> AfficherOffres() {
        List<Offre> offres = new ArrayList<>();
        Offre o = null;
        
        String r = "SELECT * FROM `offres`";
        
        try {
            
            res = st.executeQuery(r);
            while(res.next()) {
                o = new Offre();
                    o.setId(res.getInt("id"));
                    o.setTitre(res.getString("titre"));
                    o.setDomaine_id(res.getInt("domaine_id"));
                    o.setEntreprise_id(res.getInt("entreprise_id"));
                    o.setDate_publication(res.getString("date_publication"));
                    o.setNiveau_etude(res.getInt("niveau_etude"));
                    o.setLangue_ref(res.getInt("langue_ref"));
                    o.setType_post_id(res.getInt("type_post_id"));
                    //o.setDescription(res.getString("description"));
                offres.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return offres;
    }
    
       public List<Offre> AfficherOffres2(int id) {
        List<Offre> offres = new ArrayList<>();
        Offre o = null;
        
        String r = "SELECT o.`id` 'id',`titre`,`domaine_id`,`entreprise_id`,DATE_FORMAT(`date_publication`,'%d/%m/%Y'),`langue_ref`,`type_post_id`,o.`skill1_id`,o.`skill2_id`,o.`skill3_id`,`salaire`, `photo` FROM offres o " +
                    "where o.`id` NOT IN (SELECT offre_id FROM applications WHERE user_id = ?);";
        
        try {
            
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                o = new Offre();
                    o.setId(res.getInt("id"));
                    o.setTitre(res.getString("titre"));
                    o.setDomaine_id(res.getInt("domaine_id"));
                    o.setEntreprise_id(res.getInt("entreprise_id"));
                    o.setDate_publication(res.getString("DATE_FORMAT(`date_publication`,'%d/%m/%Y')"));
                    o.setLangue_ref(res.getInt("langue_ref"));
                    o.setType_post_id(res.getInt("type_post_id"));
                    o.setSkill1_id(res.getInt("skill1_id"));
                    o.setSkill2_id(res.getInt("skill2_id"));
                    o.setSkill3_id(res.getInt("skill3_id"));
                    o.setSalaire(res.getInt("salaire"));
                    o.setPhoto(res.getString("photo"));
                    //o.setDescription(res.getString("description"));
                offres.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return offres;
    }
       
              public List<Offre> AfficherOffresByID(int id) {
        List<Offre> offres = new ArrayList<>();
        Offre o = null;
        
        String r = "SELECT `id`,`titre`,`domaine_id`,`entreprise_id`,DATE_FORMAT(`date_publication`, '%d/%m/%Y'),`langue_ref`,`type_post_id`,`skill1_id`,`skill2_id`,`skill3_id`,`salaire`,`photo`  FROM offres"
                + " WHERE id = ?";
        
        try {
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {                                  
                o = new Offre();
                    o.setId(rs.getInt("id"));
                    o.setTitre(rs.getString("titre"));
                    o.setDomaine_id(rs.getInt("domaine_id"));
                    o.setEntreprise_id(rs.getInt("entreprise_id"));
                    o.setDate_publication(rs.getString("DATE_FORMAT(`date_publication`, '%d/%m/%Y')"));
                    o.setLangue_ref(rs.getInt("langue_ref"));
                    o.setType_post_id(rs.getInt("type_post_id"));
                    o.setSkill1_id(rs.getInt("skill1_id"));
                    o.setSkill2_id(rs.getInt("skill2_id"));
                    o.setSkill3_id(rs.getInt("skill3_id"));
                    o.setSalaire(rs.getInt("salaire"));
                    o.setPhoto(rs.getString("photo"));
                    //o.setDescription(res.getString("description"));
                offres.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return offres;
    }
    
        @Override
        public List<Offre> AfficherOffresByEntreprise(int id) {
        List<Offre> offres = new ArrayList<>();
        Offre o = null;
        
        String r = "SELECT `titre`,`id`,DATE_FORMAT(`date_publication`, '%d/%m/%Y'), `photo` FROM offres WHERE `entreprise_id` = ?";

        
        try {
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            res = ps.executeQuery();
            while(res.next()) {
                o = new Offre();
                    o.setId(res.getInt(2));
                    o.setTitre(res.getString(1));
                    o.setDate_publication(res.getString(3));
                    o.setPhoto(res.getString(4));
                    //o.setDate_publication(res.getString("date_publication"));
                offres.add(o);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return offres;
    }

    @Override
    public String getDomaineByID(Offre e) {
        
        String Domaine = "";
        
        try {
            
            String r = "SELECT `nom` FROM `domaines` WHERE id = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, e.getDomaine_id());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                Domaine = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Domaine;
    }

    @Override
    public String getEntrepriseByID(Offre e) {
        
                String Entreprise = null;
        
        try {
            
            String r = "SELECT `fullname` FROM `users` WHERE id = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, e.getEntreprise_id());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                Entreprise = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Entreprise;
        
    }
    
        public String getEntrepriseByID(int id) {
        
                String Entreprise = null;
        
        try {
            
            String r = "SELECT `fullname` FROM `users` WHERE id = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                Entreprise = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Entreprise;
        
    }

    @Override
    public String getLangueByRef(int id) {
       
        String Langue = "";
        
        try {
            
            String r = "SELECT `nom` FROM `langues` WHERE ref = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                Langue = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Langue;
        
    }

    @Override
    public String getTypeDePosteByID(Offre e) {
       
        String TypeDePoste = "";
        
        try {
            
            String r = "SELECT `name` FROM `type_post` WHERE id = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, e.getType_post_id());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                TypeDePoste = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return TypeDePoste;
    }
    
    
    public String getSkillByID(int id) {
       
        String TypeDePoste = "";
       
        
        try {
            
            String r = "SELECT `name` FROM `skills` WHERE id = ?";
            
            ps = c.prepareStatement(r);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
                TypeDePoste = rs.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceOffre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (TypeDePoste.length()>0)
            return TypeDePoste+", ";
        else
            return TypeDePoste;
    }


}      
