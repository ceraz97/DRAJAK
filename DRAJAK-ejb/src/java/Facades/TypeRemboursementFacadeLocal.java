/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeRemboursement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface TypeRemboursementFacadeLocal {

    void create(TypeRemboursement typeRemboursement);

    void edit(TypeRemboursement typeRemboursement);

    void remove(TypeRemboursement typeRemboursement);

    TypeRemboursement find(Object id);

    List<TypeRemboursement> findAll();

    List<TypeRemboursement> findRange(int[] range);

    int count();

    TypeRemboursement CreerTypeRemboursement(String libelle);

    List<TypeRemboursement> ListerAllTypeRemboursement();
    
    TypeRemboursement RechercherTypeRemboursementParLibelle (String libelle);
    
}
