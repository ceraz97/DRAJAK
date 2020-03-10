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
    public CompteAssure AuthentificationCompteAssure(String login, String mdp) {
        CompteAssure p;
        String txt = "SELECT log FROM CompteAssure AS CA WHERE log.login=:login and log.mdp=:mdp";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        req = req.setParameter("mdp", mdp);
        p = null;
        List<CompteAssure> result = req.getResultList();
        if (result.size() == 1) {
            p = (CompteAssure) result.get(0);
        }
        return p;
    }
    
}
