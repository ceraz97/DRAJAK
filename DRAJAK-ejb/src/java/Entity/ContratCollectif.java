/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class ContratCollectif extends Contrat implements Serializable {

    @OneToMany(mappedBy = "cleContratCollectif")
    private List<ContratIndividuel> contratIndividuels;

    public List<ContratIndividuel> getContratIndividuels() {
        return contratIndividuels;
    }

    public void setContratIndividuels(List<ContratIndividuel> contratIndividuels) {
        this.contratIndividuels = contratIndividuels;
    }

    @ManyToOne
    @JoinColumn (nullable=false)
    private PersonneMorale clePersonneMorale;

    public PersonneMorale getClePersonneMorale() {
        return clePersonneMorale;
    }

    public void setClePersonneMorale(PersonneMorale clePersonneMorale) {
        this.clePersonneMorale = clePersonneMorale;
    }

    
    
}
