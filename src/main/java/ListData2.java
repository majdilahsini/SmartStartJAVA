/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.Entretien;
import entities.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import services.EntretienService;

/**
 *
 * @author User
 */
public class ListData2 {
        private ObservableList<Entretien> entretiens=FXCollections.observableArrayList();

    public ListData2() {
                int i =   Session.getId();

                EntretienService pdao=EntretienService.getInstance();
        entretiens= pdao.displayAll6(i);
    }
        public ObservableList<Entretien> getPersons(){
        return entretiens;
    }

    
}
