/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Enum.TypeProduit;
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
public class Produit implements Serializable {

    @OneToMany(mappedBy = "cleProduit")
    private List<Contrat> contrats;

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)    
    private TypeProduit typeProduit;
    @Column (nullable=false)
    private String libelleProduit;
    @Column (nullable=false)
    private double fiscalite;
    
    @ManyToOne
    private DomaineProduit cleDomaineProduit;

    @ManyToMany
    private List<Modules> lesModules;

    public List<Modules> getLesModules() {
        return lesModules;
    }

    public void setLesModules(List<Modules> lesModules) {
        this.lesModules = lesModules;
    }
    
    public DomaineProduit getCleDomaineProduit() {
        return cleDomaineProduit;
    }

    public void setCleDomaineProduit(DomaineProduit cleDomaineProduit) {
        this.cleDomaineProduit = cleDomaineProduit;
    }


    public double getFiscalite() {
        return fiscalite;
    }

    public void setFiscalite(double fiscalite) {
        this.fiscalite = fiscalite;
    }


    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Produit[ id=" + id + " ]";
    }
    
}
