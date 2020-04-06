/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alikhyatti
 */
public class ExpectedEvolution {
    private long id;
    private BigDecimal evolutionMoyenne;
    private List<ImporteRace> importeRaces;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getEvolutionMoyenne() {
        return evolutionMoyenne;
    }

    public void setEvolutionMoyenne(BigDecimal evolutionMoyenne) {
        this.evolutionMoyenne = evolutionMoyenne;
    }

    public List<ImporteRace> getImporteRaces() {
        return importeRaces;
    }

    public void setImporteRaces(List<ImporteRace> importeRaces) {
        this.importeRaces = importeRaces;
    }
    
    
}
