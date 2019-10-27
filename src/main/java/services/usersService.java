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
  {Statement st=c.createStatement();//qui va assurer la connexion entre sql et java 
         
       String req="insert into users(username,password,email,fullname,tel,adresse,role)  values('"+ p.getUsername()+"','"+p.getPassword()+"','"+p.getEmail()+"','"+p.getFullname()+"','"+p.getTel()+"','"+p.getAdresse()+"','"+p.getRole()+"')";
       st.executeUpdate(req);
       m="vous ete inscrit";
          
  }
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
       return m;
    }
    public void modifierUtilisateur (Integer id ,users u ){
       try {
           PreparedStatement pt =c.prepareStatement("update users set  username =?,password=?,email =?,fullname=?,adresse=?,tel=?,role=? where id_utilisateur=?");
          pt.setString(1, u.getUsername());
           pt.setString(2, u.getPassword());
             pt.setString(3, u.getEmail());
               pt.setString(4, u.getFullname());
              
               
            pt.setString(5, u.getAdresse());
            pt.setString(6, u.getTel());
               pt.setString(7, u.getRole());
             
               pt.setInt(10,id);
               
             
            pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }
    public void modifierUtilisateurProfile (Integer id ,users u ){
       try {
           PreparedStatement pt =c.prepareStatement("update users set  username =?,email =?,fullname=?,adresse=?,tel=? where id=?");
          pt.setString(1, u.getUsername());
           pt.setString(2, u.getEmail());
             pt.setString(3, u.getFullname());
          
              
               
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
             PreparedStatement pt = c.prepareStatement("select role from users  where users.username=?");
             pt.setString(1, username );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                      t=rs.getString("role");
              }
         } catch (SQLException ex) {
             Logger.getLogger(usersService.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         return t;
    }
     public String  validerLogin(String username, String password  ) throws SQLException{
      String m= null;
       
             PreparedStatement pt = c.prepareStatement("select count(*) as total from users where username=? and password=? ");
             pt.setString(1,username );
              pt.setString(2,password );
                  
             ResultSet rs=pt.executeQuery();
             rs.next();
             int l1=rs.getInt("total");
             System.out.println("nbr" +l1);
             rs.close();
         // int  l= rs.getRow();
          //int l =rs.getInt("total");
          //  System.out.println(l1);
          if (l1!=1){
              m= "utilisateur n'existe pas ";
          }
            else  m=  "utilisateur correct ";
         
         return m;
       
  }
      public int getIdUtilisateur (String username, String password) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select id  from users where username=? and password=?");
             pt.setString(1,username );
              pt.setString(2,password );
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
}
