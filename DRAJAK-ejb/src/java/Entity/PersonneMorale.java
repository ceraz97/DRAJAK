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
public class PersonneMorale implements Serializable {

    @OneToMany(mappedBy = "clePersonneMorale")
    private List<ContratCollectif> contratCollectifs;

    public List<ContratCollectif> getContratCollectifs() {
        return contratCollectifs;
    }

    public void setContratCollectifs(List<ContratCollectif> contratCollectifs) {
        this.contratCollectifs = contratCollectifs;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (nullable=false)
    private String raisonSociale;
    @Column (nullable=false)
    private String nSiret;
    @Column (nullable=false)
    private String nSiren;
    @Column (nullable=false, unique=true)
    private String login;
    @Column (nullable=false)
    private String mdp;
    
    @Column (nullable=false, unique=true)
    private String email;

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
    
    public String getnSiren() {
        return nSiren;
    }

    public void setnSiren(String nSiren) {
        this.nSiren = nSiren;
    }

    public String getnSiret() {
        return nSiret;
    }

    public void setnSiret(String nSiret) {
        this.nSiret = nSiret;
    }


    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
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
        if (!(object instanceof PersonneMorale)) {
            return false;
        }
        PersonneMorale other = (PersonneMorale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PersonneMorale[ id=" + id + " ]";
    }
    
}
