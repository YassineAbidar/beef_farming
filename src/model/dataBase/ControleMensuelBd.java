/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ControleMensuel;

/**
 *
 * @author pc
 */
public class ControleMensuelBd {
         public static int saveControleMensuel(ControleMensuel controleMensuel){
         int rep = 0;
        try {
            String sql = "Insert into controlemensuel (ID_IMP_RACE,ID_BOVIN,POIDS,DATE) Values(?,?,?,?)";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setLong(1, controleMensuel.getImporteRace().getId());
            pr.setLong(2, controleMensuel.getBovin().getId());
            pr.setDouble(3, controleMensuel.getPoids());
            
            pr.setDate(4, (Date) controleMensuel.getDate());
            rep = pr.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return rep;
         
     }
     
}
