/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.RegimeSocial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Novelzreal
 */
@Local
public interface RegimeSocialFacadeLocal {

    void create(RegimeSocial regimeSocial);

    void edit(RegimeSocial regimeSocial);

    void remove(RegimeSocial regimeSocial);

    RegimeSocial find(Object id);

    List<RegimeSocial> findAll();

    List<RegimeSocial> findRange(int[] range);

    int count();
    
    RegimeSocial CreerRegimeSocial(String libelle, Double plafMois, Double plafJour);

    void ModifierRegimeSocial(RegimeSocial rs);

    void SupprimerCompteAssure(RegimeSocial rs);
            
    List ListerAllRegimeSocial();
}

