/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author pc
 */
public class MainController implements Initializable{
    @FXML
    private BorderPane principalBorder;
    
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
    }
    
       @FXML
     private void importRace(ActionEvent event) throws IOException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ImportRace.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }
      @FXML
     private void importBovin(ActionEvent event) throws IOException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bovin.fxml"));
        root = loader.load();
        principalBorder.setCenter(root);
    }
   
}
