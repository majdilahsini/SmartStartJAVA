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
public class Userskill {
    
    private int id;
    private int user_id;
    private int skill_id;

    public Userskill() {
    }

    public Userskill(int user_id, int skill_id) {
        this.user_id = user_id;
        this.skill_id = skill_id;
    }

    public Userskill(int id, int user_id, int skill_id) {
        this.id = id;
        this.user_id = user_id;
        this.skill_id = skill_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    @Override
    public String toString() {
        return "Userskills{" + "id=" + id + ", user_id=" + user_id + ", skill_id=" + skill_id + '}';
    }
    
    
    
}
