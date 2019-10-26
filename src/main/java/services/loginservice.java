/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Connection.DBConnection;
import entities.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author firos
 */
public class loginservice {
    Connection c= DBConnection.getInstance().getConnection();
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
   
     public login getUtilisaeur(int id){
          login u =new login();
         try {
             PreparedStatement pt = c.prepareStatement("select * from users where id=?");
             pt.setInt(1, id );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
  u =new login(rs.getString("username"),rs.getString("password"),rs.getInt("role"))  ;
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(loginservice.class.getName()).log(Level.SEVERE, null, ex);
         }
         return u;
         
     }
     public boolean modifierPassword(String text,int id ) {
        boolean t =false;
    try {
           PreparedStatement pt =c.prepareStatement("update users set  password=? where id=?");
          pt.setString(1,text);
        
            
               pt.setInt(2,id );
               
             
            pt.executeUpdate();
            t=true;
       } catch (SQLException ex) {
           Logger.getLogger(loginservice.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    return t;
    }


   public int typeUsernumero(String username ) {
         try {
             PreparedStatement pt = c.prepareStatement("select role from users where username=?");
             pt.setString(1, username );
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
                    int m=   rs.getInt("role");
             
              return m ;}
         } catch (SQLException ex) {
             Logger.getLogger(loginservice.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
 
   }
    public int getIdUtilisateur (String username, String password) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select id  from users where username=? and password=?");
             pt.setString(1,username );
              pt.setString(2,password );
               ResultSet rs=pt.executeQuery();
              while(rs.next()){
                m=   rs.getInt("id");}
              
              return m;
     }
     public int getRoleUtilisateur (String username, String password) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select role  from users where username=? and password=?");
             pt.setString(1,username );
              pt.setString(2,password );
               ResultSet rs=pt.executeQuery();
              while(rs.next()){
                m=   rs.getInt("role");}
              
              return m;
     }
}
