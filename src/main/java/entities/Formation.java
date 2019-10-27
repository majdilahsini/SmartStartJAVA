/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.sql.Timestamp;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;



/**
 *
 * @author lenovo
 */
public class Formation {
    private int ref ;
    private int domaine_id ;
    private String Nom ;
    private int entreprise_id;
    private String prérequis ;
    private String description ;
    private int duree ; 
    private Date date_debut ;
    private Date date_fin;
    private String adresse ;
    private double prix ;
    private int Contact ;
    private String email ;
private String image ;
       Timestamp time_event;


     private ImageView imgview;

    public Formation(String image) {
        this.image = image;
    }

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public Formation(int ref, int domaine_id, String Nom, int entreprise_id, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.entreprise_id = entreprise_id;
        this.prérequis = prérequis;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
    }

    public Formation(int ref, int domaine_id, String Nom, int entreprise_id, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image, Timestamp time_event, ImageView imgview) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.entreprise_id = entreprise_id;
        this.prérequis = prérequis;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
        this.time_event = time_event;
        this.imgview = imgview;
    }

    public Formation(int domaine_id, String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin,double prix, String adresse, int Contact, String email) {
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.prérequis = prérequis;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix = prix;
        this.adresse = adresse;
        this.Contact = Contact;
        this.email = email;
    }

    public Formation(String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image, Timestamp time_event, ImageView imgview) {
        this.Nom = Nom;
        this.prérequis = prérequis;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
        this.time_event = time_event;
        this.imgview = imgview;
    }

    public Formation(String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image) {
        this.Nom = Nom;
        this.prérequis = prérequis;
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

    public Formation(String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email) {
        this.Nom = Nom;
        this.prérequis = prérequis;
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
private Button button1=new Button("Consulter");
    private Button button2=new Button("Supprimer");
    private Button button3=new Button("Modifier");
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

    public Timestamp getTime_event() {
        return time_event;
    }

    public void setTime_event(Timestamp time_event) {
        this.time_event = time_event;
    }

    public Formation(int ref, int domaine_id, String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image, Timestamp time_event, ImageView imgview) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.prérequis = prérequis;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.adresse = adresse;
        this.prix = prix;
        this.Contact = Contact;
        this.email = email;
        this.image = image;
        this.time_event = time_event;
        this.imgview = imgview;
    }

    public Formation(int ref, int domaine_id, String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image) {
        this.ref = ref;
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.prérequis = prérequis;
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

    public Formation(int domaine_id, String Nom, String prérequis, String description, int duree, Date date_debut, Date date_fin, String adresse, double prix, int Contact, String email, String image) {
        this.domaine_id = domaine_id;
        this.Nom = Nom;
        this.prérequis = prérequis;
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

    public String getPrérequis() {
        return prérequis;
    }

    public void setPrérequis(String prérequis) {
        this.prérequis = prérequis;
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

    @Override
    public String toString() {
        return "Formation{" + "ref=" + ref + ", domaine_id=" + domaine_id + ", Nom=" + Nom + ", pr\u00e9requis=" + prérequis + ", description=" + description + ", duree=" + duree + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", adresse=" + adresse + ", prix=" + prix + ", Contact=" + Contact + ", email=" + email + ", image=" + image + '}';
    }

}
