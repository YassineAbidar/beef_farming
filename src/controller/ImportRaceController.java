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
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Bovin;
import model.ControleMensuel;
import model.ExpectedEvolution;
import model.ImporteRace;
import model.dataBase.ExpectedEvolutionBd;
import model.dataBase.ImporteRaceBd;
import model.util.AlertTypeShow;
import model.util.XlUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    private JFXTextField importXlExpectedEvolution;
    @FXML
    private JFXTextField importXlBovin;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXTextField nombreBovin;
    @FXML
    private JFXTextField fournisseur;

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
   
//    @FXML
//    private void uploadFileExl(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();
//        File file = new File(System.getProperty("user.home"));
//        if (file.exists()) {
//            fileChooser.setInitialDirectory(file);
//            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Exel file", "*.xlsx"));
//            File selectedFile = fileChooser.showOpenDialog(null);
//            if (selectedFile != null) {
//                System.out.println("controller.ImportRaceController.openFile() The absolute path is : " + selectedFile.getAbsolutePath());
//                ExpectedEvolutionBd.importDataXlFile(selectedFile.getAbsolutePath());
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Information Dialog");
//                alert.setHeaderText(null);
//                alert.setContentText("The expected evolution XL file has imported successfully");
//                alert.showAndWait();
//            } else {
//                System.out.println("controller.ImportRaceController.openFile() : File is not valid");
//            }
//        } else {
//            System.out.println("controller.ImportRaceController.openFile() : the falowing file " + file.getAbsolutePath() + " is not exists");
//        }
//    }
     
    @FXML
    public void uploadXlExpectedEvolution(ActionEvent event) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(XlUtil.uploadXlFile()));
            importXlExpectedEvolution.setPromptText(XlUtil.uploadXlFileName());
 
            try {
                XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workBook.getSheetAt(0);
                Row row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    ExpectedEvolution expectedEvolution = new ExpectedEvolution();
                    row = (Row) sheet.getRow(i);
                    expectedEvolution.setEvolutionMoyenne(row.getCell(0).getNumericCellValue());
                    expectedEvolution.setMinAge((int) row.getCell(1).getNumericCellValue());
                    expectedEvolution.setMaxAge((int) row.getCell(2).getNumericCellValue());
                    ExpectedEvolutionBd.save(expectedEvolution);
                }
                System.out.println("Data Base impotred successfully!");
            } catch (IOException ex) {
                Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    @FXML
    public void uploadXlBovin(ActionEvent event) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(XlUtil.uploadXlFile()));
            importXlBovin.setPromptText(XlUtil.uploadXlFileName());
            try {
                XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workBook.getSheetAt(0);
                Row row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Bovin bovin = new Bovin();
                    row = (Row) sheet.getRow(i);
                    bovin.setIdBoucle((long) row.getCell(0).getNumericCellValue());
                    bovin.setNom(row.getCell(1).getStringCellValue());
                    bovin.setAge((int) row.getCell(2).getNumericCellValue());
                    ControleMensuel controleMensuel = new ControleMensuel();
                    controleMensuel.setBovin(bovin);
                    Date date = new Date();
                    controleMensuel.setDate(date);
                    controleMensuel.setPoids(row.getCell(3).getNumericCellValue());
//                    controleMensuel.setImporteRace(importeRace);
                    List<ControleMensuel> controleMensuels = new ArrayList<>();
                    controleMensuels.add(controleMensuel);
                    bovin.setControleMensuels(controleMensuels);
//                    BovinBd.save(bovin);
                }
                System.out.println("File Base impotred successfully!");
            } catch (IOException ex) {
                Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void save(ActionEvent event) {
        int rep = 0;
//        if (validationInput() == 0) {
        ImporteRace importeRace = new ImporteRace();
        importeRace.setPrix(Double.parseDouble(prix.getText()));
        importeRace.setNombreBovins(Long.parseLong(nombreBovin.getText()));
//            importeRace.setFournisseur(FournisseurBd.findByReference());
        rep = ImporteRaceBd.save(importeRace);
        if (rep == 0) {
            AlertTypeShow.showAlertError("Email Ou Login est deja existe");
        } else {
            AlertTypeShow.showAlertInfor("Nouvelle Utilisateur Est Ajouter Avec succes");
        }
//        } 
    }

    public int validationInput() {
        int cmp = 0;
        if (prix.getText().isEmpty() || prix.getText().matches("[A-Za-z]") || prix.getText().matches("[\\\\!\"#$%&()*+,/:;<=>?@\\[\\]^_{|}~]+")) {
//            iconPassword.setVisible(true);
            prix.setUnFocusColor(Color.RED);
            AlertTypeShow.showAlertError(" ");
            cmp++;
        } else {
//            iconPassword.setVisible(false);
            prix.setUnFocusColor(Color.WHITE);
        }
        if (nombreBovin.getText().isEmpty() || nombreBovin.getText().matches("[A-Za-z]") || nombreBovin.getText().length() < 200 || nombreBovin.getText().matches("[\\\\!\"#$%&()*+,/:;<=>?@\\[\\]^_{|}~]+")) {
//            iconEmail.setVisible(true);
            nombreBovin.setUnFocusColor(Color.RED);
            cmp++;
        } else {
//            iconEmail.setVisible(false);
            nombreBovin.setUnFocusColor(Color.WHITE);
        }
        if (fournisseur.getText().isEmpty()) {
//            icPrenom.setVisible(true);
            fournisseur.setUnFocusColor(Color.RED);
            cmp++;
        } else {
//            icPrenom.setVisible(false);
            fournisseur.setUnFocusColor(Color.WHITE);
        }

        return cmp;
    }

//    @FXML
//    private void openFile(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();
//        File file = new File(System.getProperty("user.home"));
//                    System.out.println("controller.ImportRaceController.openFile() ");
//
//        if (file.exists()) {
//            fileChooser.setInitialDirectory(file);
//            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Exel file", "*.xls"));
//            File selectedFile = fileChooser.showOpenDialog(null);
//            if (selectedFile != null) {
//                System.out.println("controller.ImportRaceController.openFile() " + selectedFile.getAbsolutePath());
//            } else {
//                System.out.println("controller.ImportRaceController.openFile() : File is not valid");
//            }
//        } else {
//            System.out.println("controller.ImportRaceController.openFile() : the falowing path "+ file.getAbsolutePath() + " is not found");
//        }
//
//    }
}
