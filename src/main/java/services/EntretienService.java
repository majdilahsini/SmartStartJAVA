/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Entretien;
import interfaces.IEntretienService;
import java.sql.Connection;
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
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author User
 */
public class EntretienService extends Generic_Connection implements IEntretienService {
       Connection c = DBConnection
           .getInstance()
           .getConnection();
       private static EntretienService instance;
    Statement ste;
    private ResultSet rs;
        ServiceEntreprisePlus se = new ServiceEntreprisePlus();


    public EntretienService() {
        try {
            ste = c.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        public static EntretienService getInstance(){
        if(instance==null) 
            instance=new EntretienService();
        return instance;
    }
      /* @Override
      public List<Entretien> afficherEntretiens() {
      
      List<Entretien> entretiens = new ArrayList<>();
      Entretien e = null ;
      String req2="select * from entretien";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              e = new Entretien(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));
                     

              entretiens.add(e);
          }
        

          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return entretiens;
    } */
public ObservableList<Entretien> displayAll() {
        String req="select * from entretien";
        ObservableList<Entretien> list=FXCollections.observableArrayList();       
        
        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                e.setRef_ent( rs.getInt("Ref_ent"));
                      e.setId_entreprise( rs.getInt("Id_entreprise") );
                      e.setId_user(rs.getInt("Id_user"));
                      e.setPoste_ent(rs.getString("Poste_ent"));
                      e.setDate_ent(rs.getString("Date_ent"));
                      e.setHeure_ent(rs.getString("Heure_ent"));
                      e.setDescription_ent(rs.getString("Description_ent"));
                list.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public ObservableList<Entretien> displayAll2() {
        String req="SELECT e.poste_ent,e.date_ent,e.heure_ent,e.description_ent FROM entretien e";
        ObservableList<Entretien> list=FXCollections.observableArrayList();       
        
        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                      e.setPoste_ent(rs.getString("Poste_ent"));
                      e.setDate_ent(rs.getString("Date_ent"));
                      e.setHeure_ent(rs.getString("Heure_ent"));
                      e.setDescription_ent(rs.getString("Description_ent"));
                list.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public ObservableList<Entretien> displayAll3(){
       
          /*  String req="SELECT e.nom,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM entreprises e JOIN entretien en ON e.id=en.id_entreprise";*/
String req="SELECT e.nom AS nomE,u.nom,u.prenom,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent,en.ref_ent FROM entreprises e JOIN entretien en ON e.id=en.id_entreprise JOIN utilisateurs u ON en.id_user=u.id";
        ObservableList<Entretien> list=FXCollections.observableArrayList();  
     /*   int i = rs.getInt("Ref_ent");
                int a = rs.getInt("Id_entreprise");
        int b = rs.getInt("Id_user");*/

        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                e.setRef_ent( rs.getInt("Ref_ent"));
                e.setNom_ent(rs.getString("nomE"));
                e.setNom_user(rs.getString("nom"));
                e.setPrenom_user(rs.getString("prenom"));
                e.setPoste_ent(rs.getString("Poste_ent"));
                e.setDate_ent(rs.getString("Date_ent"));
                e.setHeure_ent(rs.getString("Heure_ent"));
                e.setDescription_ent(rs.getString("Description_ent"));
                                list.add(e);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public ObservableList<Entretien> displayAll5(int id){
       
          /*  String req="SELECT e.nom,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM entreprises e JOIN entretien en ON e.id=en.id_entreprise";*/
String req="SELECT u.fullname,en.ref_ent,en.id_condidat,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM users u JOIN entretienss en ON u.id=en.id_entreprise WHERE u.id='"+id+"'";
        ObservableList<Entretien> list=FXCollections.observableArrayList();  
     /*   int i = rs.getInt("Ref_ent");
                int a = rs.getInt("Id_entreprise");
        int b = rs.getInt("Id_user");*/

        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                 e.setNom_ent(rs.getString("fullname"));
                e.setRef_ent( rs.getInt("Ref_ent"));
                  int idu =  rs.getInt("Id_condidat") ;
                  
                  String nom = getNomUserById(idu);
               /*   rs.getString("id_user")*/
               e.setNom_user(nom);
                e.setPoste_ent(rs.getString("Poste_ent"));
                e.setDate_ent(rs.getString("Date_ent"));
                e.setHeure_ent(rs.getString("Heure_ent"));
                e.setDescription_ent(rs.getString("Description_ent"));
                                list.add(e);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

public ObservableList<Entretien> displayAll6(int id){
       
          /*  String req="SELECT e.nom,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM entreprises e JOIN entretien en ON e.id=en.id_entreprise";*/
String req="SELECT u.fullname,en.ref_ent,en.id_entreprise,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM users u JOIN entretienss en ON u.id=en.id_condidat WHERE u.id='"+id+"'";
        ObservableList<Entretien> list=FXCollections.observableArrayList();  
     /*   int i = rs.getInt("Ref_ent");
                int a = rs.getInt("Id_entreprise");
        int b = rs.getInt("Id_user");*/

        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                /* e.setNom_ent(rs.getString("fullname"));
                e.setRef_ent( rs.getInt("Ref_ent"));
                  int idu =  rs.getInt("id_entreprise") ;
                  
                  String nom = getNomUserById(idu);
                 rs.getString("id_user")
               e.setNom_user(nom);*/
                int idu =  rs.getInt("id_entreprise") ;
                   String nom = getNomUserById(idu);
                   e.setNom_ent(nom);
                   e.setRef_ent( rs.getInt("Ref_ent"));
                   e.setNom_user(rs.getString("fullname"));
                   
                e.setPoste_ent(rs.getString("Poste_ent"));
                e.setDate_ent(rs.getString("Date_ent"));
                e.setHeure_ent(rs.getString("Heure_ent"));
                e.setDescription_ent(rs.getString("Description_ent"));
                                list.add(e);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

  
      
      
 /*   public void insert(Entretien e) throws SQLException {
String req="INSERT INTO entretien(id_entreprise,id_user,poste_ent,date_ent,heure_ent,description_ent) VALUES (?,?,?,str_to_date(?,'%m,%d,%Y'),?,?)";
PreparedStatement pres=c.prepareStatement(req);
pres.setInt(1,e.getId_entreprise() );
pres.setInt(2,e.getId_user());
pres.setString(3,e.getPoste_ent() );
pres.setString(4,e.getDate_ent() );
pres.setString(5,e.getHeure_ent());
pres.setString(6,e.getDescription_ent());

    pres.executeUpdate();
    }   */

    @Override
    public List afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void CreerEntretien(Entretien e) throws SQLException {
         String req="INSERT INTO `entretienss`(`id_entreprise`,`id_condidat`,`poste_ent`,`date_ent`,`heure_ent`, `description_ent`) VALUES"
                + "(?,?,?,str_to_date(?,'%Y-%m-%d'),?,?)";
  PreparedStatement pres = c.prepareStatement(req);
pres.setInt(1,e.getId_entreprise() );
pres.setInt(2,e.getId_condidat());
pres.setString(3,e.getPoste_ent() );
pres.setString(4,e.getDate_ent());
pres.setString(5,e.getHeure_ent());
pres.setString(6,e.getDescription_ent());
//pres.setString(11, f.getImage());

System.out.println(pres.executeUpdate());
      System.out.println("formation inseré");
  
    }

    public void deleteEnt(int ref) {
         try {
       
    String req1 ="DELETE FROM entretienss WHERE ref_ent = ?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, ref);

            ps.executeUpdate();
                  System.out.println("entretien supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<Entretien> displayAll4() throws SQLException {
        String req="SELECT e.nom AS nomE,u.nom,u.prenom,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM entreprises e JOIN entretien en on e.id=en.id_entreprise JOIN utilisateurs u ON en.id_user=u.id";
        ObservableList<Entretien> list=FXCollections.observableArrayList();  
     /*   int i = rs.getInt("Ref_ent");
                int a = rs.getInt("Id_entreprise");
        int b = rs.getInt("Id_user");*/

        try {
            rs=ste.executeQuery(req);
            while(rs.next()){
                Entretien e = new Entretien();
                e.setNom_ent(rs.getString("Nom_ent"));
                e.setNom_user(rs.getString("Nom_user"));
                e.setPrenom_user(rs.getString("Prenom_user"));
                e.setPoste_ent(rs.getString("Poste_ent"));
                e.setDate_ent(rs.getString("Date_ent"));
                e.setHeure_ent(rs.getString("Heure_ent"));
                e.setDescription_ent(rs.getString("Description_ent"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void UpdateEntretien(int ref,String poste, String date, String heure, String description) throws SQLException {
        String req = "UPDATE entretienss SET poste_ent= ?,date_ent= ?,heure_ent= ?,description_ent= ?  WHERE ref_ent= ?";

       PreparedStatement pstmt = c.prepareStatement(req);
        pstmt.setString(1,poste);
         pstmt.setString(2,date);
          pstmt.setString(3,heure);
       pstmt.setString(4,description);
       pstmt.setInt(5,ref);
       
      
      
       
       
        pstmt.executeUpdate();
        System.out.println("Update Abonnement Done!");
    

}
    public List<Entretien> rechercheEntretien(String rech, int i) throws SQLException {

        List<Entretien> ab = new ArrayList<>();
String req = "SELECT en.id_condidat,en.ref_ent,u.fullname,en.poste_ent,en.date_ent,en.heure_ent,en.description_ent FROM users u JOIN entretienss en ON u.id=en.id_entreprise WHERE u.id='"+i+"' AND ( u.fullname Like '%"+rech+"%' OR en.ref_ent Like '%"+rech+"%' OR en.description_ent Like '%"+rech+"%' OR en.heure_ent Like '%"+rech+"%' OR en.poste_ent Like '%"+rech+"%' ) " ;     
        Statement stm = c.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
                       /*   e.setRef_ent( rs.getInt("Ref_ent"));
                e.setNom_ent(rs.getString("nomE"));
                e.setNom_user(rs.getString("nom"));
                e.setPrenom_user(rs.getString("prenom"));
                e.setPoste_ent(rs.getString("Poste_ent"));
                e.setDate_ent(rs.getString("Date_ent"));
                e.setHeure_ent(rs.getString("Heure_ent"));
                e.setDescription_ent(rs.getString("Description_ent"));*/
                         Entretien e = new Entretien();
                 e.setNom_ent(rst.getString("fullname"));
                e.setRef_ent( rst.getInt("Ref_ent"));
                  int idu =  rst.getInt("Id_condidat") ;
                  
                  String nom = getNomUserById(idu);
               /*   rs.getString("id_user")*/
                e.setNom_user(nom);
                e.setPoste_ent(rst.getString("Poste_ent"));
                e.setDate_ent(rst.getString("Date_ent"));
                e.setHeure_ent(rst.getString("Heure_ent"));
                e.setDescription_ent(rst.getString("Description_ent"));
       /*  String nom = getNomUserById(getInt("id_condidat"));

           Entretien e = new Entretien(rst.getInt("ref_ent")
                    , rst.getString("fullname")
                   , rst.getString(nom)*/
                 /*  , rst.getString("prenom")*/

        /*   , rst.getString("poste_ent"), rst.getString("date_ent"), rst.getString("heure_ent")

           , rst.getString("description_ent"));*/
            ab.add(e);
        }
        return ab;
    }

    public String getNomUserById(int idu) {
        String t=null;


try {
               PreparedStatement pt = c.prepareStatement("select fullname from users where users.id=? ");
            pt.setInt(1,idu);
            ResultSet rs= pt.executeQuery();
            while(rs.next()){
                t=rs.getString("fullname");
    
    }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
return t ;

    }

   
                public String getEmailBynom(String nom_ent) {
        String t=null;


try {
               PreparedStatement pt = c.prepareStatement("select email from users where users.fullname=? ");
            pt.setString(1,nom_ent);
            ResultSet rs= pt.executeQuery();
            while(rs.next()){
                t=rs.getString("email");
    
    }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }
return t ;

    }
    


}
    /*   @Override
   public void supprimerEntretien(Entretien e)throws SQLException {
        try {
            String req1="delete from entretien where"
                    + " ref_ent=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, e.getRef_ent());
            ps.executeUpdate();
         
                System.out.println(ps.executeUpdate());

        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }}*/
     /* @Override
    public void modifierEntretien(Entretien e) throws SQLException {
String req="UPDATE entretien SET ref_ent=?,id_entreprise=?,id_user=?,poste_ent=?,date_ent=str_to_date(?,'%m,%d,%Y'),heure_ent=?,description_ent=? WHERE ref_ent=? ";
PreparedStatement pres=c.prepareStatement(req);
pres.setInt(1,e.getRef_ent() );
pres.setInt(2,e.getId_entreprise() );
pres.setInt(3,e.getId_user());
pres.setString(4,e.getPoste_ent() );
pres.setString(5,e.getDate_ent() );
pres.setInt(6,e.getHeure_ent());
pres.setString(7,e.getDescription_ent());
pres.setInt(8,e.getRef_ent() );

System.out.println(pres.executeUpdate());

System.out.println("element modifier");

}}*/
       
     /*  @*/
    


   /* */
   /*
@Override 
       public void creerEntretien(Entretien e) throws SQLException{ 


String req="INSERT INTO entretien(ref_ent, id_entreprise,id_user,poste_ent,date_ent,heure_ent,description_ent) VALUES (?,?,?,?,str_to_date(?,'%m,%d,%Y'),?,?)";
PreparedStatement pres=c.prepareStatement(req);
pres.setInt(1,e.getRef_ent() );
pres.setInt(2,e.getId_entreprise() );
pres.setInt(3,e.getId_user());
pres.setString(4,e.getPoste_ent() );
pres.setString(5,e.getDate_ent() );  //str_to_date(?,%m,%d,%y)
pres.setInt(6,e.getHeure_ent());
pres.setString(7,e.getDescription_ent());
System.out.println(pres.executeUpdate());
System.out.println("element inserer");
       }}*/
  

       


      /* @Override
    /* public void modifierEntretien(Entretien e) throws SQLException{*/
           /*
/*
    @Override
    public void supprimerEntretien(Entretien e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
*/


     /*  @Override
    public List<Entretien> afficherEntretiens() {
      
      List<Entretien> entretiens = new ArrayList<>();
      Entretien e = null ;
      String req2="select * from entretien";
      try {
         
         
          ResultSet res=  ste.executeQuery(req2);
          while (res.next()) { 
              e = new Entretien();
                      e.setRef_ent( res.getInt("Ref_ent"));
                      e.setId_entreprise( res.getInt("Id_entreprise") );
                      e.setId_user(res.getInt("Id_user"));
                      e.setPoste_ent(res.getInt("Poste_ent"));
                      e.setDate_ent(res.getInt("Poste_ent"));
                      e.setHeure_ent(res.getInt("Heure_ent"));
                      e.setDescription_ent(res.getInt("Description_ent"));

              entretiens.add(e);
          }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      } 
        
     return entretiens;
    }
}/*
/*
    @Override
    public List<Entretien> afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
/*
    @Override
    public List<Entretien> afficherEntretiens() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    /**
     *
     * @param e
     * @throws SQLException
     */
    
   
   /*
       @Override
       public void modifierEntretien(Entretien e) throws SQLException{
           String req="UPDATE entretien SET ref_ent`=?,id_entreprise`=?,`id_user`=?,`poste_ent`=?,`date_ent`=?,`heure_ent`=?,`description_ent`=? WHERE `ref_ent`=? ";
PreparedStatement pres=c.prepareStatement(req);
pres.setInt(1,e.getRef_ent() );
pres.setInt(2,e.getId_entreprise() );
pres.setInt(3,e.getId_user());
pres.setInt(4,e.getPoste_ent() );
pres.setInt(5,e.getDate_ent() );
pres.setInt(6,e.getHeure_ent());
pres.setInt(7,e.getDescription_ent());
System.out.println("element modifier");

}
}*/
       
/*
    @Override
    public void modifierEntretien(Entretien e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

  /*  

    @Override
    public void modifierEntretien(Entretien e) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
/*
    @Override
    public List<Entretien> afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
/*
    @Override
    public List<Entretien> afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
/*
    @Override
    public void creerEntreien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entretien> afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 /*    
    public void supprimerEntretien(Entretien e) {
        try {
            String req1="delete from entretien where"
                    + " ref_ent=?";
       
      PreparedStatement ps = c.prepareStatement(req1);
            ps.setInt(1, e.getRef_ent());
            ps.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(EntretienService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/
    
    /*

    @Override
    public void modifierEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public List<Entretien> afficherEntretiens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void creerEntreien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

