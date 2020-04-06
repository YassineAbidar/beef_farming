/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author alikhyatti
 */
public class Race {
    private long id;
    private String libelle;
    private String origine;
    private ExpectedEvolution expectedEvolution;
    private List<ImporteRace> importeRaces;
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public ExpectedEvolution getExpectedEvolution() {
        return expectedEvolution;
    }

    public void setExpectedEvolution(ExpectedEvolution expectedEvolution) {
        this.expectedEvolution = expectedEvolution;
    }

    public List<ImporteRace> getImporteRaces() {
        return importeRaces;
    }

    public void setImporteRaces(List<ImporteRace> importeRaces) {
        this.importeRaces = importeRaces;
    }
    
    
}
