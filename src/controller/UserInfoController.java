/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import model.dataBase.UserBd;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author yassine
 */
public class UserInfoController implements Initializable {

    private ObservableList<User> users = FXCollections.observableArrayList();
    private ObservableList<User> users1 = FXCollections.observableArrayList();

    @FXML
    private AnchorPane anchrpaneUser;
    @FXML
    private TableColumn<User, String> colonNom;
    @FXML
    private TableColumn<User, String> colonPrenom;
    @FXML
    private TableColumn<User, String> colonLogin;
    @FXML
    private TableColumn<User, String> colonRole;
    @FXML
    private TableColumn<User, String> colonEmail;
    @FXML
    private TableView<User> tableViweUser;
    @FXML
    private JFXComboBox<String> critere;
    @FXML
    private JFXComboBox<String> valeur;

    /**
     * Initializes the controller class.
     */
    public void fillTable() {
        users = UserBd.getAllListOb();
        colonNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colonPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        colonLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        colonRole.setCellValueFactory(new PropertyValueFactory<User, String>("role"));
        colonEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        tableViweUser.setItems(users);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fillTable();
        critere.getItems().addAll("Nom", "Login", "Email");
    }

    public void fillComboValeur() {
        List<User> useres = UserBd.findAll();
        if (critere.getValue().equalsIgnoreCase("Nom")) {
            valeur.getItems().clear();
            for (User u : useres) {
                valeur.getItems().add(u.getNom());
            }
        } else if (critere.getValue().equalsIgnoreCase("Login")) {
            valeur.getItems().clear();
            for (User u : useres) {
                valeur.getItems().add(u.getLogin());
            }
        } else if (critere.getValue().equalsIgnoreCase("Email")) {
            valeur.getItems().clear();
            for (User u : useres) {
                valeur.getItems().add(u.getEmail());
            }
        }
    }

    @FXML
    private void remplirComboValeur(ActionEvent event) {
        fillComboValeur();
    }

    @FXML
    private void find(ActionEvent event) {
        tableViweUser.setItems(null);
        users = UserBd.findByString(valeur.getValue());
        tableViweUser.setItems(users);
    }

    @FXML
    private void UpdateUser(ActionEvent event) {
        System.out.println("update user");
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        int st = 0;
//        System.out.println("delete User");
        User user = tableViweUser.getSelectionModel().getSelectedItem();
//        boolean rep;
        Stage stage = new Stage();
        Group group = new Group();
        Scene scene = new Scene(group, 400, 180);
        JFXButton yes = new JFXButton("Oui");
        Label label = new Label("Vous Voulez Vraiment Supprimer L'utilisateur ?");
        JFXButton no = new JFXButton("Non");
        no.setLayoutY(80);
        no.setLayoutX(280);
        yes.setLayoutY(80);
        yes.setLayoutX(100);
        label.setLayoutX(15);
        label.setLayoutY(15);
        group.getChildren().addAll(yes, no, label);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Confirmation");
        stage.show();
        stage.setResizable(false);
        stage.setMaximized(false);

        yes.setOnAction(e -> {
            if (UserBd.delete(user) == 0) {
                System.out.println("errrr");
            } else {
                System.out.println("deleted");
            }
            tableViweUser.getItems().clear();
            fillTable();
            stage.close();
        });
        no.setOnAction(e -> {
            stage.close();
        });
    }

    public void updateTableView(ObservableList<User> users1) {
        tableViweUser.getItems().clear();
        tableViweUser.setItems(users);
    }

    @FXML
    private void ajouterUser(ActionEvent event) throws IOException {
        BorderPane root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Inscription.fxml"));
        root = loader.load();
//        inscriptionController.saveUser(true);
//            root = loader.load();
        Stage window = new Stage();
        Scene scene = new Scene(root, 568, 540);
        window.setScene(scene);
        window.setTitle("Ajouter User");
        window.initModality(Modality.APPLICATION_MODAL);
//        window.setResizable(false);
//        window.setMaximized(false);
        window.show();
        InscriptionController inscriptionController = loader.getController();
        inscriptionController.getPrevious().setVisible(false);
    }
}
