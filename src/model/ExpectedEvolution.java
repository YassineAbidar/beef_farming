/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public class ExpectedEvolution {

    private long id;
    private double evolutionMoyenne;
    private ImporteRace importeRaces;
    private int minAge;
    private int maxAge;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getEvolutionMoyenne() {
        return evolutionMoyenne;
    }

    public void setEvolutionMoyenne(double evolutionMoyenne) {
        this.evolutionMoyenne = evolutionMoyenne;
    }

    public ImporteRace getImporteRaces() {
        return importeRaces;
    }

    public void setImporteRaces(ImporteRace importeRaces) {
        this.importeRaces = importeRaces;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

  
}
