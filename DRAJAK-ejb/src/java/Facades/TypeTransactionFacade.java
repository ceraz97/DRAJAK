/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeTransaction;
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
public class TypeTransactionFacade extends AbstractFacade<TypeTransaction> implements TypeTransactionFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeTransactionFacade() {
        super(TypeTransaction.class);
    }

    @Override
    public TypeTransaction CreerTypeTransaction(String libelle) {
        TypeTransaction typeTransactionInstance= new TypeTransaction ();
        typeTransactionInstance.setLibelleTypeTransaction(libelle);
        getEntityManager().persist(typeTransactionInstance);
        return typeTransactionInstance;
    }

    @Override
    public List ListerAllTypeTransaction() {
        List listeDesTypeTransaction;
        String tx = "SELECT T FROM TypeTransaction AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeTransaction=req.getResultList();
        return listeDesTypeTransaction;
    }
    
  

    @Override
    public TypeTransaction RechercheTypeActe() {
        TypeTransaction t = null;
        String txt = "SELECT p FROM TypeTransaction P WHERE p.libelleTypeTransaction=:nomLibelle ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nomLibelle", "Acte");
        List<TypeTransaction> result = req.getResultList();
        if (result.size() == 1) {
            t = (TypeTransaction) result.get(0);
        }
        return t;
    }
            
}
