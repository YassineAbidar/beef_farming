/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
//
//import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import util.AlertTypeShow;

/**
 *
 * @author pc
 */
public class ImportRaceController implements Initializable {

    @FXML
    private JFXButton suivant;
    @FXML
    private BorderPane importRaceBorder;
    @FXML
    private Pane paneInfo;
    @FXML
    private JFXTextField afficheFicheirChoisit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXDepthManager.setDepth(paneInfo, 5);
    }

    @FXML
    private void importBovin(ActionEvent event) throws IOException {
        AnchorPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Bovin.fxml"));
        root = loader.load();
        importRaceBorder.setCenter(root);
        importRaceBorder.setTop(null);
    }
    @FXML
    private void uploadFileExl(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("C:\\Users"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Exel ", "*.Xlsx"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            afficheFicheirChoisit.setText(selectedFile.getAbsolutePath());
        }else{
            AlertTypeShow.showAlertError("Choisit un fichier Obligatoire!!!");
        }
    }

}
