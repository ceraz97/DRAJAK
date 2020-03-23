/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeModule;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypeModuleFacadeLocal {

    void create(TypeModule typeModule);

    void edit(TypeModule typeModule);

    void remove(TypeModule typeModule);

    TypeModule find(Object id);

    List<TypeModule> findAll();

    List<TypeModule> findRange(int[] range);

    int count();

    TypeModule CreerTypeModule(String libelle);

    List<TypeModule> ListerAllTypeModule();

    TypeModule RechercherTypeModule(String libelle);
    
}
