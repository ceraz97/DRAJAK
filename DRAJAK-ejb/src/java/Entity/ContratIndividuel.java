/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class ContratIndividuel extends Contrat implements Serializable {

    

    @ManyToOne
    @JoinColumn (nullable=true)
    private ContratCollectif cleContratCollectif;
    
    @ManyToOne
    @JoinColumn (nullable=false)
    private ObjetGarantie cleObjetGarantie;

    public ObjetGarantie getCleObjetGarantie() {
        return cleObjetGarantie;
    }

    public void setCleObjetGarantie(ObjetGarantie cleTypePopulation) {
        this.cleObjetGarantie = cleTypePopulation;
    }



    public ContratCollectif getCleContratCollectif() {
        return cleContratCollectif;
    }

    public void setCleContratCollectif(ContratCollectif cleContratCollectif) {
        this.cleContratCollectif = cleContratCollectif;
    }

    
}
