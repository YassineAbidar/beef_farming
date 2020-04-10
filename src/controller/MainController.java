/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.effects.JFXDepthManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author pc
 */
public class MainController implements Initializable {
    
    @FXML
    private BorderPane principalBorder;
    @FXML
    private Pane paneImportRace;
    @FXML
    private JFXButton suivant;
    @FXML
    private Pane paneInfo;
    @FXML
    private AnchorPane hboxMenu;
    @FXML
    private VBox vboxMenu;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paneImportRace.setVisible(false);
          JFXDepthManager.setDepth(paneInfo, 5);
           JFXDepthManager.setDepth(vboxMenu, 5);
          JFXDepthManager.setDepth(hboxMenu, 3);
    }
    
    private void importBouvin(ActionEvent event) throws IOException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bovin.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }
    
    @FXML
    private void IimportRace(ActionEvent event) throws IOException {
        
        paneImportRace.setVisible(true);
        principalBorder.setCenter(paneImportRace);
    }
    
    @FXML
    private void importBouvin2(MouseEvent event) throws IOException {
         paneImportRace.setVisible(false);
         AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bovin.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }

    @FXML
    private void appelEvolutionView(ActionEvent event) throws IOException {
          BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Evolution.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }
    @FXML
    private void  controleMensuel(ActionEvent event) throws IOException {
         paneImportRace.setVisible(false);
         AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ControleMensuel.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }
}
