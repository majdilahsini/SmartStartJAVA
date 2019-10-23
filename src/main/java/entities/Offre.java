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
    private String date_publication;
    private int niveau_etude;
    private int langue_ref;
    private int type_post_id;
    private String description;
    
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

    public String getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(String date_publication) {
        this.date_publication = date_publication;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Offre(String titre, int domaine_id, int entreprise_id, String date_publication, int niveau_etude, int langue_ref, int type_post_id, String description) {
        this.titre = titre;
        this.domaine_id = domaine_id;
        this.entreprise_id = entreprise_id;
        this.date_publication = date_publication;
        this.niveau_etude = niveau_etude;
        this.langue_ref = langue_ref;
        this.type_post_id = type_post_id;
        this.description = description;
    }

    public Offre(int id, String titre, int domaine_id, int entreprise_id, String date_publication, int niveau_etude, int langue_ref, int type_post_id, String description) {
        this.id = id;
        this.titre = titre;
        this.domaine_id = domaine_id;
        this.entreprise_id = entreprise_id;
        this.date_publication = date_publication;
        this.niveau_etude = niveau_etude;
        this.langue_ref = langue_ref;
        this.type_post_id = type_post_id;
        this.description = description;
    }

    public Offre() {
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", domaine_id=" + domaine_id + ", entreprise_id=" + entreprise_id + ", date_publication=" + date_publication + ", niveau_etude=" + niveau_etude + ", langue_ref=" + langue_ref + ", type_post_id=" + type_post_id + ", description=" + description + '}';
    }
    
      
    
    
}
