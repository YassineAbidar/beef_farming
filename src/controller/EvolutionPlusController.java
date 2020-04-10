/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class EvolutionPlusController implements Initializable {

    @FXML
    private JFXRadioButton importRaceRadioButton;
    @FXML
    private ToggleGroup impot;
    @FXML
    private JFXRadioButton raceRadioButton;
    @FXML
    private JFXComboBox<String> importRaceCombobox;
    @FXML
    private StackedBarChart<Integer, String> ImportRaceGraphe;
    @FXML
    private NumberAxis y1;
    @FXML
    private CategoryAxis x1;
    @FXML
    private PieChart PieChartGraphe;
    @FXML
    private HBox HboxHeader;
    @FXML
    private JFXComboBox<String> raceComboBox;
    @FXML
    private JFXComboBox<String> diagrameComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        list.add(new PieChart.Data("Race1", 50));
        list.add(new PieChart.Data("RACE2", 40));
        list.add(new PieChart.Data("Race3", 10));
        list.add(new PieChart.Data("Race4", 90));
        PieChartGraphe.setData(list);
         XYChart.Series series1= new XYChart.Series<>();
        series1.getData().add(new XYChart.Data<>("Race1", 19.5));
        series1.getData().add(new XYChart.Data<>("Race2", 21.9));
        series1.getData().add(new XYChart.Data<>("Race3", 19.9));
        ImportRaceGraphe.getData().addAll(series1);
        raceRadioButton.setSelected(true);
        raceComboBox.getItems().addAll("Tout Les Races","Race1","Race2","Race3","Race4");
        diagrameComboBox.getItems().addAll("Diagrame 1","Diagramme2","Diagramme3");
    }    
    
}
