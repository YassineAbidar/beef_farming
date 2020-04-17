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
public class Fournisseur {
    private Long id;
    private String nom;
    private String prenom;
    private String tele;
    private String email;
    private String adresse;
    private String raisonSocial;
    private List<ImporteRace> importeRaces;

    public List<ImporteRace> getImporteRaces() {
        return importeRaces;
    }

    public Fournisseur(Long id, String nom, String prenom, String tele, String email, String adresse, String raisonSocial) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.email = email;
        this.adresse = adresse;
        this.raisonSocial = raisonSocial;
    }

    
    public Fournisseur() {
    }

    public void setImporteRaces(List<ImporteRace> importeRaces) {
        this.importeRaces = importeRaces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Fournisseur(Long id, String nom, String prenom, String tele, String email, String adresse, String raisonSocial, List<ImporteRace> importeRaces) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.email = email;
        this.adresse = adresse;
        this.raisonSocial = raisonSocial;
        this.importeRaces = importeRaces;
    }
    
    
}
