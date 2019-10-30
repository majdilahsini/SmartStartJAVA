/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author firos
 */
public class crypter {
    
     public static String encrypt(String password){
        String crypte= "";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)+2; 
            crypte=crypte+(char)c;
        }
        return crypte;
    }   
    public static String decrypt(String password){
        String aCrypter="";
        for (int i=0; i<password.length();i++)  {
            int c=password.charAt(i)-2; 
            aCrypter=aCrypter+(char)c;
        }
        return aCrypter;
    }
    
}
