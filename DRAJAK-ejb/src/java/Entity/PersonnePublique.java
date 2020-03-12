/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Novelzreal
 */
@Entity
public class PersonnePublique extends PersonnePhysique implements Serializable {

    @OneToMany(mappedBy = "clePersonnePublique")
    private List<ContratIndividuel> lesContratIndividuels;

    public List<ContratIndividuel> getLesContratIndividuels() {
        return lesContratIndividuels;
    }

    public void setLesContratIndividuels(List<ContratIndividuel> lesContratIndividuels) {
        this.lesContratIndividuels = lesContratIndividuels;
    }


    
}
