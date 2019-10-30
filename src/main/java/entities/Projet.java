package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Projet {
     private   int idProjet;
    private String nomprojet;
    private String categorie;
   
    private int votreFinance;
   
    private long montant;
    private long compteBancaire;
    private int duree;
 
    private String dateDebutProjet;
    private String adresseProjet;
    private int telProjet;
    private int nbreTeam;
    private String descriptionProjet;
     private String emailProjet;
     private int id_enterprise;
private String image;
    public Projet() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Projet(int idProjet, String nomprojet, String categorie, int votreFinance, long montant, long compteBancaire, int duree, String dateDebutProjet, String adresseProjet, int telProjet, int nbreTeam, String descriptionProjet, String emailProjet, int id_enterprise, String image) {
        this.idProjet = idProjet;
        this.nomprojet = nomprojet;
        this.categorie = categorie;
        this.votreFinance = votreFinance;
        this.montant = montant;
        this.compteBancaire = compteBancaire;
        this.duree = duree;
        this.dateDebutProjet = dateDebutProjet;
        this.adresseProjet = adresseProjet;
        this.telProjet = telProjet;
        this.nbreTeam = nbreTeam;
        this.descriptionProjet = descriptionProjet;
        this.emailProjet = emailProjet;
        this.id_enterprise = id_enterprise;
        this.image = image;
    }

   

   

    public void setId_enterprise(int id_enterprise) {
        this.id_enterprise = id_enterprise;
    }

    public int getId_enterprise() {
        return id_enterprise;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public void setEmailProjet(String emailProjet) {
        this.emailProjet = emailProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public String getEmailProjet() {
        return emailProjet;
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
        final Projet other = (Projet) obj;
        if (this.idProjet != other.idProjet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Projet{" + "idProjet=" + idProjet + ", nomprojet=" + nomprojet + ", categorie=" + categorie + ", votreFinance=" + votreFinance + ", montant=" + montant + ", compteBancaire=" + compteBancaire + ", duree=" + duree + ", dateDebutProjet=" + dateDebutProjet + ", adresseProjet=" + adresseProjet + ", telProjet=" + telProjet + ", nbreTeam=" + nbreTeam + ", descriptionProjet=" + descriptionProjet + ", emailProjet=" + emailProjet + ", id_enterprise=" + id_enterprise + '}';
    }

    public Projet(String nomprojet, String categorie, String adresseProjet, int telProjet, String descriptionProjet, String emailProjet, int id_enterprise) {
       
        this.nomprojet = nomprojet;
        this.categorie = categorie;
        this.votreFinance = 0;
        this.montant = 0;
        this.compteBancaire = 0;
        this.duree = 0;
        this.dateDebutProjet = null;
        this.adresseProjet = adresseProjet;
        this.telProjet = telProjet;
        this.nbreTeam = 0;
        this.descriptionProjet = descriptionProjet;
        this.emailProjet = emailProjet;
        this.id_enterprise = id_enterprise;
    }

    public Projet(String nomprojet, String categorie, int votreFinance, int montant, int compteBancaire, int duree, String dateDebutProjet, String adresseProjet, int telProjet, int nbreTeam, String descriptionProjet, String emailProjet, int id_enterprise) {
        this.nomprojet = nomprojet;
        this.categorie = categorie;
        this.votreFinance = votreFinance;
        this.montant = montant;
        this.compteBancaire = compteBancaire;
        this.duree = duree;
        this.dateDebutProjet = dateDebutProjet;
        this.adresseProjet = adresseProjet;
        this.telProjet = telProjet;
        this.nbreTeam = nbreTeam;
        this.descriptionProjet = descriptionProjet;
        this.emailProjet = emailProjet;
        this.id_enterprise = id_enterprise;
    }

    public Projet(int idProjet, String nomprojet, String categorie, int votreFinance, long montant, long compteBancaire, int duree, String dateDebutProjet, String adresseProjet, int telProjet, int nbreTeam, String descriptionProjet, String emailProjet, int id_enterprise) {
        this.idProjet = idProjet;
        this.nomprojet = nomprojet;
        this.categorie = categorie;
        this.votreFinance = votreFinance;
        this.montant = montant;
        this.compteBancaire = compteBancaire;
        this.duree = duree;
        this.dateDebutProjet = dateDebutProjet;
        this.adresseProjet = adresseProjet;
        this.telProjet = telProjet;
        this.nbreTeam = nbreTeam;
        this.descriptionProjet = descriptionProjet;
        this.emailProjet = emailProjet;
        this.id_enterprise = id_enterprise;
    }

   
    

    

    

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setNomprojet(String nomprojet) {
        this.nomprojet = nomprojet;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    

    public void setVotreFinance(int votreFinance) {
        this.votreFinance = votreFinance;
    }

   
    public void setMontant(long montant) {
        this.montant = montant;
    }

    public void setCompteBancaire(long compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    

    public void setDateDebutProjet(String dateDebutProjet) {
        this.dateDebutProjet = dateDebutProjet;
    }

    public void setAdresseProjet(String adresseProjet) {
        this.adresseProjet = adresseProjet;
    }

    public void setTelProjet(int telProjet) {
        this.telProjet = telProjet;
    }

    public void setNbreTeam(int nbreTeam) {
        this.nbreTeam = nbreTeam;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public String getNomprojet() {
        return nomprojet;
    }

    public String getCategorie() {
        return categorie;
    }

   

    public int getVotreFinance() {
        return votreFinance;
    }

   
    public long getMontant() {
        return montant;
    }

    public long getCompteBancaire() {
        return compteBancaire;
    }

    public int getDuree() {
        return duree;
    }

   
    public String getDateDebutProjet() {
        return dateDebutProjet;
    }

    public String getAdresseProjet() {
        return adresseProjet;
    }

    public int getTelProjet() {
        return telProjet;
    }

    public int getNbreTeam() {
        return nbreTeam;
    }

    public Projet(String nomprojet, String categorie, String dateDebutProjet, String adresseProjet, String descriptionProjet) {
        this.nomprojet = nomprojet;
        this.categorie = categorie;
        this.dateDebutProjet = dateDebutProjet;
        this.adresseProjet = adresseProjet;
        this.descriptionProjet = descriptionProjet;
    }
    
}
