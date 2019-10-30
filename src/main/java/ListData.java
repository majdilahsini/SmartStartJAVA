
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */


import services.EntretienService;
import entities.Entretien;
import entities.Session;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



/**
 *
 * @author wiemhjiri
 */
public class ListData {
    
     /**
     * The data as an observable list of Persons.
     */
   

    private ObservableList<Entretien> entretiens=FXCollections.observableArrayList();

    public ListData() {
           
        int i =   Session.getId();

        EntretienService pdao=EntretienService.getInstance();
        entretiens= pdao.displayAll5(i);
        System.out.println(entretiens);
        
       
    }
    
    public ObservableList<Entretien> getPersons(){
        return entretiens;
    }
   
}
