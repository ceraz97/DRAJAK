/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.AyantDroit;
import Entity.ContratIndividuel;
import Entity.Particulier;
import Entity.TypeAyantDroit;
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
public class AyantDroitFacade extends AbstractFacade<AyantDroit> implements AyantDroitFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AyantDroitFacade() {
        super(AyantDroit.class);
    }
        @Override
    public AyantDroit CreerAyantDroit(TypeAyantDroit cleTypeAyantDroit, Particulier cleParticulier, ContratIndividuel cleContratIndividuel) {
        AyantDroit ad = new AyantDroit();
        ad.setCleTypeAyantDroit(cleTypeAyantDroit);
        ad.setCleParticulier(cleParticulier);
        ad.setCleContratIndividuel(cleContratIndividuel);
        getEntityManager().persist(ad);
        return ad;  
    }
        
    @Override
    public List ListerAllAyantDroit() {
        List ListerAllAyantDroit;
        String tx = "SELECT ad FROM AyantDroit AS AD";
        Query req = getEntityManager().createQuery(tx);
        ListerAllAyantDroit=req.getResultList();
        return ListerAllAyantDroit;
    }
    
        @Override
    public List ListerAyantDroitContrat(ContratIndividuel ci) {
        List ListerAllAyantDroitContrat;
        String tx = "SELECT ad FROM AyantDroit AS AD WHERE ad.cleContratIndividuel=:cleContratIndividuel";
        Query req = getEntityManager().createQuery(tx);
        ListerAllAyantDroitContrat=req.getResultList();
        return ListerAllAyantDroitContrat;
    }
    
    public void ModifierAyantDroit(AyantDroit ad) {
        em.merge(ad);
        }
        
    public void SupprimerAyantDroit(AyantDroit ad){
        em.remove(ad);
        }

    @Override
    public AyantDroit RechercherAyantDroitParId(long idAD) {
        AyantDroit AyantDroitRecherche;
        String tx = "SELECT t FROM AyantDroit AS t WHERE t.id=:idad";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("idad", idAD);
        AyantDroitRecherche = (AyantDroit)req.getSingleResult();
        return AyantDroitRecherche;
    }
    
    
}
