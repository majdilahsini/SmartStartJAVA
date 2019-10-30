/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author User
 */
public class Entretien {
   
    private SimpleIntegerProperty ref_ent ;
    private SimpleIntegerProperty id_entreprise;
    private SimpleIntegerProperty id_user;
        private SimpleIntegerProperty id_condidat;

    private SimpleStringProperty poste_ent ;
    private SimpleStringProperty  date_ent;
    private SimpleStringProperty heure_ent;
    private SimpleStringProperty  description_ent;
    
    
    private SimpleStringProperty  nom_ent;
    private SimpleStringProperty  nom_user;
    private SimpleStringProperty  prenom_user;

    public Entretien() {
}
    
/*    private int ref_ent ;
    private int id_entreprise;
    private int id_user;
    private String poste_ent ;
    private String date_ent;
    private int heure_ent;
    private String description_ent;*/
    

/*
    public Entretien(int ref_ent, int id_entreprise, int id_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.ref_ent = ref_ent;
        this.id_entreprise = id_entreprise;
        this.id_user = id_user;
        this.poste_ent = poste_ent;
        this.date_ent = date_ent;
        this.heure_ent = heure_ent;
        this.description_ent = description_ent;
    }
        public Entretien( int id_entreprise, int id_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.id_entreprise = id_entreprise;
        this.id_user = id_user;
        this.poste_ent = poste_ent;
        this.date_ent = date_ent;
        this.heure_ent = heure_ent;
        this.description_ent = description_ent;
    }

    public void setDate_ent(String date_ent) {
        this.date_ent = date_ent;
    }

    public String getDate_ent() {
        return date_ent;
    }

    

    

    

    public String getDescription_ent() {
        return description_ent;
    }

    

    public String getHeure_ent() {
        return heure_ent;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public int getId_user() {
        return id_user;
    }

    public int getRef_ent() {
        return ref_ent;
    }

    public String getPoste_ent() {
        return poste_ent;
    }

    public void setPoste_ent(String poste_ent) {
        this.poste_ent = poste_ent;
    }

    public void setDescription_ent(String description_ent) {
        this.description_ent = description_ent;
    }

   
 

   
  

    public void setHeure_ent(String heure_ent) {
        this.heure_ent = heure_ent;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

   

    public void setRef_ent(int ref_ent) {
        this.ref_ent = ref_ent;
    }*/
/*
    @Override
    public String toString() {return "Entretien{" + "ref_ent=" + ref_ent 
            + ", id_entreprise=" + id_entreprise + ", id_user=" 
            + id_user + ", poste_ent=" + poste_ent + ", date_ent=" 
            + date_ent + ", heure_ent=" +heure_ent+ ", description_ent=" +description_ent + '}'; }
*/

    public Entretien(int ref_ent, int id_entreprise, int id_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.ref_ent = new SimpleIntegerProperty(ref_ent);
        this.id_entreprise = new SimpleIntegerProperty(id_entreprise);
        this.id_user = new SimpleIntegerProperty(id_user);
        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
    public Entretien(String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
      /*  public Entretien(int id_entreprise, int id_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.id_entreprise = new SimpleIntegerProperty(id_entreprise);
        this.id_user = new SimpleIntegerProperty(id_user);
        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }*/
        
                public Entretien(int id_entreprise, int id_condidat, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.id_entreprise = new SimpleIntegerProperty(id_entreprise);
        this.id_condidat = new SimpleIntegerProperty(id_condidat);
        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
        
                public Entretien(int ref_ent,String nom_ent,String nom_user,String prenom_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {

                    this.ref_ent = new SimpleIntegerProperty(ref_ent);
                            this.poste_ent = new SimpleStringProperty(poste_ent);
        this.nom_ent = new SimpleStringProperty(nom_ent);
        this.nom_user = new SimpleStringProperty(nom_user);
        this.prenom_user = new SimpleStringProperty(prenom_user);

        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
                 public Entretien(String nom_ent,String nom_user,String poste_ent, String date_ent, String heure_ent, String description_ent) {
  this.nom_ent = new SimpleStringProperty(nom_ent);
        this.nom_user = new SimpleStringProperty(nom_user);
         this.poste_ent = new SimpleStringProperty(poste_ent);
      

        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
 public Entretien(int ref_ent,String nom_ent,String nom_user,String poste_ent, String date_ent, String heure_ent, String description_ent) {
                     this.ref_ent = new SimpleIntegerProperty(ref_ent);

     this.nom_ent = new SimpleStringProperty(nom_ent);
        this.nom_user = new SimpleStringProperty(nom_user);
         this.poste_ent = new SimpleStringProperty(poste_ent);
      

        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }

    public void setPoste_ent(String poste_ent) {
        this.poste_ent = new SimpleStringProperty(poste_ent);
    }
   

    public void setRef_ent(int ref_ent) {
        this.ref_ent = new SimpleIntegerProperty(ref_ent);
    }



    public void setDescription_ent(String description_ent) {
        this.description_ent = new SimpleStringProperty(description_ent);
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = new SimpleIntegerProperty (id_entreprise);
    }

    public void setId_user(int id_user) {
        this.id_user = new SimpleIntegerProperty(id_user);
    }

    public void setHeure_ent(String heure_ent) {
        this.heure_ent = new SimpleStringProperty(heure_ent);
    }

    public void setDate_ent(String date_ent) {
        this.date_ent = new SimpleStringProperty(date_ent);
    }

        public void setId_condidat(Integer id_condidat) {
        this.id_condidat = new SimpleIntegerProperty(id_condidat);
    }
        
    public Integer getId_user() {
        return id_user.get();
    }
     public SimpleIntegerProperty getId_userProperty(){
        return id_user;
    }
    
         public Integer getId_condidat() {
        return id_condidat.get();
    }
     

    public String getPoste_ent() {
        return poste_ent.get();
    }
 public SimpleStringProperty getposte_entProperty(){
        return poste_ent;
    }
    public Integer getRef_ent() {
        return ref_ent.get();
    }
 public SimpleIntegerProperty getref_entProperty(){
        return ref_ent;
    }
 



     
    public String getDescription_ent() {
        return description_ent.get();
    }
 public SimpleStringProperty getdescription_entProperty(){
        return description_ent;
    }
    public String getHeure_ent() {
        return heure_ent.get();
    }
 public SimpleStringProperty getHeure_entProperty(){
        return heure_ent;
    }
    public Integer getId_entreprise() {
        return id_entreprise.get();
    }
       

    
 public SimpleIntegerProperty getid_entrepriseProperty(){
        return id_entreprise;
    }
    public String getDate_ent() {
        return date_ent.get();
    }
     public SimpleStringProperty getdate_entProperty(){
        return date_ent;
    }

    private StringProperty SimpleStringProperty(String ref_ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SimpleStringProperty getNom_entProperty() {
        return nom_ent;
    }

    public String getPrenom_user() {
        return prenom_user.get();
    }

    public String getNom_user() {
        return nom_user.get();
    }

    public String getNom_ent() {
        return nom_ent.get();
    }

   
    

    public SimpleStringProperty getNom_userProperty() {
        return nom_user;
    }

    public SimpleStringProperty getPrenom_userProperty() {
        return prenom_user;
    }

    public void setNom_ent(String nom_ent) {
                this.nom_ent = new SimpleStringProperty(nom_ent);
    }

    public void setNom_user(String nom_user) {
                this.nom_user = new SimpleStringProperty(nom_user);
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = new SimpleStringProperty(prenom_user);

    }
    
        public Entretien(String nom_ent,String nom_user,String prenom_user, String poste_ent, String date_ent, String heure_ent, String description_ent) {
        this.nom_ent = new SimpleStringProperty(nom_ent);
        this.nom_user = new SimpleStringProperty(nom_user);
        this.prenom_user = new SimpleStringProperty(prenom_user);
        this.poste_ent = new SimpleStringProperty(poste_ent);
        this.date_ent = new SimpleStringProperty(date_ent);
        this.heure_ent = new SimpleStringProperty(heure_ent);
        this.description_ent = new SimpleStringProperty(description_ent);
    }
 
}
  