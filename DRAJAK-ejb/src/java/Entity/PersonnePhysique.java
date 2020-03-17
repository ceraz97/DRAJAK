/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Enum.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author clementratz
 */
@Entity
@Inheritance (strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class PersonnePhysique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String nTelephone;
    @Column (nullable=false)
    private String adresse;
    @Column (nullable=false)
    private String nom;
    @Column (nullable=false)
    private String prenom;
    @Column (nullable=false)
    private Genre genre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @Column (nullable=false, unique=true)
    private String email;
    @Column (nullable=false)
    private StatutPersonne statutPersonne;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatutPersonne getStatutPersonne() {
        return statutPersonne;
    }

    public void setStatutPersonne(StatutPersonne statutPersonne) {
        this.statutPersonne = statutPersonne;
    }
    
    public StatutPersonne getStatutPeronne() {
        return statutPersonne;
    }

    public void setStatutPeronne(StatutPersonne statutPeronne) {
        this.statutPersonne = statutPeronne;
    }

    
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getnTelephone() {
        return nTelephone;
    }

    public void setnTelephone(String nTelephone) {
        this.nTelephone = nTelephone;
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
        if (!(object instanceof PersonnePhysique)) {
            return false;
        }
        PersonnePhysique other = (PersonnePhysique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PersonnePhysique[ id=" + id + " ]";
    }
    
}
