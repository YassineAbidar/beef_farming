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
public class Bovin {

    private long id;
    private long idBoucle;//referance
    private int age;
    private String nom;
    private List<ControleMensuel> controleMensuels;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdBoucle() {
        return idBoucle;
    }

    public void setIdBoucle(long idBoucle) {
        this.idBoucle = idBoucle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<ControleMensuel> getControleMensuels() {
        return controleMensuels;
    }

    public void setControleMensuels(List<ControleMensuel> controleMensuels) {
        this.controleMensuels = controleMensuels;
    }

}
