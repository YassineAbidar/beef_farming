/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ImporteRace;

/**
 *
 * @author pc
 */
public class ImporteRaceBd {
    
       public static Long findIdImortRaceByIdBovin(Long idBovin){
          
        try {
            String sql = "select * from controlemensuel where ID_BOVIN=?";
               Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
         preparedStatement.setLong(1, idBovin );
         ResultSet re = preparedStatement.executeQuery();
            while (re.next()) {
                return re.getLong(2);
        
            }
            ConnectBd.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return null ;
         
     }
       
       

    
}
