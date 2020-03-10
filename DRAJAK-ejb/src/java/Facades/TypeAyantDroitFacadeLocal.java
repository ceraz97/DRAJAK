/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeAyantDroit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypeAyantDroitFacadeLocal {

    void create(TypeAyantDroit typeAyantDroit);

    void edit(TypeAyantDroit typeAyantDroit);

    void remove(TypeAyantDroit typeAyantDroit);

    TypeAyantDroit find(Object id);

    List<TypeAyantDroit> findAll();

    List<TypeAyantDroit> findRange(int[] range);

    int count();

    void CreerTypeAyantDroit(String Libelle);

    List ListeTypeAyantDroit();
    
}
