/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//
//import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author pc
 */
public class ImportRaceController implements Initializable {

    @FXML
    private JFXButton suivant;

//    @FXML
//    private JFXButton suivant;
//       s
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @FXML
    private void importBouvin2(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bovin.fxml"));

        AnchorPane root = loader.load();
        if (root == null) {
            System.out.println("root est null");
        } else {
            MainController mainController = loader.getController();
           
        }
    }

}
