/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author firos
 */
public class Certificats {
    private int id;
    private String nom_certif;
    private String nom_formateur;
    private String nom_entreprise;
    private String domaine;
    private String description;
    private String date_obtention;

    public Certificats() {
    }
    public Certificats(int id,String nom_certif,String nom_formateur,String nom_entreprise,String domaine,String description,String date_obtention)
    {
    this.id=id;
    this.nom_certif=nom_certif;
    this.nom_formateur=nom_formateur;
    this.nom_entreprise=nom_entreprise;
    this.domaine=domaine;
    this.description=description;
    this.date_obtention=date_obtention;
    }
     public Certificats(String nom_certif,String nom_formateur,String nom_entreprise,String domaine,String description,String date_obtention)
    {

    this.nom_certif=nom_certif;
    this.nom_formateur=nom_formateur;
    this.nom_entreprise=nom_entreprise;
    this.domaine=domaine;
    this.description=description;
    this.date_obtention=date_obtention;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_certif() {
        return nom_certif;
    }

    public void setNom_certif(String nom_certif) {
        this.nom_certif = nom_certif;
    }

    public String getNom_formateur() {
        return nom_formateur;
    }

    public void setNom_formateur(String nom_formateur) {
        this.nom_formateur = nom_formateur;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_obtention() {
        return date_obtention;
    }

    public void setDate_obtention(String date_obtention) {
        this.date_obtention = date_obtention;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nom_certif);
        hash = 59 * hash + Objects.hashCode(this.nom_formateur);
        hash = 59 * hash + Objects.hashCode(this.nom_entreprise);
        hash = 59 * hash + Objects.hashCode(this.domaine);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.date_obtention);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Certificats other = (Certificats) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom_certif, other.nom_certif)) {
            return false;
        }
        if (!Objects.equals(this.nom_formateur, other.nom_formateur)) {
            return false;
        }
        if (!Objects.equals(this.nom_entreprise, other.nom_entreprise)) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_obtention, other.date_obtention)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certificats{" + "id=" + id + ", nom_certif=" + nom_certif + ", nom_formateur=" + nom_formateur + ", nom_entreprise=" + nom_entreprise + ", domaine=" + domaine + ", description=" + description + ", date_obtention=" + date_obtention + '}';
    }
     
   
    
}
