/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Sadbo
 */
public class Candidat {
   
    private String fullname;
    private String tel;
    private String email;
    private double match;
    private int skill1;
    private int skill2;
    private int skill3;
    private int langue1;
    private int langue2;
    private int id;

    public Candidat(String fullname, String tel, String email, double match, int skill1, int skill2, int skill3, int langue1, int langue2, int id) {
        this.fullname = fullname;
        this.tel = tel;
        this.email = email;
        this.match = match;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.langue1 = langue1;
        this.langue2 = langue2;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    

    public Candidat() {
       
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMatch() {
        return match;
    }

    public void setMatch(double match) {
        this.match = match;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getLangue1() {
        return langue1;
    }

    public void setLangue1(int langue1) {
        this.langue1 = langue1;
    }

    public int getLangue2() {
        return langue2;
    }

    public void setLangue2(int langue2) {
        this.langue2 = langue2;
    }
    
}
