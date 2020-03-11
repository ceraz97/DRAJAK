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
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class CompteEmploye extends PersonnePhysique implements Serializable {

    @OneToMany(mappedBy = "cleCompteEmploye")
    private List<Contrat> contrats;

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }
    
    @Column (nullable=false, unique=true)
    private String CodeEmploye;
    @Column (nullable=false)
    private String roleEmploye;
    
    @Column (nullable=false, unique=true)
    private String login;
    
    @Column (nullable=false)
    private String mdp;
    
    
    public String getCodeEmploye() {
        return CodeEmploye;
    }

    public void setCodeEmploye(String CodeEmploye) {
        this.CodeEmploye = CodeEmploye;
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

    public String getRoleEmploye() {
        return roleEmploye;
    }

    public void setRoleEmploye(String roleEmploye) {
        this.roleEmploye = roleEmploye;
    }

    
}
