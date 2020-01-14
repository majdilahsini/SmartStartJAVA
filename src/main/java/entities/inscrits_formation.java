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
public class inscrits_formation {
    private String Nom ;
   
    private int telephone ;
    private String Nom_formation ;
    private String lettre_motivation ;

    public inscrits_formation(String Nom, int telephone, String Nom_formation, String lettre_motivation) {
        this.Nom = Nom;
        this.telephone = telephone;
        this.Nom_formation = Nom_formation;
        this.lettre_motivation = lettre_motivation;
    }

    public inscrits_formation() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNom_formation() {
        return Nom_formation;
    }

    public void setNom_formation(String Nom_formation) {
        this.Nom_formation = Nom_formation;
    }

    public String getLettre_motivation() {
        return lettre_motivation;
    }

    public void setLettre_motivation(String lettre_motivation) {
        this.lettre_motivation = lettre_motivation;
    }

    @Override
    public String toString() {
        return "inscrits_formation{" + "Nom=" + Nom + ", telephone=" + telephone + ", Nom_formation=" + Nom_formation + ", lettre_motivation=" + lettre_motivation + '}';
    }
    

}