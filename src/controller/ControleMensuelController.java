/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import model.dataBase.BovinBd;
import model.dataBase.ControleMensuelBd;
import model.dataBase.ImporteRaceBd;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Bovin;
import model.ControleMensuel;
import model.ImporteRace;
import model.util.AlertTypeShow;

/**
 *
 * @author pc
 */
public class ControleMensuelController implements Initializable{

    @FXML
    private BorderPane controleMensuelBorder;
    @FXML
    private Pane paneImportRace;
    @FXML
    private Pane paneInfo;
    @FXML
    private JFXTextField idBoucle;
    @FXML
    private JFXTextField poids;
    
    private ControleMensuel controleMensuel=new ControleMensuel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
                  JFXDepthManager.setDepth(paneInfo, 5);

    }
      @FXML 
    public void saveControleMensuel(ActionEvent event ) throws Exception{
        if(valide()==0){
        ImporteRace importeRace =new ImporteRace();
        Bovin bovin=BovinBd.findByIdBoucle(Long.valueOf(idBoucle.getText()));
        if(bovin!=null){
             controleMensuel.setBovin(bovin);
             
         Long idImportRace=ImporteRaceBd.findIdImortRaceByIdBovin(controleMensuel.getBovin().getId());
         if(idImportRace!=null){
              long millis=System.currentTimeMillis();  
               java.sql.Date date=new java.sql.Date(millis);
               
              importeRace.setId(idImportRace);
              controleMensuel.setImporteRace(importeRace);
              controleMensuel.setPoids(Double.valueOf(poids.getText()));
              controleMensuel.setDate(date);  
              if(ControleMensuelBd.saveControleMensuel(controleMensuel)!=0){
                  AlertTypeShow.showAlertInfor("le controle Mensuel effectué avec succès");
              }else{
                  AlertTypeShow.showAlertError("Il y a un problème de sevgardage !.Veuillez réessaye");
                  vide();
              }
              
    
         }else{
                AlertTypeShow.showAlertError("importe race ne existe pas ");
         }
        
        }else{
                 AlertTypeShow.showAlertError(" le Bovin ne existe pas ");
        }
       
        }
    }
     private void vide(){
            idBoucle.setText("");
            poids.setText("");
        }
    private int valide(){
        int cmp = 0;
        if (idBoucle.getText().isEmpty()){
            idBoucle.setUnFocusColor(Color.RED);
             idBoucle.setText("");
            idBoucle.setPromptText("Le champ est vide!!");
            cmp++;
        } 
        if (poids.getText().isEmpty()||poids.getText().matches("") ) {
            poids.setUnFocusColor(Color.RED);
             poids.setText("");
             poids.setPromptText("Le champ est vide!!");
            cmp++;
        } 
        if(poids.getText().matches("[A-Za-z]")  || poids.getText().matches("[\\\\!\"#$%&()*+,./:;<=>?@\\[\\]^_{|}~]+")){
            poids.setUnFocusColor(Color.RED);
             poids.setText("");
             poids.setPromptText("Entrez un nombre!!");
            cmp++;
        }
           
       
        return cmp;
    }
    
}
