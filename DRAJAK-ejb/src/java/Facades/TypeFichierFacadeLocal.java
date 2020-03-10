/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeFichier;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypeFichierFacadeLocal {

    void create(TypeFichier typeFichier);

    void edit(TypeFichier typeFichier);

    void remove(TypeFichier typeFichier);

    TypeFichier find(Object id);

    List<TypeFichier> findAll();

    List<TypeFichier> findRange(int[] range);

    int count();

    TypeFichier CreerTypeFichier(String Libelle);

    List<TypeFichier> ListerAllTypeFichier();
    
}
