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
public class CompteAssure implements Serializable {

    @OneToMany(mappedBy = "cleCompte")
    private List<Contrat> contrats;

    @OneToMany(mappedBy = "cleCompteAssure")
    private List<Transactions> transaction;

    public List<Transactions> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false, unique=true)
    private String login;
    @Column (nullable=false)
    private String mdp;
    @Column (nullable=false, unique=true)
    private String email;
    @ManyToOne
    private Particulier cleParticulier;
    
    @ManyToOne
    private AyantDroit cleAyantDroit;

    public AyantDroit getCleAyantDroit() {
        return cleAyantDroit;
    }

    public void setCleAyantDroit(AyantDroit cleAyantDroit) {
        this.cleAyantDroit = cleAyantDroit;
    }


    public Particulier getCleParticulier() {
        return cleParticulier;
    }

    public void setCleParticulier(Particulier cleParticulier) {
        this.cleParticulier = cleParticulier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
        if (!(object instanceof CompteAssure)) {
            return false;
        }
        CompteAssure other = (CompteAssure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CompteAssure[ id=" + id + " ]";
    }
    
}
