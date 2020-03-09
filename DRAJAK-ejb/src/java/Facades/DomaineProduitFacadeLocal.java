/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.DomaineProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface DomaineProduitFacadeLocal {

    void create(DomaineProduit domaineProduit);

    void edit(DomaineProduit domaineProduit);

    void remove(DomaineProduit domaineProduit);

    DomaineProduit find(Object id);

    List<DomaineProduit> findAll();

    List<DomaineProduit> findRange(int[] range);

    int count();
    
}
