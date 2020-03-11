/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AyantDroit;
import Entity.CompteAssure;
import Entity.Particulier;
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
public class CompteAssureFacade extends AbstractFacade<CompteAssure> implements CompteAssureFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteAssureFacade() {
        super(CompteAssure.class);
    }


    @Override
    public CompteAssure AuthentifierCompteAssure(String login, String mdp) {
        CompteAssure ca;
        String txt = "SELECT log FROM CompteAssure AS CA WHERE log.login=:login and log.mdp=:mdp";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        req = req.setParameter("mdp", mdp);
        ca = null;
        List<CompteAssure> result = req.getResultList();
        if (result.size() == 1) {
            ca = (CompteAssure) result.get(0);
        }
        return ca;
    }

    @Override
    public CompteAssure CreerCompteAssure(String login, String mdp, String email, Particulier cleParticulier,  List<AyantDroit> lesAyantDroit) {
        CompteAssure ca = new CompteAssure();
        ca.setLogin(login);
        ca.setMdp(mdp);
        ca.setEmail(email);
        ca.setCleParticulier(cleParticulier);
        ca.setCleAyantDroit(null);
        getEntityManager().persist(ca);
        return ca;  
    }

    @Override
    public void ModifierCompteAssure(CompteAssure ca) {
        em.merge(ca);
    }
    
    @Override
    public void SupprimerCompteAssure(CompteAssure ca) {
        em.remove(ca);
    }

    @Override
    public List ListerAllCompteAssure() {
        List ListerAllCompteAssure;
        String tx = "SELECT CA FROM CompteAssure AS CA";
        Query req = getEntityManager().createQuery(tx);
        ListerAllCompteAssure=req.getResultList();
        return ListerAllCompteAssure;
    }
    
    @Override
    public CompteAssure RechercherCompteAssure(String login) {
        CompteAssure a;
        String txt = "SELECT a FROM CompteAssure CA WHERE a.login=:login ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        a = null;
        List<CompteAssure> result = req.getResultList();
        if (result.size() == 1) {
            a = (CompteAssure) result.get(0);
        }
        return a;

    }
    
    
}
