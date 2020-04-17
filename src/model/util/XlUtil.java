/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import model.dataBase.ExpectedEvolutionBd;

/**
 *
 * @author alikhyatti
 */
public class XlUtil {
    
    public static String uploadXlFile() {
        FileChooser fileChooser = new FileChooser();
        File file = new File(System.getProperty("user.home"));
        if (file.exists()) {
            fileChooser.setInitialDirectory(file);
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Exel file", "*.xlsx"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                System.out.println("controller.ImportRaceController.openFile() The absolute path is : " + selectedFile.getAbsolutePath());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("The expected evolution XL file has imported successfully");
                alert.showAndWait();
                return selectedFile.getAbsolutePath();
            } else {
                System.out.println("controller.ImportRaceController.openFile() : File is not valid");
                return null;
            }
        } else {
            System.out.println("controller.ImportRaceController.openFile() : the falowing file " + file.getAbsolutePath() + " is not exists");
            return null;
        }
    }
    
    public static String uploadXlFileName() {
        FileChooser fileChooser = new FileChooser();
        File file = new File(System.getProperty("user.home"));
        if (file.exists()) {
            fileChooser.setInitialDirectory(file);
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Exel file", "*.xlsx"));
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                System.out.println("controller.ImportRaceController.openFile() The absolute path is : " + selectedFile.getAbsolutePath());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("The expected evolution XL file has imported successfully");
                alert.showAndWait();
                return selectedFile.getName();
            } else {
                System.out.println("controller.ImportRaceController.openFile() : File is not valid");
                return null;
            }
        } else {
            System.out.println("controller.ImportRaceController.openFile() : the falowing file " + file.getAbsolutePath() + " is not exists");
            return null;
        }
    }
}
