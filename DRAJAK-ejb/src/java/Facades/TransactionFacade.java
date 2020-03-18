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
    public Transactions CreerTransactions(String libelle, Date date, double montant, StatutTransaction statut, String libelleStatut, TypeTransaction type, CompteAssure cleCompteAssure) {
        Transactions t = new Transactions();
        t.setLibelleTransaction(libelle);
        t.setDateTransaction(date);
        t.setMontantTransaction(montant);
        t.setStatutTransaction(statut);
        t.setLibelleStatut(libelleStatut);
        t.setCleTypeTransaction(type);
        t.setCleCompteAssure(cleCompteAssure);
        getEntityManager().persist(t);
        return t;  
    }
    @Override    
    public void ModifierTransactions(String libelle, double montant, Transactions t) {
        t.setLibelleTransaction(libelle);
        t.setMontantTransaction(montant);
        em.merge(t);
    }
    
    @Override    
    public void ModifierStatutTransactions(StatutTransaction statut, String libelleStatut, Transactions t) {
        t.setStatutTransaction(statut);
        t.setLibelleStatut(libelleStatut);
        em.merge(t);
    }
    
}
