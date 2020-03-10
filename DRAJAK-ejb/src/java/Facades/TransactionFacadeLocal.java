/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Transactions;
import Enum.StatutTransaction;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TransactionFacadeLocal {

    void create(Transactions transaction);

    void edit(Transactions transaction);

    void remove(Transactions transaction);

    Transactions find(Object id);

    List<Transactions> findAll();

    List<Transactions> findRange(int[] range);

    int count();
    
    Transactions CreerTransactions(String libelle, Date date, double montant, StatutTransaction statut, String libelleStatut);
    
    void ModifierTransactions(String libelle, double montant, Transactions t);

    void ModifierStatutTransactions(StatutTransaction statut, String libelleStatut, Transactions t);

}
