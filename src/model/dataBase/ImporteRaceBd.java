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
       
         public static int save(ImporteRace importeRace) {
        int rep = 0;

        String sql = "Insert into expectedevolution (id_race,id_import,id_fourni,prix,prixTotale,reference,nombre_bovins) Values(?,?,?,?)";
        try (Connection con = ConnectBd.getConnexion()) {
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            pr.setString(1, Long.toString(importeRace.getRace().getId()));
            pr.setString(2, Long.toString(importeRace.getImporte().getId()));
            pr.setString(3, Long.toString(importeRace.getFournisseur().getId()));
            pr.setString(4, Double.toString(importeRace.getPrix()));
            pr.setString(5, Double.toString(importeRace.getPrixTotale()));
            pr.setString(6, importeRace.getReference());
            pr.setString(7, Long.toString(importeRace.getNombreBovins()));
            
            rep = pr.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rep;
    }

    public static ImporteRace findById(long id) throws Exception {
        ImporteRace importRace = new ImporteRace();
        String sql = "select * from importrace where id_imp_race=?";
        Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            importRace.setId(resultSet.getLong(1));
            importRace.setNombreBovins(resultSet.getLong(8));
//             importRace.setExpectedEvolution(ExpectedEvolutionBd.findById(resultSet.getLong()));
            importRace.setPrix(resultSet.getDouble(5));
            importRace.setPrixTotale(resultSet.getDouble(6));
//            importRace.setFournisseur(fournisseur);
//            importRace.setControleMensuels(controleMensuels);
//            importRace.setImporte(importe);
//            importRace.setRace(race);
        } else {
            return null;
        }
        ConnectBd.close();
        return importRace;
    }

    
}
