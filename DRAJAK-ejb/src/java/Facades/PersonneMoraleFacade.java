/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.PersonneMorale;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public PersonneMorale CreerPersonneMorale(String raisonSociale, String nSiret, String nSiren, String login, String mdp, String email) {
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
    public void ModifierPersonneMorale(PersonneMorale pm) {
        em.merge(pm);
    }
    
    @Override
    public void SupprimerPersonneMorale(PersonneMorale pm) {
        em.remove(pm);  
    }
    
   @Override
    public List ListerAllPersonneMorale() {
        List ListerAllPersonneMorale;
        String tx = "SELECT PM FROM PersonneMorale AS PM";
        Query req = getEntityManager().createQuery(tx);
        ListerAllPersonneMorale=req.getResultList();
        return ListerAllPersonneMorale;
    }

    @Override
    public PersonneMorale AuthentifierCompteEntreprise(String login, String mdp) {
        PersonneMorale pm;
        String txt = "SELECT log FROM CompteAssure AS log WHERE log.login=:Login and log.mdp=:Mdp";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("Login", login);
        req = req.setParameter("Mdp", mdp);
        pm = null;
        List<PersonneMorale> result = req.getResultList();
        if (result.size() == 1) {
            pm = (PersonneMorale) result.get(0);
        }
        return pm;
    }
    
}
