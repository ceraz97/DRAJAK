/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
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
    public CompteAssure CreerCompteAssure(String login, String mdp, String email) {
        CompteAssure ca = new CompteAssure();
        ca.setLogin(login);
        ca.setMdp(mdp);
        ca.setEmail(email);
        getEntityManager().persist(ca);
        return ca;  
    }

    @Override //Modification uniquement du mot de passe sur le compte
    public void ModifierMDPCompteAssure(String newMdp, CompteAssure ca) {
        ca.setMdp(newMdp);
        em.merge(ca);
    }

    @Override //Modification des autres infos
    public void ModifierInfoCompteAssure(String newlogin, String newemail, CompteAssure ca) {
        if(newlogin!=null){ //S'il y a eu une modification alors remplacer
            ca.setLogin(newlogin);}   
        if(newemail!=null){ //S'il y a eu une modification alors remplacer     
            ca.setEmail(newemail);}
        
        em.merge(ca);
    }

    @Override
    public CompteAssure RechercherCompte(String login) {
        CompteAssure a;
        String txt = "SELECT a FROM Agent CA WHERE a.login=:login ";
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
