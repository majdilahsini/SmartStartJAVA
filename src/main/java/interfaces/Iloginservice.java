/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.login;

/**
 *
 * @author firos
 */
public interface Iloginservice {
    public String  validerLogin(String username, String password  );
     public login getUtilisaeur(int id);
    
}
