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
    
    private int user_id;
    private int skill1_id;
    private int skill2_id;
    private int skill3_id;

    public Userskill() {
    }

    public Userskill(int user_id, int skill1_id, int skill2_id, int skill3_id) {
        this.user_id = user_id;
        this.skill1_id = skill1_id;
        this.skill2_id = skill2_id;
        this.skill3_id = skill3_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    
    
    
    
}
