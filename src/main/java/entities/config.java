/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import utils.crypter;
/**
 *
 * @author firos
 */
public class config {
   public static String getauth (){
      
       crypter b=new crypter();
       String a =b.encrypt("AC9ab48ebae0622c629adccf761e1c593e");
       return a;
}
   public static String getauthtoken (){
   crypter c=new crypter();
    String a =c.encrypt("ac147608d2fc4db2bfebf619d9db1c06");
       return a;
   
   }
   
}
