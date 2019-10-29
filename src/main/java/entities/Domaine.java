/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lenovo
 */
public class Domaine {
    
    int id ;
    String nom_domaine;

    public Domaine(int id, String nom_domaine) {
        this.id = id;
        this.nom_domaine = nom_domaine;
    }

    public Domaine() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_domaine() {
        return nom_domaine;
    }

    public void setNom_domaine(String nom_domaine) {
        this.nom_domaine = nom_domaine;
    }

    public Domaine(String nom_domaine) {
        this.nom_domaine = nom_domaine;
    }
    

}
