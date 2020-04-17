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
    private String reference;
    private List<ControleMensuel> controleMensuels;//bovins
    private Fournisseur fournisseur;
    private Import importe;
    private double prix;//pour le kg
    private double prixTotale;
    private long nombreBovins;
    private Race race;
    private List<ExpectedEvolution> expectedEvolution;

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

   

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(double prixTotale) {
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

    public List<ExpectedEvolution> getExpectedEvolution() {
        return expectedEvolution;
    }

    public void setExpectedEvolution(List<ExpectedEvolution> expectedEvolution) {
        this.expectedEvolution = expectedEvolution;
    }

    
    
}
