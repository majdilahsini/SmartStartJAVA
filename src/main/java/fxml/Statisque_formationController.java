/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import entities.Session;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import services.FormationService;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Statisque_formationController implements Initializable {

    @FXML
    private AnchorPane char_pane;
    @FXML
    private BarChart<String, Integer> id_chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             FormationService s=new FormationService();
        XYChart.Series<String, Integer> series = null;
        try {
            series = s.statformations(Session.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Statisque_formationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        id_chart.getData().add(series); //(FXCollections.observableArrayList(series1));
id_chart.setData(FXCollections.observableArrayList(series));
        // TODO
    }    
    
}
