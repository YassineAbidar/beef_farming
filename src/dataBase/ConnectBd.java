/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBd {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/beef_farming";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    public static Connection connection = null;

    public ConnectBd() {
    }

    public static Connection getConnexion() throws Exception {
        try {

            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("succès Connexion");
            return connection;
            
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    public static void printException(Exception e) {

        System.out.println("Échec de la connexion");
    }

    public static void close() throws SQLException {
        connection.close();
        System.out.println("data base closed");

    }

}
