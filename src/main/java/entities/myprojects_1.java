/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ASUS
 */
public class myprojects_1 {
    private StringProperty nomprojet;
    private StringProperty categorie;
   
    
 
    private StringProperty dateDebutProjet;
    private StringProperty adresseProjet;
   
    private StringProperty descriptionProjet;
     private StringProperty emailProjet;

    public myprojects_1(String nomprojet, String categorie, String dateDebutProjet, String adresseProjet, String descriptionProjet, String emailProjet) {
        this.nomprojet = new SimpleStringProperty(nomprojet);
        this.categorie =  new SimpleStringProperty(categorie);
        this.dateDebutProjet = new SimpleStringProperty(dateDebutProjet);
        this.adresseProjet = new SimpleStringProperty(adresseProjet);
        this.descriptionProjet =new SimpleStringProperty( descriptionProjet);
        this.emailProjet = new SimpleStringProperty(emailProjet);
    }

    @Override
    public String toString() {
        return "myprojects{" + "nomprojet=" + nomprojet + ", categorie=" + categorie + ", dateDebutProjet=" + dateDebutProjet + ", adresseProjet=" + adresseProjet + ", descriptionProjet=" + descriptionProjet + ", emailProjet=" + emailProjet + '}';
    }

    public String getNomprojet() {
        return nomprojet.get();
    }

    public String getCategorie() {
        return categorie.get();
    }

    public String getDateDebutProjet() {
        return dateDebutProjet.get();
    }

    public String getAdresseProjet() {
        return adresseProjet.get();
    }

    public String getDescriptionProjet() {
        return descriptionProjet.get();
    }

    public String getEmailProjet() {
        return emailProjet.get();
    }

    public void setNomprojet(StringProperty nomprojet) {
        this.nomprojet = nomprojet;
    }

    public void setCategorie(StringProperty categorie) {
        this.categorie = categorie;
    }

    public void setDateDebutProjet(StringProperty dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public void setAdresseProjet(StringProperty adresseProjet) {
        this.adresseProjet = adresseProjet;
    }

    public void setDescriptionProjet(StringProperty descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public void setEmailProjet(StringProperty emailProjet) {
        this.emailProjet = emailProjet;
    }

    

    
}
