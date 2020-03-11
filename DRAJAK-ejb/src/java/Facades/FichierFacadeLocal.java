/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Fichier;
import Entity.TypeFichier;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface FichierFacadeLocal {

    void create(Fichier fichier);

    void edit(Fichier fichier);

    void remove(Fichier fichier);

    Fichier find(Object id);

    List<Fichier> findAll();

    List<Fichier> findRange(int[] range);

    int count();
    
    Fichier CreerFichier(String nom, Date dateEnvoi, Blob Stockage, TypeFichier t);
    
    List ListerAllFichier();
    
    void ModifierParticulier(Fichier f);
            
    void SupprimerParticulier(Fichier f);
}
