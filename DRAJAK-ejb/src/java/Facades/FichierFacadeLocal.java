/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Contrat;
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
    
    Fichier CreerFichier(String nom, Blob Stockage,TypeFichier cleTypeFichier, String chemin, Contrat cleContrat);
    
    List <Fichier> ListerAllFichier(TypeFichier Cle);
    
    void ModifierFichierStatut(TypeFichier tf, Fichier f);
            
    void SupprimerParticulier(Fichier f);
    
    Fichier RechercherFichierParId(long idContrat);
    
    List <Fichier> ListerAllFichierRIB(String nom);
    
    void ModifierFichierNom(String tf, Fichier f);
    
   Fichier RechercherFichierParIdTransaction(String idTransaction);
   
   List<Fichier> RechercherFichierParIdTransactionRIB(TypeFichier d);
}
