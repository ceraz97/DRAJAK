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
public class Particulier extends PersonnePhysique implements Serializable {

    @OneToMany(mappedBy = "cleParticulier")
    private List<AyantDroit> lesAyantDroits;

    public List<AyantDroit> getLesAyantDroits() {
        return lesAyantDroits;
    }

    public void setLesAyantDroits(List<AyantDroit> lesAyantDroits) {
        this.lesAyantDroits = lesAyantDroits;
    }

    @OneToMany(mappedBy = "cleParticulier")
    private List<CompteAssure> compteAssures;

    public List<CompteAssure> getCompteAssures() {
        return compteAssures;
    }

    public void setCompteAssures(List<CompteAssure> compteAssures) {
        this.compteAssures = compteAssures;
    }
    @Column (nullable=false, unique=true)
    private long nAdherent;
    @Column (nullable=false, unique=true)
    private String nSecuriteSocial;

    public String getnSecuriteSocial() {
        return nSecuriteSocial;
    }

    public void setnSecuriteSocial(String nSecuriteSocial) {
        this.nSecuriteSocial = nSecuriteSocial;
    }
    
    public long getnAdherent() {
        return nAdherent;
    }

    public void setnAdherent(long nAdherent) {
        this.nAdherent = nAdherent;
    }

    
}
