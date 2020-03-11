/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Particulier;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ParticulierFacadeLocal {

    void create(Particulier particulier);

    void edit(Particulier particulier);

    void remove(Particulier particulier);

    Particulier find(Object id);

    List<Particulier> findAll();

    List<Particulier> findRange(int[] range);

    int count();
    
    Particulier CreerParticulier(String tel, String adr, String nom, String prenom, Genre genre, Date Dob, StatutPersonne statutPersonne);

    List ListerAllParticulier();
    
    void ModifierParticulier(Particulier p);
    
    void SupprimerParticulier(Particulier p);

    
}
