/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author p
 */
public class Offre {
    
    private int id;
    private String titre;
    private int domaine_id;
    private int entreprise_id;
    private int niveau_etude;
    private int langue_ref;
    private int type_post_id;
    private int skill1_id;
    private int skill2_id;
    private int skill3_id;
    private int salaire;
    private String date_publication;
    private String photdeloffre;

    public String getPhotdeloffre() {
        return photdeloffre;
    }

    public void setPhotdeloffre(String photdeloffre) {
        this.photdeloffre = photdeloffre;
    }

    
    
    

    public String getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
    }
 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getDomaine_id() {
        return domaine_id;
    }

    public void setDomaine_id(int domaine_id) {
        this.domaine_id = domaine_id;
    }

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public int getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(int niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public int getLangue_ref() {
        return langue_ref;
    }

    public void setLangue_ref(int langue_ref) {
        this.langue_ref = langue_ref;
    }

    public int getType_post_id() {
        return type_post_id;
    }

    public void setType_post_id(int type_post_id) {
        this.type_post_id = type_post_id;
    }

     public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getSkill1_id() {
        return skill1_id;
    }

    public void setSkill1_id(int skill1_id) {
        this.skill1_id = skill1_id;
    }

    public int getSkill2_id() {
        return skill2_id;
    }

    public void setSkill2_id(int skill2_id) {
        this.skill2_id = skill2_id;
    }

    public int getSkill3_id() {
        return skill3_id;
    }

    public void setSkill3_id(int skill3_id) {
        this.skill3_id = skill3_id;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public Offre(int id, String titre, int domaine_id, int entreprise_id, int niveau_etude, int langue_ref, int type_post_id, int skill1_id, int skill2_id, int skill3_id, int salaire, String photdeloffre) {
        this.id = id;
        this.titre = titre;
        this.domaine_id = domaine_id;
        this.entreprise_id = entreprise_id;
        this.niveau_etude = niveau_etude;
        this.langue_ref = langue_ref;
        this.type_post_id = type_post_id;
        this.skill1_id = skill1_id;
        this.skill2_id = skill2_id;
        this.skill3_id = skill3_id;
        this.salaire = salaire;
        this.photdeloffre = photdeloffre;
    }

    public Offre(String titre, int domaine_id, int entreprise_id, int niveau_etude, int langue_ref, int type_post_id, int skill1_id, int skill2_id, int skill3_id, int salaire, String photdeloffre) {
        this.titre = titre;
        this.domaine_id = domaine_id;
        this.entreprise_id = entreprise_id;
        this.niveau_etude = niveau_etude;
        this.langue_ref = langue_ref;
        this.type_post_id = type_post_id;
        this.skill1_id = skill1_id;
        this.skill2_id = skill2_id;
        this.skill3_id = skill3_id;
        this.salaire = salaire;
        this.photdeloffre = photdeloffre;
    }

    
    public Offre() {
    }
    
       
    
    
    
      
    
    
}
