/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeRemboursement;
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
public class TypeRemboursementFacade extends AbstractFacade<TypeRemboursement> implements TypeRemboursementFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeRemboursementFacade() {
        super(TypeRemboursement.class);
    }

    @Override
    public TypeRemboursement CreerTypeRemboursement(String libelle) {
        TypeRemboursement typeRemboursementInstance= new TypeRemboursement ();
        typeRemboursementInstance.setLibelleTypeRemboursement(libelle);
        getEntityManager().persist(typeRemboursementInstance);
        return typeRemboursementInstance;
    }

    @Override
    public List ListerAllTypeRemboursement() {
        List listeDesTypeRemboursement;
        String tx = "SELECT T FROM TypeRemboursement AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeRemboursement=req.getResultList();
        return listeDesTypeRemboursement;
    }
    
    
        @Override
    public TypeRemboursement RechercherTypeModuleParLibelle (String libelle) {
      TypeRemboursement p = null;
      String tx = "SELECT DP FROM TypeRemboursement AS DP WHERE DP.libelleTypeRemboursement=:domaine";
      Query req = getEntityManager().createQuery(tx);
      req.setParameter("domaine",libelle);
      List<TypeRemboursement> result = req.getResultList();
      if (result.size() == 1) {
            p = (TypeRemboursement) result.get(0);
        }
        return p;
    }
}
