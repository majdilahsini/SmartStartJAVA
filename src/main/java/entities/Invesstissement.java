/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Invesstissement{
  private  int id_investissement;
  private  int montant;
  private  int numcarteBancaire;
  private  int id_projet;
  private  int id_invesstisseur;

    public Invesstissement(int montant, int numcarteBancaire, int id_projet, int id_invesstisseur) {
        this.montant = montant;
        this.numcarteBancaire = numcarteBancaire;
        this.id_projet = id_projet;
        this.id_invesstisseur = id_invesstisseur;
    }

    public Invesstissement(int id_investissement, int montant, int numcarteBancaire, int id_projet, int id_invesstisseur) {
        this.id_investissement = id_investissement;
        this.montant = montant;
        this.numcarteBancaire = numcarteBancaire;
        this.id_projet = id_projet;
        this.id_invesstisseur = id_invesstisseur;
    }

    public void setId_investissement(int id_investissement) {
        this.id_investissement = id_investissement;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setNumcarteBancaire(int numcarteBancaire) {
        this.numcarteBancaire = numcarteBancaire;
    }

    public void setId_projet(int id_projet) {
        this.id_projet = id_projet;
    }

    public void setId_invesstisseur(int id_invesstisseur) {
        this.id_invesstisseur = id_invesstisseur;
    }

    public Invesstissement() {
    }

    public int getId_investissement() {
        return id_investissement;
    }

    public int getMontant() {
        return montant;
    }

    public int getNumcarteBancaire() {
        return numcarteBancaire;
    }

    public int getId_projet() {
        return id_projet;
    }

    public int getId_invesstisseur() {
        return id_invesstisseur;
    }

    @Override
    public String toString() {
        return "Invesstissement{" + "id_investissement=" + id_investissement + ", montant=" + montant + ", numcarteBancaire=" + numcarteBancaire + ", id_projet=" + id_projet + ", id_invesstisseur=" + id_invesstisseur + '}';
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
        final Invesstissement other = (Invesstissement) obj;
        if (this.id_investissement != other.id_investissement) {
            return false;
        }
        if (this.montant != other.montant) {
            return false;
        }
        if (this.numcarteBancaire != other.numcarteBancaire) {
            return false;
        }
        if (this.id_projet != other.id_projet) {
            return false;
        }
        if (this.id_invesstisseur != other.id_invesstisseur) {
            return false;
        }
        return true;
    }

 
}
