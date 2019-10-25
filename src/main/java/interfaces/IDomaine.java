/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Formation;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IDomaine {
   public int getDomaineByID(String nom);
    public List<String> getFormationType();
}
