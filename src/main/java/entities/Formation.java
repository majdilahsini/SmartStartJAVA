/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author lenovo
 */
public class Formation {
    private int ref ;
    private int domaine_id ;
    private String Nom ;
    private String description ;
    private int duree ; 
    private Date date_debut ;
    private Date date_fin;
    private String adresse ;
    private double prix ;
    private int Contact ;
    private String email ;
    private String image ;
    private int entreprise_id;

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public Formation(String Nom, int duree, Date date_debut, Date date_fin) {
        this.Nom = Nom;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public Formation(int domaine_id, String Nom, String description, int duree, Date date_debut, Date date_fin,double prix,String adresse,String email, int Contact,  String image) {
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
    }

    public Formation(int ref, int domaine_id, String Nom, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image, int entreprise_id, ImageView imgview) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
        this.entreprise_id = entreprise_id;
        this.imgview = imgview;
    }


     private ImageView imgview;
     
     private Button button1=new Button("Consulter");
    private Button button2=new Button("Supprimer");
    private Button button3=new Button("Modifier");

    public Formation(String image) {
        this.image = image;
    }

    public Formation(int ref, int domaine_id, String Nom, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image, ImageView imgview) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
        this.imgview = imgview;
    }

    public Formation(int ref, int domaine_id, String Nom, String description, int duree, Date date_debut, Date date_fin,double prix,String adresse,String email, int Contact ) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
    }

    public Formation(int domaine_id, String Nom, String description, int duree, Date date_debut, Date date_fin, double prix,String adresse, String email,  int Contact) {
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
    }
    
    
  
   

    

    

    

    

   

     
     
    public ImageView getImgview() {
        return imgview;
    }

    public void setImgview(ImageView imgview) {
        this.imgview = imgview;
    }

    public Formation() {
        
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

   
    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getDomaine_id() {
        return domaine_id;
    }

    public void setDomaine_id(int domaine_id) {
        this.domaine_id = domaine_id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

 /*    public static List<Formation> generateImageViews(List<Formation> animals) {
        List<Formation> liste = new ArrayList<Formation>();

        for (Formation animal : animals) {
            File f = new File("C:\\wamp64\\www\\image\\"+animal.getImage());
            //System.out.println(animal.getImage());
            animal.setImgview(new ImageView(new Image(f.toURI().toString())));
            liste.add(animal);
        }
        return liste;
    }*/

}
