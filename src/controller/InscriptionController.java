/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dataBase.UserBd;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import model.User;
import model.service.UserService;
import util.AlertTypeShow;
import util.HashPassword;

/**
 *
 * @author pc
 */
public class InscriptionController implements Initializable {
    public UserService userService= new UserService();

    @FXML
    private BorderPane principeBorder;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXComboBox<String> userComboBox;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXButton previous;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField confirmPasword;
    @FXML
    private MaterialDesignIconView icNom;
    @FXML
    private MaterialDesignIconView icPrenom;
    @FXML
    private MaterialDesignIconView icnLogin;
    @FXML
    private MaterialDesignIconView iconEmail;
    @FXML
    private MaterialDesignIconView iconPassword;
    @FXML
    private MaterialDesignIconView iconConfirmPass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userComboBox.getItems().addAll("Admin", "Elvateur","Technicien");
        userComboBox.setValue("Elvateur");
    }

    @FXML
    private void connexion(ActionEvent event) throws IOException {
       userService.connexion(principeBorder);
    }

    @FXML
    private void saveUser(ActionEvent event) {
        int rep = 0;
        if (validationInput() == 0) {
            User user = new User();
            user.setEmail(email.getText());
            user.setLogin(login.getText());
            user.setNom(nom.getText());
            user.setPassword( HashPassword.encryptPassword(password.getText()));
            user.setPrenom(prenom.getText());
            user.setRole(userComboBox.getValue().toString());
            rep = UserBd.save(user);
            if (rep == 0) {
               AlertTypeShow.showAlertError("Email Ou Login est deja existe");
            } else {
               AlertTypeShow.showAlertInfor("Nouvelle Utilisateur Est Ajouter Avec succes");
            }
        } 
    }

    public int validationInput() {
        int cmp = 0;
        if (password.getText().isEmpty() || password.getText().length()<8) {
            iconPassword.setVisible(true);
            password.setUnFocusColor(Color.RED);
             AlertTypeShow.showAlertError(" Au minimum 8 Caractere Pour Password");
            cmp++;
        } else {
            iconPassword.setVisible(false);
            password.setUnFocusColor(Color.WHITE);
        }
        if (email.getText().isEmpty() || email.getText().length()<15 || !email.getText().contains("@") || !email.getText().contains(".") ) {
            iconEmail.setVisible(true);
            email.setUnFocusColor(Color.RED);
            cmp++;
        } else {
            iconEmail.setVisible(false);
            email.setUnFocusColor(Color.WHITE);
        }
        if (prenom.getText().isEmpty()) {
            icPrenom.setVisible(true);
            prenom.setUnFocusColor(Color.RED);
            cmp++;
        } else {
            icPrenom.setVisible(false);
            prenom.setUnFocusColor(Color.WHITE);
        }
        if (nom.getText().isEmpty()) {
            icNom.setVisible(true);
            nom.setUnFocusColor(Color.RED);
            cmp++;
        } else {
            icNom.setVisible(false);
            nom.setUnFocusColor(Color.WHITE);
        }
        if (confirmPasword.getText().isEmpty()) {
            iconConfirmPass.setVisible(true);
            confirmPasword.setUnFocusColor(Color.RED);
            cmp++;
        } else {
            iconConfirmPass.setVisible(false);
            confirmPasword.setUnFocusColor(Color.WHITE);
        }
        if (login.getText().isEmpty()) {
            login.setUnFocusColor(Color.RED);
            icnLogin.setVisible(true);
            cmp++;
        } else {
            login.setUnFocusColor(Color.WHITE);
            icnLogin.setVisible(false);
        }
        if (!password.getText().equals(confirmPasword.getText()) ||  password.getText().isEmpty() ) {
            iconConfirmPass.setVisible(true);
            confirmPasword.setUnFocusColor(Color.RED);
            iconPassword.setVisible(true);
            password.setUnFocusColor(Color.RED);
            cmp++;
        }else{
            iconConfirmPass.setVisible(false);
            confirmPasword.setUnFocusColor(Color.WHITE);
            iconPassword.setVisible(false);
            password.setUnFocusColor(Color.WHITE);
        }
        return cmp;
    }

    @FXML
    private void EffaceIcon(MouseEvent event) {
        System.out.println("test clicked");
    }
    
}
