/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Fournisseur;
import model.User;

/**
 *
 * @author yassine
 */
public class FournisseurBD {

    public static int save(Fournisseur fournisseur) {
        int rep = 0;
        try {
            String sql = "Insert into fournisseur (NOM,PRENOM,TELE,EMAIL,ADRESS,RAISONSOCIAL) Values(?,?,?,?,?,?)";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, fournisseur.getNom());
            pr.setString(2, fournisseur.getPrenom());
            pr.setString(3, fournisseur.getTele());
            pr.setString(4, fournisseur.getEmail());
            pr.setString(5, fournisseur.getAdresse());
            pr.setString(6, fournisseur.getRaisonSocial());
            rep = pr.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    public static Fournisseur findById(long id) throws Exception {
        Fournisseur four = new Fournisseur();
        String sql = "select * from fournisseur where id=?";
        Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            four.setNom(resultSet.getString(1));
            four.setPrenom(resultSet.getString(2));
            four.setTele(resultSet.getString(3));
            four.setEmail(resultSet.getString(4));
            four.setAdresse(resultSet.getString(5));
            four.setRaisonSocial(resultSet.getString(6));
        } else {
            return null;
        }
        ConnectBd.close();
        return four;
    }

    public static List<Fournisseur> findAll() {
        List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
        try {
            String sql = "select * from fournisseur";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            while (re.next()) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(re.getLong(1));
                fournisseur.setEmail(re.getString(5));
                fournisseur.setNom(re.getString(2));
                fournisseur.setPrenom(re.getString(3));
                fournisseur.setTele(re.getString(4));
                fournisseur.setRaisonSocial(re.getString(7));
                fournisseur.setAdresse(re.getString(6));
                fournisseurs.add(fournisseur);
            }
            ConnectBd.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return fournisseurs;
    }

    public static ObservableList<Fournisseur> getAllListOb() {
        ObservableList<Fournisseur> fournisseurs = FXCollections.observableArrayList();
        try {
            String sql = "select * from fournisseur";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
//                fournisseurs.add(new User(rs.getLong(1), rs.getString(5), rs.getString(4), rs.getString(3), rs.getString(2), rs.getString(7), rs.getString(6)));
                fournisseurs.add(new Fournisseur(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            ConnectBd.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return fournisseurs;
    }

    public static ObservableList<Fournisseur> findByString(String str) {
        ObservableList<Fournisseur> result = FXCollections.observableArrayList();
        ObservableList<Fournisseur> fournisseurs = getAllListOb();
        for (Fournisseur fournisseur : fournisseurs) {
            if (fournisseur.getEmail().equals(str) || fournisseur.getNom().equals(str) || fournisseur.getNom().equals(str)) {
                result.add(fournisseur);
            }
        }
        return result;
    }

    public static int delete(Fournisseur fournisseur) {
        int st = 0;
        try {
            String sql = "Delete from fournisseur where LOGIN_U=?";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setLong(1, fournisseur.getId());
            st = pr.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return st;
    }

    public static int update(User user) throws Exception {
        int st = 0;
        try {
            String sql = "UPDATE user SET EMAIL=?,LOGIN_U=?,PRENOM=?,NOM=?,PASSWD=?,TYPE_U=?  where ID_USER=?";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPrenom());
            preparedStatement.setString(4, user.getNom());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getRole());
            st = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return st;
    }
}
