/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.Transactions;
import Entity.TypeTransaction;
import Enum.StatutTransaction;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clementratz, Tristan
 */
@Stateless
public class TransactionFacade extends AbstractFacade<Transactions> implements TransactionFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionFacade() {
        super(Transactions.class);
    }
    
    @Override
    public Transactions CreerTransactions(String libelle, double montant, StatutTransaction statut, String libelleStatut, TypeTransaction cleTypeTransaction, CompteAssure cleCompteAssure) {
        Transactions t = new Transactions();
        t.setLibelleTransaction(libelle);
        t.setDateTransaction(new Date());
        t.setMontantTransaction(montant);
        t.setStatutTransaction(statut);
        t.setLibelleStatut(libelleStatut);
        t.setCleTypeTransaction(cleTypeTransaction);
        t.setCleCompteAssure(cleCompteAssure);
        getEntityManager().persist(t);
        return t;  
    }
    @Override    
    public void ModifierTransactions(Transactions t) {
        em.merge(t);
    }
    
}
