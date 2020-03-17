/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.PersonnePublique;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Novelzreal
 */
@Local
public interface PersonnePubliqueFacadeLocal {

    void create(PersonnePublique personnePublique);

    void edit(PersonnePublique personnePublique);

    void remove(PersonnePublique personnePublique);

    PersonnePublique find(Object id);

    List<PersonnePublique> findAll();

    List<PersonnePublique> findRange(int[] range);

    int count();
    
    PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr, StatutPersonne statutPersonne);

    List ListerAllPersonnePublique();
    
    void ModifierPersonnePublique(PersonnePublique pp);
    
    void SupprimerPersonnePublique(PersonnePublique pp);
    
    PersonnePublique RechercherPersonnePublique(String nSecu);
    
}
