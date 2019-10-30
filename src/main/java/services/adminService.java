/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Connection.ConnexionBD;
import entities.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author firos
 */
public class adminService {
    Connection c= ConnexionBD.getInstanceConnexionBD().getConnection();
    public String ajouterAdmin(admin a){
        String m=null;
        try {
             PreparedStatement pt = c.prepareStatement("select * from admin where username =? ");
            pt.setString(1, a.getUsername());
            
            ResultSet rs=pt.executeQuery();
  if(rs.next())
  { 
      System.out.println( "admin existe ");
   
  
  }
  else
  {Statement st=c.createStatement();//qui va assurer la connexion entre sql et java 
         
       String req="insert into admin(username,password,email,previliges)  values('"+ a.getUsername()+"','"+a.getPassword()+"','"+a.getEmail()+"',"+a.getPreviliges()+")";
       st.executeUpdate(req);
       m="vous ete inscrit";
          
  }
       } catch (SQLException ex) {
           Logger.getLogger(adminService.class.getName()).log(Level.SEVERE, null, ex);
       }
       return m;
    }
     public String  validerLogin(String username, String password  ) throws SQLException{
      String m= null;
       
             PreparedStatement pt = c.prepareStatement("select count(*) as total from admin where username=? and password=? ");
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
              m= "admin n'existe pas ";
          }
            else  m=  "admin correct ";
         
         return m;
       
  }
   public int getIdprevilige (String username) throws SQLException{
        int m=0;
          PreparedStatement pt = c.prepareStatement("select previliges  from users where username=?");
             pt.setString(1,username );
             
               ResultSet rs=pt.executeQuery();
              while(rs.next()){
                m=rs.getInt("previliges");}
              
              return m;
     }     
         public void modifierUtilisateurProfile (Integer id ,admin u ){
       try {
           PreparedStatement pt =c.prepareStatement("update users set  username =?,password=?,email =?,previliges=? where id=?");
          pt.setString(1, u.getUsername());
          pt.setString(2, u.getPassword());
           pt.setString(3, u.getEmail());
             pt.setInt(4, u.getPreviliges());
                  pt.setInt(5,id);
               
             
            pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(adminService.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
}
      public boolean  Supprimeradmin (int id ){
       boolean x=false;
        try {
           PreparedStatement pt =c.prepareStatement("delete from admin where id=?");
           pt.setInt(1, id );
           pt.executeUpdate(); 
           x=true;
       } catch (SQLException ex) {
           Logger.getLogger(adminService.class.getName()).log(Level.SEVERE, null, ex);
       }
        return x;
    } 
      public String Adminemail(String username ) {
       String m=null;
         try {
             PreparedStatement pt = c.prepareStatement("select email from admin where username=?");
             pt.setString(1,username);
             ResultSet rs=pt.executeQuery();
              while(rs.next()){
            
                       m=   rs.getString("email");
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(adminService.class.getName()).log(Level.SEVERE, null, ex);
         }
         return m;
  }
        
}
