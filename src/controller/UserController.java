/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class UserController implements Initializable {

    @FXML
    private Pane principePane;
    @FXML
    private JFXComboBox<?> userComboBox;
    @FXML
    private BorderPane principeBorder;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          JFXDepthManager.setDepth(principePane, 30);
          
              BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Connexion.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        principeBorder.setCenter(root);
         
    }    
   
}
