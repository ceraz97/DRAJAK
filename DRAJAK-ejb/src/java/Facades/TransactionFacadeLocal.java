/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Transactions;
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
    
}
