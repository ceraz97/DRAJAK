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
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class RegimeSocial implements Serializable {

    @OneToMany(mappedBy = "cleRegimeSocial")
    private List<CompteAssure> lesCompteAssures;

    public List<CompteAssure> getLesCompteAssures() {
        return lesCompteAssures;
    }

    public void setLesCompteAssures(List<CompteAssure> lesCompteAssures) {
        this.lesCompteAssures = lesCompteAssures;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String libelle;
    @Column (nullable=false)
    private double PlafondMensuel;
    @Column (nullable=false)
    private double plafondJournalier;

    public double getPlafondJournalier() {
        return plafondJournalier;
    }

    public void setPlafondJournalier(double plafondJournalier) {
        this.plafondJournalier = plafondJournalier;
    }


    public double getPlafondMensuel() {
        return PlafondMensuel;
    }

    public void setPlafondMensuel(double PlafondMensuel) {
        this.PlafondMensuel = PlafondMensuel;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        if (!(object instanceof RegimeSocial)) {
            return false;
        }
        RegimeSocial other = (RegimeSocial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RegimeSocial[ id=" + id + " ]";
    }
    
}
