/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.Fichier;
import Entity.Transactions;
import Entity.TypeTransaction;
import Enum.StatutTransaction;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

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
    
    
    
      @Override
    public List <Transactions> ListerTransactionAttente(StatutTransaction nom) {
        List listeDesFichiers;
        String tx = "SELECT G FROM Transactions AS G where G.statutTransaction=:cle";
        Query req = getEntityManager().createQuery(tx);
        req = req.setParameter("cle", nom);
        listeDesFichiers=req.getResultList();
        return listeDesFichiers;
        
    }
      
    
         @Override
    public Transactions RechercherTransactionParId(long idContrat) {
        Transactions ContratRecherche;
        String tx = "SELECT t FROM Transactions AS t WHERE t.id=:idcontrat";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("idcontrat", idContrat);
        ContratRecherche = (Transactions)req.getSingleResult();
        return ContratRecherche;
    }
    
       @Override
     public void ModifierTransaction(Transactions tf, StatutTransaction st, String f) {
        tf.setStatutTransaction(st);
        tf.setLibelleStatut(f);
        getEntityManager().persist(tf);
    }
}
