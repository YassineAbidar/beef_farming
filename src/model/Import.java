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
public class Import {
    private long id;
    private List<ImporteRace> importeRaces;
    private Date date;
    private BigDecimal prixTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ImporteRace> getImporteRaces() {
        return importeRaces;
    }

    public void setImporteRaces(List<ImporteRace> importeRaces) {
        this.importeRaces = importeRaces;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }
    
    
}
