/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Enum.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;


/**
 *
 * @author clementratz
 */
@Entity
abstract class Contrat implements Serializable {

    @OneToMany(mappedBy = "cleContrat")
    private List<Evenement> evenements;

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    @OneToMany(mappedBy = "cleContrat")
    private List<Fichier> fichiers;

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    public void setFichiers(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;

    @Column (nullable=true)
    private String libelleContrat;

    @Column (nullable=false)
    private StatutContrat statut;

    @Column (nullable=false)
    private ChoixPaiement paiement;

    @ManyToOne
    private CompteAssure cleCompte;

    @ManyToOne
    private CompteEmploye cleCompteEmploye;
    
    @ManyToOne
    private Produit cleProduit;

    public Produit getCleProduit() {
        return cleProduit;
    }

    public void setCleProduit(Produit cleProduit) {
        this.cleProduit = cleProduit;
    }


    public CompteEmploye getCleCompteEmploye() {
        return cleCompteEmploye;
    }

    public void setCleCompteEmploye(CompteEmploye cleCompteEmploye) {
        this.cleCompteEmploye = cleCompteEmploye;
    }

    public CompteAssure getCleCompte() {
        return cleCompte;
    }

    public void setCleCompte(CompteAssure cleCompte) {
        this.cleCompte = cleCompte;
    }

    public ChoixPaiement getPaiement() {
        return paiement;
    }

    public void setPaiement(ChoixPaiement paiement) {
        this.paiement = paiement;
    }
    
    public StatutContrat getStatut() {
        return statut;
    }

    public void setStatut(StatutContrat statut) {
        this.statut = statut;
    }

    public String getLibelleContrat() {
        return libelleContrat;
    }

    public void setLibelleContrat(String libelleContrat) {
        this.libelleContrat = libelleContrat;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contrat[ id=" + id + " ]";
    }
    
}
