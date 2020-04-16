/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author yassine
 */
public class UserService {
    
    
    
    
    public  void connexion(BorderPane principeBorder ) throws IOException{
         BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Connexion.fxml"));
        root = loader.load();
        principeBorder.setCenter(root);
    }
    public void saevUser(){
        
    }
    
    
}
