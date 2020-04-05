/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AyantDroit;
import Entity.ContratIndividuel;
import Entity.Particulier;
import Entity.TypeAyantDroit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface AyantDroitFacadeLocal {

    void create(AyantDroit ayantDroit);

    void edit(AyantDroit ayantDroit);

    void remove(AyantDroit ayantDroit);

    AyantDroit find(Object id);

    List<AyantDroit> findAll();

    List<AyantDroit> findRange(int[] range);

    int count();
    
    AyantDroit CreerAyantDroit(TypeAyantDroit cleTypeAyantDroit, Particulier cleParticulier, ContratIndividuel cleContratIndividuel);
    
    List ListerAllAyantDroit();
    
    List ListerAyantDroitContrat(ContratIndividuel ci);
    
    void ModifierAyantDroit(AyantDroit ad);
    
    void SupprimerAyantDroit(AyantDroit ad);

    AyantDroit RechercherAyantDroitParId(long idAD);

    AyantDroit RechercherAyantDroitParCleparticulier(Particulier particulier, ContratIndividuel contratIndiv);
    
}
