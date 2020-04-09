/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class EvolutionController implements Initializable {

    @FXML
    private NumberAxis Y1;
    @FXML
    private CategoryAxis X1;
    @FXML
    private BarChart<Double, String> ExpectedEvolutionGraphe;
    @FXML
    private BarChart<Double, String> ReelEvolutiobGraphe;
    @FXML
    private NumberAxis Y2;
    @FXML
    private CategoryAxis X2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         XYChart.Series series= new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Race1", 20));
        series.getData().add(new XYChart.Data<>("Race2", 22));
        series.getData().add(new XYChart.Data<>("Race3", 18.9));
        ExpectedEvolutionGraphe.getData().addAll(series);
         XYChart.Series series1= new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("Race1", 19.5));
        series1.getData().add(new XYChart.Data<>("Race2", 21.9));
        series1.getData().add(new XYChart.Data<>("Race3", 19.9));
        ReelEvolutiobGraphe.getData().addAll(series1);
//        ReelEvolutiobGraphe.getData().addAll(series);
       
    }    

    @FXML
    private void appelauthorEvolution(ActionEvent event) {
        
        
    }
    
}
