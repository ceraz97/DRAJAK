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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author clementratz
 */
@Entity
public class Particulier extends PersonnePhysique implements Serializable {

    @OneToMany(mappedBy = "cleParticulier")
    private List<CompteAssure> compteAssures;

    public List<CompteAssure> getCompteAssures() {
        return compteAssures;
    }

    public void setCompteAssures(List<CompteAssure> compteAssures) {
        this.compteAssures = compteAssures;
    }
    @Column (nullable=false, unique=true)
    private int nAdherent;
    
    @ManyToOne
    private AyantDroit cleAyantDroit;

    public AyantDroit getCleAyantDroit() {
        return cleAyantDroit;
    }

    public void setCleAyantDroit(AyantDroit cleAyantDroit) {
        this.cleAyantDroit = cleAyantDroit;
    }


    public int getnAdherent() {
        return nAdherent;
    }

    public void setnAdherent(int nAdherent) {
        this.nAdherent = nAdherent;
    }

    
}
