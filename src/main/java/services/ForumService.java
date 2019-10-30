/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import Connection.DBConnection;
import entities.Forum;
import entities.login;
import entities.users;
import interfaces.IForumService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radhwen
 */
public class ForumService implements IForumService {
      Connection c= DBConnection.getInstance().getConnection();
      Statement ste;

    public ForumService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
  
    
}

    @Override
    public void AjouterCommentaire(Forum f) {
        try {
           // String req1="INSERT INTO `forum`( `commentaire`)  VALUES (?)";

            String req1="INSERT INTO `forum`(`nom`, `commentaire`)  VALUES (?,?)";
            int i=1;
             PreparedStatement ps = c.prepareStatement(req1);
             ps.setString(i++, f.getNom());
             ps.setString(i++, f.getCommentaire());
            // ps.setInt(i++, f.getId_commentaire());
            // ps.setInt(i++, f.getId_user());
            
            
             ps.executeUpdate();
         
            
        } catch (SQLException ex) {
            Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    }

    @Override
    public void SupprimerCommentaire(Forum f) {
         try {
            String req1="DELETE FROM `forum` WHERE "+"commentaire=?";
            //  int i=1;
      PreparedStatement ps = c.prepareStatement(req1);
          //  ps.setString(i++, f.getNom());
         //   ps.setString(1, f.getNom());
            ps.setString(1, f.getCommentaire());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ModifierCommentaire(Forum f) {
       
         try {
           // String req1="INSERT INTO `forum`( `commentaire`)  VALUES (?)";

            String req1="update forum set  commentaire =? where id_commentaire="+f.getId_commentaire();
            int i=1;
             PreparedStatement ps = c.prepareStatement(req1);
            // ps.setString(i++, f.getNom());
             ps.setString(i++, f.getCommentaire());
            // ps.setInt(i++, f.getId_commentaire());
            // ps.setInt(i++, f.getId_user());
            
            
             ps.executeUpdate();
         
            
        } catch (SQLException ex) {
            Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        
    }
/*
    @Override
    public int FindIdCommentaire(String f) {
          int i = 0 ;
          
           try {
                // String req1="SELECT `id_commentaire` FROM `forum` WHERE `commentaire`="+f;
             PreparedStatement pt = c.prepareStatement("SELECT `id_commentaire` FROM `forum` WHERE `commentaire`="+f);
             pt.setInt(1, f.getId_commentaire());
             ResultSet rs=pt.executeQuery();
                 
             return i;
           }
           catch{
              
               
                 return i;
           }
         
          */
    
 



    
    public int FindIdCommentaire(String comm) {
       int t = 0;
         try {
             PreparedStatement pt = c.prepareStatement("select id_commentaire from forum where commentaire=?");
             pt.setString(1, comm);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getInt("id_commentaire");
              }
         } catch (SQLException ex) {
             Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;    
    }

    @Override
    public String FindEmailId(int id) {
        String mail=null ;
                   try {
             PreparedStatement pt = c.prepareStatement("select email from users where id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      mail=rs.getString("email");
              }
         } catch (SQLException ex) {
             Logger.getLogger(ForumService.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        return mail;
    }
}