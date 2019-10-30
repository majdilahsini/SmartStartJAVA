/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author radhwen
 */
public class Forum {

    public static void add(Forum o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int Id_user ;
    private int Id_commentaire ;
    private String nom;
    private String commentaire ;
    
    
    public Forum (){
        super();
    }
    
    public Forum (String commentaire){
        super();
        this.commentaire=commentaire;
        
    }
    
    public Forum( String nom , String commentaire){
        super();
        this.nom=nom;
        this.commentaire=commentaire;
    }
    
    public Forum(  String nom , int Id_commentaire ,String commentaire){
         super();
        this.nom=nom;
        this.commentaire=commentaire;
        this.Id_commentaire=Id_commentaire;
     
    }
    
     public Forum(int Id_user , int Id_commentaire , String nom , String commentaire){
        super();
        this.nom=nom;
        this.commentaire=commentaire;
        this.Id_commentaire=Id_commentaire;
        this.Id_user=Id_user;
    }

    public int getId_user() {
        return Id_user;
    }

    public int getId_commentaire() {
        return Id_commentaire;
    }

    public String getNom() {
        return nom;
    }
    

    public String getCommentaire() {
        return commentaire;
    }
    private static final Logger LOG = Logger.getLogger(Forum.class.getName());

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
    }

    public void setId_commentaire(int Id_commentaire) {
        this.Id_commentaire = Id_commentaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Forum other = (Forum) obj;
        if (this.Id_user != other.Id_user) {
            return false;
        }
        if (this.Id_commentaire != other.Id_commentaire) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.commentaire, other.commentaire)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Forum{" + "nom=" + nom + ", commentaire=" + commentaire + '}';
    }
    

     
   
    
    
    
}
