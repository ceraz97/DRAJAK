/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Transaction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TransactionFacadeLocal {

    void create(Transaction transaction);

    void edit(Transaction transaction);

    void remove(Transaction transaction);

    Transaction find(Object id);

    List<Transaction> findAll();

    List<Transaction> findRange(int[] range);

    int count();
    
}
