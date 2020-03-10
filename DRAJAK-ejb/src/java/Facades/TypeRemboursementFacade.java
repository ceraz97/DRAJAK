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
    public void CreerTypeRemboursement(String libelle) {
        TypeRemboursement typeRemboursementInstance= new TypeRemboursement ();
        typeRemboursementInstance.setLibelleTypeRemboursement(libelle);
        getEntityManager().persist(typeRemboursementInstance);
    }

    @Override
    public List ListTypeRemboursement() {
        List listeDesTypeRemboursement;
        String tx = "SELECT T FROM TypeRemboursement AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeRemboursement=req.getResultList();
        return listeDesTypeRemboursement;
    }
    
    
    
}
