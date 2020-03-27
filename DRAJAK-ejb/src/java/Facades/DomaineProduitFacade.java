/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.DomaineProduit;
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
public class DomaineProduitFacade extends AbstractFacade<DomaineProduit> implements DomaineProduitFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomaineProduitFacade() {
        super(DomaineProduit.class);
    }

    @Override
    public DomaineProduit CreerDomaineProduit(String libelle) {
        DomaineProduit domaineProduitInstance = new DomaineProduit ();
        domaineProduitInstance.setLibelleDomaineProduit(libelle);
        getEntityManager().persist(domaineProduitInstance);
        return domaineProduitInstance;
    }

    @Override
    public void ModifierDomaineProduit(DomaineProduit domaineProduit) {
        getEntityManager().merge(domaineProduit);
    }

    @Override
    public void SupprimerDomaineProduit(DomaineProduit domaineProduit) {
        getEntityManager().remove(domaineProduit);
    }

    @Override
    public List<DomaineProduit> ListerAllDomaineProduit() {
        List listeDesDomainesProduits;
        String tx = "SELECT DP FROM DomaineProduit AS DP";
        Query req = getEntityManager().createQuery(tx);
        listeDesDomainesProduits=req.getResultList();
        return listeDesDomainesProduits;
    }
    
    
    
    
   
    

    @Override
    public DomaineProduit RechercherDomaineParLibelle (String libelle) {
      DomaineProduit p = null;
      String tx = "SELECT DP FROM DomaineProduit AS DP WHERE dp.libelleDomaineProduit=:domaine";
      Query req = getEntityManager().createQuery(tx);
      req.setParameter("domaine", libelle);
      List<DomaineProduit> result = req.getResultList();
      if (result.size () ==1) {
          p = (DomaineProduit) result.get(0);
          
      }
      return p;
              }
    
    
    
}
