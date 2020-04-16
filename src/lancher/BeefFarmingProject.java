/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancher;

import dataBase.ConnectBd;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yassine
 */
public class BeefFarmingProject extends Application {
     @Override
     public void init() throws Exception {
       ConnectBd.getConnexion();
    }
//     @Override
//      public void stop() throws Exception {
//        ConnectBd.close();
//    }
    
     public static Stage stage1=new Stage();
    @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("/view/User.fxml"));     
        Scene scene = new Scene(root);
        stage.setTitle("gestion de Bovins");
        stage.setResizable(false);
        stage.setScene(scene);
         
        stage1=stage;
        stage.show();
        
        
        
         
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
