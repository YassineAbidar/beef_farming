/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Bovin;

/**
 *
 * @author pc
 */
public class BovinBd {
      public static Bovin findByIdBoucle(long idBoucle) throws Exception {
        Bovin bovin = new Bovin();
        String sql = "select * from bovin where IDBOUCLE=?";
        Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setLong(1, idBoucle);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            bovin.setId(resultSet.getLong(1));
            bovin.setIdBoucle(resultSet.getLong(2));
            bovin.setAge(resultSet.getDouble(3));
            bovin.setNom(resultSet.getString(4));
             
        } else {
            return null;
        }
        ConnectBd.close();
        return bovin;
    }
}
