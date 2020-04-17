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
import model.User;

/**
 *
 * @author yassine
 */
public class UserBd {

    public static int save(User user) {
        int rep = 0;
        try {
            String sql = "Insert into user (EMAIL,LOGIN_U,PRENOM,NOM,PASSWD,TYPE_U) Values(?,?,?,?,?,?)";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, user.getEmail());
            pr.setString(2, user.getLogin());
            pr.setString(3, user.getPrenom());
            pr.setString(4, user.getNom());
            pr.setString(5, user.getPassword());
            pr.setString(6, user.getRole());
            rep = pr.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
    }

    public static User findById(long id) throws Exception {
        User user = new User();
        String sql = "select * from user where id=?";
        Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setEmail(resultSet.getString(1));
            user.setLogin(resultSet.getString(2));
            user.setPrenom(resultSet.getString(3));
            user.setNom(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setRole(resultSet.getString(6));
        } else {
            return null;
        }
        ConnectBd.close();
        return user;
    }

    public static List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try {
            String sql = "select * from user";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet re = pr.executeQuery();
            while (re.next()) {
                User user = new User();
                user.setId(re.getLong(1));
                user.setEmail(re.getString(2));
                user.setLogin(re.getString(3));
                user.setPrenom(re.getString(4));
                user.setNom(re.getString(5));
                user.setPassword(re.getString(6));
                user.setRole(re.getString(7));
                users.add(user);
            }
            ConnectBd.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return users;
    }

    public static ObservableList<User> getAllListOb() {
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            String sql = "select * from user";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getLong(1), rs.getString(5), rs.getString(4), rs.getString(3), rs.getString(2), rs.getString(7), rs.getString(6)));
            }
            ConnectBd.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return users;
    }

    public static ObservableList<User> findByString(String str) {
        ObservableList<User> result = FXCollections.observableArrayList();
        ObservableList<User> users = getAllListOb();
        for (User user : users) {
            if (user.getEmail().equals(str) || user.getLogin().equals(str) || user.getNom().equals(str)) {
                result.add(user);
            }
        }
        return result;
    }

    public static int delete(User user) {
        int st = 0;
        try {
            String sql = "Delete from user where LOGIN_U=?";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, user.getLogin());
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
