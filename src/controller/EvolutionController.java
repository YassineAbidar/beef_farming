/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class EvolutionController implements Initializable {

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private BorderPane BorderPrincipal;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         XYChart.Series series= new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("mois1", 20));
        series.getData().add(new XYChart.Data<>("mois2", 50));
        series.getData().add(new XYChart.Data<>("mois3", 20));
        series.getData().add(new XYChart.Data<>("mois4", 30));
        series.getData().add(new XYChart.Data<>("mois5", 70));
        series.getData().add(new XYChart.Data<>("mois6", 20));
        series.getData().add(new XYChart.Data<>("mois7", 100));
          series.getData().add(new XYChart.Data<>("mois8", 20));
        series.getData().add(new XYChart.Data<>("mois9", 30));
        series.getData().add(new XYChart.Data<>("mois10", 70));
        series.getData().add(new XYChart.Data<>("mois11", 122));
        series.getData().add(new XYChart.Data<>("mois12", 190));
        series.setName("Production attendue");
        
       
          XYChart.Series series1= new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("mois1", 19.6));
        series1.getData().add(new XYChart.Data<>("mois2", 22.4));
        series1.getData().add(new XYChart.Data<>("mois3", 30));
        series1.getData().add(new XYChart.Data<>("mois4", 34));
        series1.getData().add(new XYChart.Data<>("mois5", 40));
        series1.getData().add(new XYChart.Data<>("mois6", 45));
        series1.getData().add(new XYChart.Data<>("mois7", 50));
        series1.getData().add(new XYChart.Data<>("mois8", 59));
        series1.getData().add(new XYChart.Data<>("mois9", 100));
        series1.getData().add(new XYChart.Data<>("mois10", 122));
        series1.getData().add(new XYChart.Data<>("mois11", 130));
        series1.getData().add(new XYChart.Data<>("mois12", 150));
         series1.setName(" Production réelle");
        lineChart.getData().addAll(series,series1);
    }    

    @FXML
    private void appelEvolutionPlus(MouseEvent event) throws IOException {
         BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EvolutionPlus.fxml"));
        root = loader.load();
        BorderPrincipal.setCenter(root);
        BorderPrincipal.setTop(null);
    }


   
    
}
