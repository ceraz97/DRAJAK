/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.PersonneMorale;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface PersonneMoraleFacadeLocal {

    void create(PersonneMorale personneMorale);

    void edit(PersonneMorale personneMorale);

    void remove(PersonneMorale personneMorale);

    PersonneMorale find(Object id);

    List<PersonneMorale> findAll();

    List<PersonneMorale> findRange(int[] range);

    int count();
    
    PersonneMorale CreerPersonneMorale(String raisonSociale, int nSiret, int nSiren, String login, String mdp, String email);

    void ModifierInfoPersonneMorale(PersonneMorale pm, String raisonSociale, String login,String email);

    void ModifierMDPPersonneMoral(String newMdp, PersonneMorale pm);
            
            
    
}
