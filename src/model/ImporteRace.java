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
public class ImporteRace {
    private long id;
    private List<ControleMensuel> controleMensuels;//bovins
    private Fournisseur fournisseur;
    private Import importe;
    private BigDecimal prix;//pour le kg
    private BigDecimal prixTotale;
    private long nombreBovins;
    private Race race;
    private ExpectedEvolution expectedEvolution;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ControleMensuel> getControleMensuels() {
        return controleMensuels;
    }

    public void setControleMensuels(List<ControleMensuel> controleMensuels) {
        this.controleMensuels = controleMensuels;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Import getImporte() {
        return importe;
    }

    public void setImporte(Import importe) {
        this.importe = importe;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(BigDecimal prixTotale) {
        this.prixTotale = prixTotale;
    }

    public long getNombreBovins() {
        return nombreBovins;
    }

    public void setNombreBovins(long nombreBovins) {
        this.nombreBovins = nombreBovins;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public ExpectedEvolution getExpectedEvolution() {
        return expectedEvolution;
    }

    public void setExpectedEvolution(ExpectedEvolution expectedEvolution) {
        this.expectedEvolution = expectedEvolution;
    }
    
    
}
