/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ExpectedEvolution;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author alikhyatti
 */
public class ExpectedEvolutionBd {

    public static int save(ExpectedEvolution expectedEvolution) {
        int rep = 0;

        String sql = "Insert into expectedevolution (ID_IMP_RACE,AGE_MIN,AGE_MAX,MOYENNE_EVOLUTION) Values(?,?,?,?)";
        try (Connection con = ConnectBd.getConnexion()) {
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            if (expectedEvolution.getImporteRaces() != null) {
                pr.setString(1, Long.toString(expectedEvolution.getImporteRaces().getId()));
            } else {
                pr.setString(1, Long.toString(1));
            }
            pr.setString(2, Integer.toString(expectedEvolution.getMinAge()));
            pr.setString(3, Integer.toString(expectedEvolution.getMaxAge()));
            pr.setString(4, Double.toString(expectedEvolution.getEvolutionMoyenne()));
            rep = pr.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return rep;
    }

    public static void importDataXlFile(String pathFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(pathFile));

            try {
                XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
                XSSFSheet sheet = workBook.getSheetAt(0);
                Row row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    ExpectedEvolution expectedEvolution = new ExpectedEvolution();
                    row = (Row) sheet.getRow(i);
                    expectedEvolution.setEvolutionMoyenne(row.getCell(0).getNumericCellValue());
                    expectedEvolution.setMinAge((int) row.getCell(1).getNumericCellValue());
                    expectedEvolution.setMaxAge((int) row.getCell(2).getNumericCellValue());
                    save(expectedEvolution);
                }
                System.out.println("Data Base impotred successfully!");
            } catch (IOException ex) {
                Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpectedEvolutionBd.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static ExpectedEvolution findById(long id) throws Exception {
        ExpectedEvolution expectedEvolution = new ExpectedEvolution();
        String sql = "select * from expectedevolution where id_ee=?";
        Connection connection = ConnectBd.getConnexion();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            expectedEvolution.setId(resultSet.getInt(1));
            expectedEvolution.setImporteRaces(ImporteRaceBd.findById(resultSet.getLong(2)));
            expectedEvolution.setMinAge(resultSet.getInt(3));
            expectedEvolution.setMaxAge(resultSet.getInt(4));
            expectedEvolution.setEvolutionMoyenne(resultSet.getFloat(5));
        } else {
            return null;
        }
        ConnectBd.close();
        return expectedEvolution;
    }

    public static List<ExpectedEvolution> findAll() {
        List<ExpectedEvolution> expectedEvolutions = new ArrayList<ExpectedEvolution>();
        try {
            String sql = "select * from expectedEvolution";
            Connection con = ConnectBd.getConnexion();
            PreparedStatement pr = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                ExpectedEvolution expectedEvolution = new ExpectedEvolution();
                expectedEvolution.setId(resultSet.getLong(1));
                expectedEvolution.setMinAge(resultSet.getInt(3));
                expectedEvolution.setMaxAge(resultSet.getInt(4));
                expectedEvolution.setEvolutionMoyenne(resultSet.getFloat(5));
//                expectedEvolution.setImporteRaces(resultSet.getString(2));
                expectedEvolutions.add(expectedEvolution);
            }
            ConnectBd.close();
        } catch (Exception e) {

            System.out.println(e.getLocalizedMessage());
        }
        return expectedEvolutions;
    }
}
