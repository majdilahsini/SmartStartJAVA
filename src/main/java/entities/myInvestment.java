/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ASUS
 */
public class myInvestment {
    private StringProperty nomprojet;
    private StringProperty NomInvestisseur;
   
    private StringProperty montant;
    private StringProperty comptebancaire;

    public myInvestment() {
    }

    public myInvestment(String nomprojet , String NomInvestisseur, String montant, String comptebancaire) {
        this.nomprojet = new SimpleStringProperty (nomprojet);
        this.NomInvestisseur = new SimpleStringProperty (NomInvestisseur);
        this.montant = new SimpleStringProperty (montant);
        this.comptebancaire = new SimpleStringProperty (comptebancaire);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final myInvestment other = (myInvestment) obj;
        if (!Objects.equals(this.nomprojet, other.nomprojet)) {
            return false;
        }
        if (!Objects.equals(this.NomInvestisseur, other.NomInvestisseur)) {
            return false;
        }
        if (!Objects.equals(this.montant, other.montant)) {
            return false;
        }
        if (!Objects.equals(this.comptebancaire, other.comptebancaire)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "myInvestment{" + "nomprojet=" + nomprojet + ", NomInvestisseur=" + NomInvestisseur + ", montant=" + montant + ", comptebancaire=" + comptebancaire + '}';
    }

    public String getNomprojet() {
        return nomprojet.get();
    }

    public String getNomInvestisseur() {
        return NomInvestisseur.get();
    }

    public String getMontant() {
        return montant.get();
    }

    public String getComptebancaire() {
        return comptebancaire.get();
    }

    public void setNomprojet(StringProperty nomprojet) {
        this.nomprojet = nomprojet;
    }

    public void setNomInvestisseur(StringProperty NomInvestisseur) {
        this.NomInvestisseur = NomInvestisseur;
    }

    public void setMontant(StringProperty montant) {
        this.montant = montant;
    }

    public void setComptebancaire(StringProperty comptebancaire) {
        this.comptebancaire = comptebancaire;
    }
   
    
}
