/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.PersonneMorale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clementratz
 */
@Stateless
public class PersonneMoraleFacade extends AbstractFacade<PersonneMorale> implements PersonneMoraleFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneMoraleFacade() {
        super(PersonneMorale.class);
    }
    
        @Override
    public PersonneMorale CreerPersonneMorale(String raisonSociale, int nSiret, int nSiren, String login, String mdp, String email) {
        PersonneMorale PM = new PersonneMorale();
        PM.setLogin(login);
        PM.setMdp(mdp);
        PM.setRaisonSociale(raisonSociale);
        PM.setnSiren(nSiren);
        PM.setnSiret(nSiret);
        PM.setEmail(email);
        getEntityManager().persist(PM);
        return PM;  
    }

    @Override
    public void ModifierInfoPersonneMorale(PersonneMorale pm, String raisonSociale, String login,String email) {
        if(raisonSociale!=null){ //S'il y a eu une modification alors remplacer
            pm.setRaisonSociale(raisonSociale);}
        if(login!=null){
            pm.setLogin(login);}
        if(email!=null){
            pm.setEmail(email);
        }
        em.merge(pm);
    }

    @Override
    public void ModifierMDPPersonneMoral(String newMdp, PersonneMorale pm) {
        pm.setMdp(newMdp);
        em.merge(pm);
    }
    
    
}
