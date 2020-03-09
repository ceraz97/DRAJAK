/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author clementratz
 */
@Entity
public class Fichier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String nomFichier;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnvoiFichier;

    @ManyToOne
    private Contrat cleContrat;

    @ManyToOne
    private TypeFichier cleTypeFichier;

    public TypeFichier getCleTypeFichier() {
        return cleTypeFichier;
    }

    public void setCleTypeFichier(TypeFichier cleTypeFichier) {
        this.cleTypeFichier = cleTypeFichier;
    }

    public Contrat getCleContrat() {
        return cleContrat;
    }

    public void setCleContrat(Contrat cleContrat) {
        this.cleContrat = cleContrat;
    }

    public Date getDateEnvoiFichier() {
        return dateEnvoiFichier;
    }

    public void setDateEnvoiFichier(Date dateEnvoiFichier) {
        this.dateEnvoiFichier = dateEnvoiFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
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
        if (!(object instanceof Fichier)) {
            return false;
        }
        Fichier other = (Fichier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Fichier[ id=" + id + " ]";
    }
    
}
