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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class ObjetGarantie implements Serializable {

    @OneToMany(mappedBy = "cleObjetGarantie")
    private List<TauxGarantie> lesTauxGaranties;

    public List<TauxGarantie> getLesTauxGaranties() {
        return lesTauxGaranties;
    }

    public void setLesTauxGaranties(List<TauxGarantie> lesTauxGaranties) {
        this.lesTauxGaranties = lesTauxGaranties;
    }

    @OneToMany(mappedBy = "cleObjetGarantie")
    private List<ContratIndividuel> contratIndividuels;

    public List<ContratIndividuel> getContratIndividuels() {
        return contratIndividuels;
    }

    public void setContratIndividuels(List<ContratIndividuel> contratIndividuels) {
        this.contratIndividuels = contratIndividuels;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String libelleTypePopulation;
    

    public String getLibelleTypePopulation() {
        return libelleTypePopulation;
    }

    public void setLibelleTypePopulation(String libelleTypePopulation) {
        this.libelleTypePopulation = libelleTypePopulation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetGarantie)) {
            return false;
        }
        ObjetGarantie other = (ObjetGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TypePopulation[ id=" + id + " ]";
    }
    
}
