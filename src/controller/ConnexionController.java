/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import model.dataBase.ConnectBd;
import model.dataBase.UserBd;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lancher.BeefFarmingProject;
import model.User;
import model.util.AlertTypeShow;
import model.util.HashPassword;


/**
 *
 * @author pc
 */
public class ConnexionController implements Initializable {

    @FXML
    private BorderPane principeBorder;

    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton main;
    @FXML
    private JFXTextField login;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void inscription(ActionEvent event) throws IOException {
        BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Inscription.fxml"));
        root = loader.load();
        principeBorder.setCenter(root);

    }

    @FXML
    private void main(ActionEvent event) throws IOException, Exception {
//        String help = null;
//        List<User> users = new ArrayList<User>();
//
//        users = UserBd.findAll();
//        Map<String, String> map = new HashMap<String, String>();
//        for (User u : users) {
//
//            map.put(u.getLogin(), u.getPassword());
//
//        }
//        if (map.containsKey(login.getText())) {
//            String val = map.get(login.getText());   /// return la valeur correspandante a la cle en parametre
//            String passw=HashPassword.encryptPassword(password.getText());
//            if (val.equalsIgnoreCase(passw)) {
//                // infoLabel.setText("welcomme");
//                ConnectBd.getConnexion();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/MainController.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("gestion de Bovins");
                stage.setScene(scene);
                stage.show();
                BeefFarmingProject.stage1.hide();
//            } else {
//                AlertTypeShow.showAlertError("Password or user name is wrong");
//                System.out.println("c'est pas le meme password");
//            }
//
//        } else {
//            AlertTypeShow.showAlertError("Password or user name is wrong");
//            System.out.println("n'a pas trouver name");
//
//        }

    }

}
