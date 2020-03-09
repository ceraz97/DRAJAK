/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class ContratIndividuel extends Contrat implements Serializable {

    

    @ManyToOne
    private ContratCollectif cleContratCollectif;
    
    @ManyToOne
    private TypePopulation cleTypePopulation;

    public TypePopulation getCleTypePopulation() {
        return cleTypePopulation;
    }

    public void setCleTypePopulation(TypePopulation cleTypePopulation) {
        this.cleTypePopulation = cleTypePopulation;
    }



    public ContratCollectif getCleContratCollectif() {
        return cleContratCollectif;
    }

    public void setCleContratCollectif(ContratCollectif cleContratCollectif) {
        this.cleContratCollectif = cleContratCollectif;
    }

    
}
