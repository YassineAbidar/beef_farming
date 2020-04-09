/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.effects.JFXDepthManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 *
 * @author pc
 */
public class BovinController implements Initializable{

    @FXML
    private Pane paneImportRace;
    @FXML
    private Pane PaneInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         JFXDepthManager.setDepth(PaneInfo, 5);
    }
    
    
}
