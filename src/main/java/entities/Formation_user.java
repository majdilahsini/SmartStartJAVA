/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author lenovo
 */
public class Formation_user {
    private String Nom_formation ;
    private String domaine;
    private Date date_debut ;
    private Date date_fin ;
    private int duree ;

    public Formation_user() {
    }

    public Formation_user(String Nom_formation, String domaine, Date date_debut, Date date_fin, int duree) {
        this.Nom_formation = Nom_formation;
        this.domaine = domaine;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.duree = duree;
    }

    public String getNom_formation() {
        return Nom_formation;
    }

    public void setNom_formation(String Nom_formation) {
        this.Nom_formation = Nom_formation;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
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

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Formation_user{" + "Nom_formation=" + Nom_formation + ", domaine=" + domaine + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", duree=" + duree + '}';
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
        final Formation_user other = (Formation_user) obj;
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.Nom_formation, other.Nom_formation)) {
            return false;
        }
        if (!Objects.equals(this.domaine, other.domaine)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    public void deleteEnt(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
