/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author p
 */
public class Entreprise {
    
    private int id;
    private String nom;
    private int secteur_id;
    private int taille;
    private int categorie_id;
    private String addresse;
    private String tel;

    public Entreprise() {
    }

    public Entreprise(String nom, int secteur_id, int taille, int categorie_id, String addresse, String tel) {
        this.nom = nom;
        this.secteur_id = secteur_id;
        this.taille = taille;
        this.categorie_id = categorie_id;
        this.addresse = addresse;
        this.tel = tel;
    }

    public Entreprise(int id, String nom, int secteur_id, int taille, int categorie_id, String addresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.secteur_id = secteur_id;
        this.taille = taille;
        this.categorie_id = categorie_id;
        this.addresse = addresse;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(int secteur_id) {
        this.secteur_id = secteur_id;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "id=" + id + ", nom=" + nom + ", secteur_id=" + secteur_id + ", taille=" + taille + ", categorie_id=" + categorie_id + ", addresse=" + addresse + ", tel=" + tel + '}';
    }
    
    
   
}
