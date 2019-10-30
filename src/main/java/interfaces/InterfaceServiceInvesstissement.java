/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Invesstissement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface InterfaceServiceInvesstissement {
    public void ajouterInvesstissement(Invesstissement i) throws SQLException;
    public void modifierInvesstissement(Invesstissement i)throws SQLException;
    public void SupprimerInvesstissement(Invesstissement i) throws SQLException;
    public List<Invesstissement> AfficheInvesstissement() throws SQLException;
}
