/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeTransaction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypeTransactionFacadeLocal {

    void create(TypeTransaction typeTransaction);

    void edit(TypeTransaction typeTransaction);

    void remove(TypeTransaction typeTransaction);

    TypeTransaction find(Object id);

    List<TypeTransaction> findAll();

    List<TypeTransaction> findRange(int[] range);

    int count();

    TypeTransaction CreerTypeTransaction(String libelle);

    List<TypeTransaction> ListerAllTypeTransaction();
    
}
