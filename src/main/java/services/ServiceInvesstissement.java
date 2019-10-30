/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Invesstissement;
import entities.myInvestment;
import interfaces.InterfaceServiceInvesstissement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.DBConnection;

/**
 *
 * @author ASUS
 */
public class ServiceInvesstissement implements  InterfaceServiceInvesstissement {
    private Connection con = DBConnection.getInstance().getConnection();
    private Statement ste;
     public ServiceInvesstissement() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

    @Override
    public void ajouterInvesstissement(Invesstissement i) throws SQLException {
       String req="INSERT INTO `investissement`(`montant`, `numcarteBancaire`, `id_projet`, `id_invesstisseur`) VALUES (?,?,?,?)";
  PreparedStatement pres=con.prepareStatement(req);
  int j=1;
  //pres.setInt(j++,i.getId_investissement() );
  pres.setInt(j++,i.getMontant());
  pres.setInt(j++,i.getNumcarteBancaire() );
pres.setInt(j++,i.getId_projet() );
pres.setInt(j++,i.getId_invesstisseur());
System.out.println(pres.executeUpdate()+"\n");
      System.out.println("element inserer");
    }

    @Override
    public void modifierInvesstissement(Invesstissement i) throws SQLException {
        String req="UPDATE `investissement` SET `id_investissement`=?,`montant`=?,`numcarteBancaire`=?,`id_projet`=?,`id_invesstisseur`=? WHERE `id_investissement`=? ";
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1,i.getId_investissement() );
  pres.setInt(2,i.getMontant());
  pres.setInt(3,i.getNumcarteBancaire() );
pres.setInt(4,i.getId_projet() );
pres.setInt(5,i.getId_invesstisseur());
pres.setInt(6,i.getId_investissement() );
System.out.println(pres.executeUpdate()+"\n");
      System.out.println("element modifier");
    }

    @Override
    public void SupprimerInvesstissement(Invesstissement i) throws SQLException {
         String req="DELETE FROM `investissement` WHERE ( `id_investissement`= ? ); ";
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, i.getId_investissement());

System.out.println(pres.executeUpdate()+"\n");
    }

    @Override
    public List<Invesstissement> AfficheInvesstissement() throws SQLException {

        List<Invesstissement> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from `investissement` ");
    Invesstissement pro=null;
    while (res.next()) {            
      pro=new Invesstissement(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5));
      list.add(pro);
        }
    return list;    }
    
    
    
public String getnomentreprisebyId(int id) throws SQLException
{
 String ch="";
 String req="select fullname from `users`  WHERE id = ?";
        
        PreparedStatement pres=con.prepareStatement(req);
          pres.setInt(1,id );

        ResultSet res=pres.executeQuery(); 
         while (res.next()) {            
      ch=res.getString(1);
      
        }
         
  return ch;       
}
public String getnomProjetbyId(int id) throws SQLException
{
 String ch="";
 String req="select nom_projet from `projet`  WHERE id_projet = ? ";
        
        PreparedStatement pres=con.prepareStatement(req);
          pres.setInt(1,id );

        ResultSet res=pres.executeQuery(); 
         while (res.next()) {            
      ch=res.getString(1);
      
        }
         
  return ch;       
}
    
    public List<myInvestment> getmyInvesstissement(int id) throws SQLException {

        List<Invesstissement> list=new ArrayList<>();
         List<myInvestment> list1=new ArrayList<>();
         ServiceInvesstissement s=new ServiceInvesstissement();
    String req="select * from `investissement` where id_invesstisseur = ? ";
        
        PreparedStatement pres=con.prepareStatement(req);
          pres.setInt(1,id );

        ResultSet res=pres.executeQuery(); 
    myInvestment pro=null;
    while (res.next()) {            
      pro=new myInvestment(s.getnomProjetbyId(res.getInt(4)),s.getnomentreprisebyId(res.getInt(5)),Integer.toString(res.getInt(2)),Integer.toString(res.getInt(3)));
      list1.add(pro);
        }
    return list1;    
    }
    
  public List<myInvestment> getmyProjectInvesstissement(int id) throws SQLException {

        List<Invesstissement> list=new ArrayList<>();
         List<myInvestment> list1=new ArrayList<>();
         ServiceInvesstissement s=new ServiceInvesstissement();
    String req="SELECT I.* FROM investissement I, projet P WHERE I.id_projet = P.id_projet AND P.id_entreprise=? ";
        
        PreparedStatement pres=con.prepareStatement(req);
          pres.setInt(1,id );

        ResultSet res=pres.executeQuery(); 
    myInvestment pro=null;
    while (res.next()) {            
      pro=new myInvestment(s.getnomProjetbyId(res.getInt(4)),s.getnomentreprisebyId(res.getInt(5)),Integer.toString(res.getInt(2)),Integer.toString(res.getInt(3)));
      list1.add(pro);
        }

    return list1;    
    }

     public int getProjet(String email) throws SQLException{  
  String req="SELECT `id_projet` from projet WHERE `email_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setString(1, email);
res=pres.executeQuery();
    
String ch="";
 while (res.next()) {   
           
ch=res.getString(1);
     
        }

     return Integer.parseInt(ch);
  
  }
     public int getProjet(int id ) throws SQLException{  
  String req="SELECT `id_projet` from projet WHERE `id_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, id);
res=pres.executeQuery();
    
int ch=0;
 while (res.next()) {   
           
ch=res.getInt(1);
     
        }

     return ch;
  
  }
     
     
     
     
     
     
     
     
     
     
     
}
