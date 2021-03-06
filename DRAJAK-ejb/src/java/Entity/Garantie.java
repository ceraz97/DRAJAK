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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class Garantie implements Serializable {

    @OneToMany(mappedBy = "cleGarantie")
    private List<TauxGarantie> lestauxGaranties;

    public List<TauxGarantie> getLestauxGaranties() {
        return lestauxGaranties;
    }

    public void setLestauxGaranties(List<TauxGarantie> lestauxGaranties) {
        this.lestauxGaranties = lestauxGaranties;
    }

    @ManyToMany(mappedBy = "lesGaranties")
    private List<Modules> lesModules;

    public List<Modules> getLesModules() {
        return lesModules;
    }

    public void setLesModules(List<Modules> lesModules) {
        this.lesModules = lesModules;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String libelleGarantie;


    @ManyToOne
    private TypeRemboursement cleTypeRemboursement;


    public TypeRemboursement getCleTypeRemboursement() {
        return cleTypeRemboursement;
    }

    public void setCleTypeRemboursement(TypeRemboursement cleTypeRemboursement) {
        this.cleTypeRemboursement = cleTypeRemboursement;
    }


    public String getLibelleGarantie() {
        return libelleGarantie;
    }

    public void setLibelleGarantie(String libelleGarantie) {
        this.libelleGarantie = libelleGarantie;
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
        if (!(object instanceof Garantie)) {
            return false;
        }
        Garantie other = (Garantie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Garantie[ id=" + id + " ]";
    }
    
}
