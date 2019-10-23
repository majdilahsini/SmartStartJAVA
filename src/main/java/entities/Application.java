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
public class Application {
    
    private int id;
    private int offre_id;
    private int user_id;
    private String lettre_motivation;

    public Application(int offre_id, int user_id, String lettre_motivation) {
        this.offre_id = offre_id;
        this.user_id = user_id;
        this.lettre_motivation = lettre_motivation;
    }

    public Application(int id, int offre_id, int user_id, String lettre_motivation) {
        this.id = id;
        this.offre_id = offre_id;
        this.user_id = user_id;
        this.lettre_motivation = lettre_motivation;
    }

    public Application() {
      
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getOffre_id() {
        return offre_id;
    }

    public void setOffre_id(int offre_id) {
        this.offre_id = offre_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLettre_motivation() {
        return lettre_motivation;
    }

    public void setLettre_motivation(String lettre_motivation) {
        this.lettre_motivation = lettre_motivation;
    }

    @Override
    public String toString() {
        return "Application{" + "id=" + id + ", offre_id=" + offre_id + ", user_id=" + user_id + ", lettre_motivation=" + lettre_motivation + '}';
    }
    
    
}
