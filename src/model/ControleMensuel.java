/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public class ControleMensuel {
    private long id;
    private double Poids;
    private Date date;
    private Bovin bovin;
    private ImporteRace importeRace;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPoids() {
        return Poids;
    }

    public void setPoids(double Poids) {
        this.Poids = Poids;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bovin getBovin() {
        return bovin;
    }

    public void setBovin(Bovin bovin) {
        this.bovin = bovin;
    }

    public ImporteRace getImporteRace() {
        return importeRace;
    }

    public void setImporteRace(ImporteRace importeRace) {
        this.importeRace = importeRace;
    }
    
    
}
