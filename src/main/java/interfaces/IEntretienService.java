/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entities.Entretien;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author User
 */
public interface IEntretienService<T> {
  /* public void creerEntretien(Entretien e)throws SQLException;*/
  /* public void modifierEntretien(Entretien e)throws SQLException;*/
 /* public void supprimerEntretien(Entretien e)throws SQLException;*/
  public List<Entretien> afficherEntretiens() ;
     /*   public void afficherEntretiens() throws SQLException;*/

}
