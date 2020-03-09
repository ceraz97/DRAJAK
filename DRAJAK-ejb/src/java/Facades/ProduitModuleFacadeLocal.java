/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.ProduitModule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ProduitModuleFacadeLocal {

    void create(ProduitModule produitModule);

    void edit(ProduitModule produitModule);

    void remove(ProduitModule produitModule);

    ProduitModule find(Object id);

    List<ProduitModule> findAll();

    List<ProduitModule> findRange(int[] range);

    int count();
    
}
