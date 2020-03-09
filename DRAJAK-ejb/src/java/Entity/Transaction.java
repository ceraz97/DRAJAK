/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.*;
import Enum.StatutTransaction;
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
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=true)
    private String libelleTransaction;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTransaction;
    @Column (nullable=false)
    private double montantTransaction;
    @Column (nullable=false)
    private StatutTransaction statutTransaction;
    @Column (nullable=false)
    private String libelleStatut;
    @ManyToOne
    private TypeTransaction cleTypeTransaction;
    @ManyToOne
    private CompteAssure cleCompteAssure;

    public CompteAssure getCleCompteAssure() {
        return cleCompteAssure;
    }

    public void setCleCompteAssure(CompteAssure cleCompteAssure) {
        this.cleCompteAssure = cleCompteAssure;
    }


    public TypeTransaction getCleTypeTransaction() {
        return cleTypeTransaction;
    }

    public void setCleTypeTransaction(TypeTransaction cleTypeTransaction) {
        this.cleTypeTransaction = cleTypeTransaction;
    }


    public String getLibelleStatut() {
        return libelleStatut;
    }

    public void setLibelleStatut(String libelleStatut) {
        this.libelleStatut = libelleStatut;
    }

            

    public StatutTransaction getStatutTransaction() {
        return statutTransaction;
    }

    public void setStatutTransaction(StatutTransaction statutTransaction) {
        this.statutTransaction = statutTransaction;
    }


    public double getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(double montantTransaction) {
        this.montantTransaction = montantTransaction;
    }


    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }


    public String getLibelleTransaction() {
        return libelleTransaction;
    }

    public void setLibelleTransaction(String libelleTransaction) {
        this.libelleTransaction = libelleTransaction;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Transaction[ id=" + id + " ]";
    }
    
}
