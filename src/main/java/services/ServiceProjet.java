package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Connection.DBConnection;
import entities.Projet;
import entities.myprojects;
import interfaces.InterfaceServiceProjet;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.XYChart;

/**
 *
 * @author ASUS
 */

    
public class ServiceProjet {
private Connection con = DBConnection.getInstance().getConnection();
    private Statement ste;
     public ServiceProjet() {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);  
        }
    }

     
     
     

     public List<Projet> AfficheProjet() throws SQLException
    {List<Projet> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select * from projet");
    Projet pro=null;
    while (res.next()) {            
      pro=new Projet(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6),res.getInt(7),res.getString(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getString(13),res.getInt(14),res.getString(15));//res.getInt(1), res.getInt(3),res.getString(2),);
      list.add(pro);
        }
    return list;
    } 
         public List<myprojects> AffichemyProjet() throws SQLException
    {List<myprojects> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select `nom_projet`, `categorie`,`date_debut_projet`, `adresse_projet`, `description_projet`,`email_projet` from projet");
    myprojects pro=null;
    while (res.next()) {            
      pro=new myprojects(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
      list.add(pro);
        }
    return list;
    } 
    
   public void SupprimerProjet(int id) throws SQLException{  
  String req="DELETE FROM projet WHERE ( id_projet= ? ); ";
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, id);

System.out.println(pres.executeUpdate()+"\n");
      System.out.println("element supprimer");
  
  }
 public void ModifierProjet(Projet p) throws SQLException{  
  String req="UPDATE `projet` SET `id_projet`=?,`nom_projet`=?,`categorie`=?,`votre_finance`=?,`montant`=?,`compte_bancaire`=?,`duree`=?"
          + ",`date_debut_projet`=str_to_date(?,'%Y-%m-%d'),`adresse_projet`=?,`tel_projet`=?,`nbre_team`=?,`description_projet`=?,`email_projet`=?,`id_entreprise`=? ,Image=? WHERE id_projet=?";
  PreparedStatement pres=con.prepareStatement(req);
  int i=1;
  pres.setInt(i++, p.getIdProjet());
pres.setString(i++, p.getNomprojet());
pres.setString(i++, p.getCategorie());

pres.setInt(i++, p.getVotreFinance());

pres.setLong(i++, p.getMontant());
pres.setLong(i++, p.getCompteBancaire());
pres.setInt(i++, p.getDuree());

pres.setString(i++, p.getDateDebutProjet());
pres.setString(i++, p.getAdresseProjet());
pres.setInt(i++, p.getTelProjet());
pres.setInt(i++, p.getNbreTeam());
pres.setString(i++, p.getDescriptionProjet());
pres.setString(i++, p.getEmailProjet());
pres.setInt(i++, p.getId_enterprise());
pres.setString(i++, p.getImage());
pres.setInt(i++, p.getIdProjet());
  
System.out.println(pres.executeUpdate()+"\n");
      System.out.println("element modifier");
  
  }
   /*    public List<Projet> RechercheProjet(int id,String nom,String categorie) throws SQLException
    {List<Projet> list=new ArrayList<>();
    ResultSet res;
    if(id!=0)
    {String req1="select * from projet where id_projet=?";
        PreparedStatement pres=con.prepareStatement(req1);
        pres.setInt(1, id);
    
  res= pres.executeQuery();
     
    }
    else if(nom!=null)
    {String req1="select * from projet where nom_projet=? ";
        PreparedStatement pres=con.prepareStatement(req1);
       pres.setString(1, nom);
    
   res=pres.executeQuery();
        
    }
    else
    {
        String req1="select * from projet where categorie=?";
        PreparedStatement pres=con.prepareStatement(req1);
        pres.setString(1, categorie);
    
   res=pres.executeQuery();
       
    }
    
    Projet pro=null;
    while (res.next()) {            
      pro=new Projet(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9),null,null,res.getString(12),res.getInt(13),res.getInt(14),res.getString(15),res.getString(16),res.getInt(17));//res.getInt(1), res.getInt(3),res.getString(2),);
      list.add(pro);
        }
    return list;
    } 

   */
    public void ajouterProjet(Projet p) throws SQLException {
              
     
  String req="INSERT INTO `projet`( `nom_projet`, `categorie`, "
          + "`votre_finance`,`montant`, `compte_bancaire`, `"
          + "duree`,`date_debut_projet`, `adresse_projet`, `tel_projet`, `nbre_team`,"
          + " `description_projet`, `email_projet`, `id_entreprise`,Image) VALUES "
          + "(?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d'),?,?,?,?,?,?,?)";
  PreparedStatement pres=con.prepareStatement(req);
  int i=1;
 // pres.setInt(1, p.getIdProjet());
pres.setString(i++, p.getNomprojet());
pres.setString(i++, p.getCategorie());
pres.setInt(i++, p.getVotreFinance());
pres.setLong(i++, p.getMontant());
pres.setLong(i++, p.getCompteBancaire());
pres.setInt(i++, p.getDuree());
pres.setString(i++, p.getDateDebutProjet());
pres.setString(i++, p.getAdresseProjet());
pres.setInt(i++, p.getTelProjet());
pres.setInt(i++, p.getNbreTeam());
pres.setString(i++, p.getDescriptionProjet());
pres.setString(i++, p.getEmailProjet());
pres.setInt(i++, p.getId_enterprise());
pres.setString(i++, p.getImage());

System.out.println(pres.executeUpdate()+"\n");
      System.out.println("element inserer");
    }

  public String getCateg(int idcategorie) throws SQLException{  
  String req="SELECT  `nom` FROM `categories` WHERE id=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, idcategorie);
res=pres.executeQuery();
    
String ch="";
 while (res.next()) {            
     ch=res.getString(1);
        }

     return ch;
  
  }
 public List<String> getCategcategoriesCombobox() throws SQLException{  
  String req="SELECT  `nom`  FROM `categories`  ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  
res=pres.executeQuery();
    List<String> l=new ArrayList();
    
String ch="";
 while (res.next()) {            
     ch=res.getString(1);
     l.add(ch);
        }

     return l;
  
  }  

    public List<myprojects> rechercheProjetSimple(String che) throws SQLException
    {List<myprojects> list=new ArrayList<>();
    ResultSet res=ste.executeQuery("select `nom_projet`, `categorie`,`date_debut_projet`, `adresse_projet`, `description_projet`,`email_projet` from `projet` ");
    myprojects pro=null;
    while (res.next()) {            
pro=new myprojects(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));      if(pro.getNomprojet().contains(che)||(pro.getAdresseProjet().contains(che))||(pro.getEmailProjet().contains(che))||(pro.getDescriptionProjet().contains(che))||(pro.getCategorie().contains(che)))
      {
       list.add(pro);  
      }
      
      //list.add(pro);
        }
    return list;
    /*if(list.size()!=0){
    for(int i=0;i<list.size();i++)
         System.out.println(list.get(i)+"\n");
    } 
    else
        System.out.println("Sorry we dont found :" +che);
*/
    }
      public boolean  verifierEx(List<myprojects> list,myprojects u)
      { 
          for(int i=0;i<list.size();i++)
         if(list.get(i).equals(u))
             return true;
          
          return false;
      }
      
    /**
     *
     * @param che
     * @throws SQLException
     */
  public  List<myprojects> rechercheProjet(String che) throws SQLException
     { int i=0;
     List<myprojects> list=new ArrayList<>();
     List<myprojects> list1=new ArrayList<>();
         if(che.contains(" "))
         {
          String[] str = che.split(" ") ;
         while(i<str.length){
             
         list1=rechercheProjetSimple(str[i]);
         for(int j=0;j<list1.size();j++)
         {
             if(verifierEx(list, list1.get(j))==false)
             {
                 list.add(list1.get(j));
             }
         }
          i++;
         }
         }
         else
            list.addAll(rechercheProjetSimple(che));
             
  return list;

     } 
  
  public List<myprojects> AffichemyProjet(int id) throws SQLException
    {List<myprojects> list=new ArrayList<>();
    String req="select `nom_projet`, `categorie`,`date_debut_projet`, `adresse_projet`, `description_projet`,`email_projet` from projet where id_entreprise=?";
     PreparedStatement pres=con.prepareStatement(req);
     pres.setInt(1, id);
    ResultSet res;
    res=pres.executeQuery();
    
    myprojects pro=null;
    while (res.next()) {            
      pro=new myprojects(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
      list.add(pro);
        }
    return list;
    } 
  
  
  public Projet getProjet(String email) throws SQLException{  
  String req="SELECT `id_projet`, `nom_projet`, `categorie`, `votre_finance`, `montant`, `compte_bancaire`, `duree`, `date_debut_projet`, `adresse_projet`, `tel_projet`, `nbre_team`, `description_projet`, `email_projet`, `id_entreprise` ,Image FROM `projet` WHERE `email_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setString(1, email);
res=pres.executeQuery();
    
Projet pro=null;
 while (res.next()) {   
           pro=new Projet(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getLong(5),res.getLong(6),res.getInt(7),res.getString(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getString(13),res.getInt(14),res.getString(15));//res.getInt(1), res.getInt(3),res.getString(2),);

     
        }

     return pro;
  
  }
  
   public List<myprojects> AffichemyProjetcategorie(String ch) throws SQLException
    {List<myprojects> list=new ArrayList<>();
    String req="";
    if(ch!=null){
     req="select `nom_projet`, `categorie`,`date_debut_projet`, `adresse_projet`, `description_projet`,`email_projet` from projet where categorie=?";
    }
     else
         req="select `nom_projet`, `categorie`,`date_debut_projet`, `adresse_projet`, `description_projet`,`email_projet` from projet ";

     PreparedStatement pres=con.prepareStatement(req);
    
    pres.setString(1, ch);
    ResultSet res;
    res=pres.executeQuery();
    
    myprojects pro=null;
    while (res.next()) {            
      pro=new myprojects(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6));
      list.add(pro);
        }
    return list;
    } 
   public List<myprojects> rechercheUtilisateursSimple(String che,String che1) throws SQLException
    {List<myprojects> list=new ArrayList<>();
    ServiceProjet s=new ServiceProjet();
    list=s.AffichemyProjetcategorie(che);
    List<myprojects> list1=new ArrayList<>();
    for(myprojects p : list)        {   
     
      if(p.getNomprojet().contains(che1))
      {
       list1.add(p);  
      }
     
        }
    return list1;
    
    }
  public int getIdProjet_byEmail(String email) throws SQLException
  {
       String req="SELECT `id_projet` FROM `projet` WHERE `email_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setString(1, email);
res=pres.executeQuery();
    
int pro=0;
 while (res.next()) {   
           pro=res.getInt(1);//res.getInt(1), res.getInt(3),res.getString(2),);

     
        }

     return pro;
  
  }
  
  public Projet getProjet(int id) throws SQLException{  
  String req="SELECT `id_projet`, `nom_projet`, `categorie`, `votre_finance`, `montant`, `compte_bancaire`, `duree`, `date_debut_projet`, `adresse_projet`, `tel_projet`, `nbre_team`, `description_projet`, `email_projet`, `id_entreprise` ,Image " +
" FROM `projet` WHERE `id_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, id);
res=pres.executeQuery();
    
Projet pro=null;
 while (res.next()) {   
           pro=new Projet(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getLong(5),res.getLong(6),res.getInt(7),res.getString(8),res.getString(9),res.getInt(10),res.getInt(11),res.getString(12),res.getString(13),res.getInt(14),res.getString(14));//res.getInt(1), res.getInt(3),res.getString(2),);

     
        }

     return pro;
  
  }
   public long sommeMontant(int id) throws SQLException{  
  String req="SELECT SUM(`montant`) FROM `investissement` WHERE `id_projet`=? ";
  ResultSet res;
  PreparedStatement pres=con.prepareStatement(req);
  pres.setInt(1, id);
res=pres.executeQuery();
    
long pro=0;
 while (res.next()) {   

     pro=res.getInt(1);
        }
     return pro;
  
  }
  
   public     XYChart.Series<String, Integer>  mesinvestisStat(int id) throws SQLException {
       
        String req =" SELECT p.nom_projet,i.montant FROM investissement i,projet p WHERE i.id_projet=P.id_projet and i.id_invesstisseur="+id+" order by i.montant desc limit 4";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                
                
                series.getData().add(new XYChart.Data<>(rs.getString("p.nom_projet"), rs.getInt("i.montant")));
            }
            //barChart.getData().add(series);
        
        return series;
       
   }
    public     XYChart.Series<String, Integer>  myprojStatic(int id) throws SQLException {
       
        String req =" SELECT SUM(i.montant)/1000 as mont , p.nom_projet as nom FROM projet p, investissement i WHERE i.id_projet=p.id_projet and p.id_entreprise="+id+" " +
"GROUP BY i.id_projet ";
        XYChart.Series<String, Integer> series = new XYChart.Series<String, Integer>();
        
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                
                
                series.getData().add(new XYChart.Data<>(rs.getString("nom"), rs.getInt("mont")));
            }
            //barChart.getData().add(series);
        
        return series;
       
   }
  
  
  
}