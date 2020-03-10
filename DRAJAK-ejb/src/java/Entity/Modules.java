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

/**
 *
 * @author clementratz
 */
@Entity
public class Modules implements Serializable {

    

    public List<Produit> getLesProduits() {
        return lesProduits;
    }

    public void setLesProduits(List<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String libelleModule;

    @ManyToMany(mappedBy = "lesModules")
    private List<Produit> lesProduits;
    
    @ManyToMany
    private List<Garantie> lesGaranties;

    public List<Garantie> getLesGaranties() {
        return lesGaranties;
    }

    public void setLesGaranties(List<Garantie> lesGaranties) {
        this.lesGaranties = lesGaranties;
    }

    @ManyToOne
    private TypeModule cleTypeModule;



    public TypeModule getCleTypeModule() {
        return cleTypeModule;
    }

    public void setCleTypeModule(TypeModule cleTypeModule) {
        this.cleTypeModule = cleTypeModule;
    }

    public String getLibelleModule() {
        return libelleModule;
    }

    public void setLibelleModule(String libelleModule) {
        this.libelleModule = libelleModule;
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
        if (!(object instanceof Modules)) {
            return false;
        }
        Modules other = (Modules) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Module[ id=" + id + " ]";
    }
    
}
