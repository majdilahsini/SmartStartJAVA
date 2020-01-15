/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnexionBD;
import entities.users;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author firos
 */
public class usersService {
    Connection c= ConnexionBD.getInstanceConnexionBD().getConnection();
    
    public String ajouterUtilisateur(users p){
        String m="non valide";
       try {
             PreparedStatement pt = c.prepareStatement("select * from users where username =? ");
            pt.setString(1, p.getUsername());
            
            ResultSet rs=pt.executeQuery();
  if(rs.next())
  { 
      System.out.println( "utilisateur existe ");
   
  
  }
  else
  {//qui va assurer la connexion entre sql et java 
         
       //String req="insert into users(username,password,email,fullname,tel,adresse,role)  values('"+ p.getUsername()+"','"+p.getPassword()+"','"+p.getEmail()+"','"+p.getFullname()+"','"+p.getTel()+"','"+p.getAdresse()+"','"+p.getRole()+"')";
       String r = "INSERT INTO `users`(`username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `fullname`, `adresse`, `tel`) "
                         + "VALUES (?,?,?,?,1,NULL,?,SYSDATE(),NULL,NULL,?,?,?,?)";
       
       PreparedStatement ps = c.prepareStatement(r);
       ps.setString(1, p.getUsername());
       ps.setString(2, p.getUsername());
       ps.setString(3, p.getEmail());
       ps.setString(4, p.getEmail());
       ps.setString(5, p.getPassword());
       ps.setString(6, p.getRole());
       ps.setString(7, p.getFullname());
       ps.setString(8, p.getAdresse());
       ps.setString(9, p.getTel());
       
       ps. executeUpdate();
       
       m="vous ete inscrit";
          
  }
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
       return m;
    }
    public void modifierUtilisateur (Integer id ,users u ){
       try {
           PreparedStatement pt =c.prepareStatement("update users set  username =?,password=?,email =?,fullname=?,adresse=?,tel=? where id=?");
          pt.setString(1, u.getUsername());
           pt.setString(2, u.getPassword());
             pt.setString(3, u.getEmail());
               pt.setString(4, u.getFullname());
              
               
            pt.setString(5, u.getAdresse());
            pt.setString(6, u.getTel());
               
             
               pt.setInt(7,id);
               
             
            pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }
    public void modifierUtilisateurProfile (Integer id ,users u ){
       try {
           PreparedStatement pt =c.prepareStatement("update users set  username =?,password =?,email =?,fullname=?,adresse=?,tel=? where id=?");
          pt.setString(1, u.getUsername());
           pt.setString(2, u.getEmail());
             pt.setString(3, u.getFullname());
           pt.setString(3, u.getPassword());
            pt.setString(4, u.getAdresse());
            pt.setString(5, u.getTel());
            
               pt.setInt(6,id);
               
             
            pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
}
    public boolean  SupprimerUser (int id ){
       boolean x=false;
        try {
           PreparedStatement pt =c.prepareStatement("delete from users where id=?");
           pt.setInt(1, id );
           pt.executeUpdate(); 
           x=true;
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
        return x;
    }
     public String getTel(String text) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select tel from users  where users.email=?");
             pt.setString(1, text );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("tel");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
     public String getRole(String username) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select roles from users  where users.username=?");
             pt.setString(1, username );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=(String) rs.getString(1);
                      if (t.equals("a:0:{}"))
                        t = "utilisateur";
                      else if (t.contains("ROLE_ENTREPRISE")) {
                          t ="entreprise";
                
                      }
                        
              }
              
         
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
     public String  validerLogin(String username, String password  ) throws SQLException{
      String m= null;
       
             PreparedStatement pt = c.prepareStatement("select password from users where username=?");
             pt.setString(1,username );
             //pt.setString(2,password );
             ResultSet rs=pt.executeQuery();
             rs.next();
             //int l1=rs.getInt("total");
             //System.out.println("nbr" +l1);
             
             //rs.close();
             String hashed = rs.getString(1);
             String newhash = "$2a" + hashed.substring(3);
             //System.out.println(hashed);
             
             
             
          // int  l= rs.getRow();
          //int l =rs.getInt("total");
          //  System.out.println(l1);
          if (BCrypt.checkpw(password, newhash)){
              
              m=  "utilisateur correct ";
          }
            else 
              m= "utilisateur n'existe pas ";
         
          rs.close();
          
         return m;
       
  }
      public int getIdUtilisateur (String username, String password) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select id  from users where username=?");
             pt.setString(1,username );
              //pt.setString(2,password );
               ResultSet rs=pt.executeQuery();
              while(rs.next()){
                m=rs.getInt("id");}
              
              return m;
     }
       public String getUsername(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select username from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("username");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       public String getpassword(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select password from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("password");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       
       public String getEmail(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select email from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("email");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       public String getfullname(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select fullname from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("fullname");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       public String getadresse(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select adresse from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("adresse");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       public String getTel(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select tel from users  where users.id=?");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("tel");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
       
       
       
       
        public String getnameentreprise(int id) {
          String t = null;
         try {
             PreparedStatement pt = c.prepareStatement("select fullname from users  where users.id=? and users.role='entreprise' ");
             pt.setInt(1, id);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("fullname");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
         public int getiduser(String email) {
          int t = 0;
         try {
             PreparedStatement pt = c.prepareStatement("select id from users  where users.email=?");
             pt.setString(1, email);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getInt("id");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
         public String Userpassword(String email ) {
       String m=null;
         try {
             PreparedStatement pt = c.prepareStatement("select password from users where email=?");
             pt.setString(1, email );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                       m=   rs.getString("password");
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return m;
  }
        public int getIdUtilisateur (String username) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select id  from users where username=? ");
             pt.setString(1,username );
               ResultSet rs=pt.executeQuery();
              while(rs.next()){
                m=rs.getInt("id");}
              
              return m;
     }
}
