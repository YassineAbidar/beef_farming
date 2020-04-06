/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public class ControleMensuel {
    private long id;
    private BigDecimal Poids;
    private Date date;
    private Bovin bovin;
    private ImporteRace importeRace;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPoids() {
        return Poids;
    }

    public void setPoids(BigDecimal Poids) {
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
    
    
}
