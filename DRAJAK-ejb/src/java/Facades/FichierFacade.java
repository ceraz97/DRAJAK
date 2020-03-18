/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteAssure;
import Entity.Contrat;
import Entity.Fichier;
import Entity.TypeFichier;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author clementratz
 */
@Stateless
public class FichierFacade extends AbstractFacade<Fichier> implements FichierFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichierFacade() {
        super(Fichier.class);
    }
   
    @Override
    public Fichier CreerFichier(String nom, Date dateEnvoi, Blob Stockage, TypeFichier cleTypeFichier, Contrat cleContrat) {
        Fichier f = new Fichier();
        f.setNomFichier(nom);
        f.setDateEnvoiFichier(dateEnvoi);
        f.setStockageFichier(Stockage);
        f.setCleTypeFichier(cleTypeFichier);
        f.setCleContrat(cleContrat);
        getEntityManager().persist(f);
        return f;  
    }
    
    @Override
    public List ListerAllFichier() {
        List listeDesFichiers;
        String tx = "SELECT G FROM Garantie AS G";
        Query req = getEntityManager().createQuery(tx);
        listeDesFichiers=req.getResultList();
        return listeDesFichiers;
    }
    
    @Override
    public void ModifierParticulier(Fichier f) {
        em.merge(f);
        }
    
    @Override    
    public void SupprimerParticulier(Fichier f){
        em.remove(f);
        }
}
