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
public class Userlangues {
    
    private int user_id;
    private int langue1_id;
    private int langue2_id;

    public Userlangues() {
    }

    public Userlangues(int user_id, int langue1_id, int langue2_id) {
        this.user_id = user_id;
        this.langue1_id = langue1_id;
        this.langue2_id = langue2_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLangue1_id() {
        return langue1_id;
    }

    public void setLangue1_id(int langue1_id) {
        this.langue1_id = langue1_id;
    }

    public int getLangue2_id() {
        return langue2_id;
    }

    public void setLangue2_id(int langue2_id) {
        this.langue2_id = langue2_id;
    }

    

    
    
    
    
}
