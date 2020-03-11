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
public class TauxGarantie implements Serializable {

    @ManyToOne
    private TrancheAge cleTrancheAge;

    public TrancheAge getCleTrancheAge() {
        return cleTrancheAge;
    }

    public void setCleTrancheAge(TrancheAge cleTrancheAge) {
        this.cleTrancheAge = cleTrancheAge;
    }

    @ManyToOne
    private Garantie cleGarantie;

    public Garantie getCleGarantie() {
        return cleGarantie;
    }

    public void setCleGarantie(Garantie cleGarantie) {
        this.cleGarantie = cleGarantie;
    }

    @ManyToOne
    private ObjetGarantie cleObjetGarantie;

    public ObjetGarantie getCleObjetGarantie() {
        return cleObjetGarantie;
    }

    public void setCleObjetGarantie(ObjetGarantie cleObjetGarantie) {
        this.cleObjetGarantie = cleObjetGarantie;
    }

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private double maxRemboursement;
    @Column (nullable=false)
    private double tarifCotisation;

    public double getTarifCotisation() {
        return tarifCotisation;
    }

    public void setTarifCotisation(double tarifCotisation) {
        this.tarifCotisation = tarifCotisation;
    }


    public double getMaxRemboursement() {
        return maxRemboursement;
    }

    public void setMaxRemboursement(double maxRemboursement) {
        this.maxRemboursement = maxRemboursement;
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
        if (!(object instanceof TauxGarantie)) {
            return false;
        }
        TauxGarantie other = (TauxGarantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TauxGarantie[ id=" + id + " ]";
    }
    
}
