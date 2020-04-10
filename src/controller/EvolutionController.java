/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class EvolutionController implements Initializable {

    @FXML
    private BarChart<String, Double> ExpectedEvolutionGraphe;
    @FXML
    private NumberAxis Y1;
    @FXML
    private CategoryAxis X1;
    @FXML
    private BarChart<String, Double> ReelEvolutiobGraphe;
    @FXML
    private NumberAxis Y2;
    @FXML
    private CategoryAxis X2;
    @FXML
    private BorderPane BorderPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         XYChart.Series series= new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Race1", 20));
        series.getData().add(new XYChart.Data<>("Race2", 21.3));
        series.getData().add(new XYChart.Data<>("RACE3", 19.75));
        ExpectedEvolutionGraphe.getData().addAll(series);
          XYChart.Series series1= new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("Race1", 19.6));
        series1.getData().add(new XYChart.Data<>("Race2", 22.4));
        series1.getData().add(new XYChart.Data<>("RACE3", 20));
        ReelEvolutiobGraphe.getData().addAll(series1);
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
