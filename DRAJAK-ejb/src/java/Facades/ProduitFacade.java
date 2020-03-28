/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.*;
import Enum.TypeProduit;
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
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }

    @Override
    public Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules) {
        Produit produitInstance = new Produit ();
        produitInstance.setTypeProduit(typeProduit);
        produitInstance.setLibelleProduit(libelle);
        produitInstance.setFiscalite(fiscalite);
        produitInstance.setCleDomaineProduit(cleDomaineProduit);
        produitInstance.setLesModules(lesModules);
        getEntityManager().persist(produitInstance);
        return produitInstance;
    }

    @Override
    public void ModifierProduit(Produit produit) {
        getEntityManager().merge(produit);
    }

    @Override
    public void SupprimerProduit(Produit produit) {
        getEntityManager().remove(produit);
    }

    @Override
    public List ListerAllProduit() {
        List listeDesProduits;
        String tx = "SELECT P FROM Produit AS P";
        Query req = getEntityManager().createQuery(tx);
        listeDesProduits=req.getResultList();
        return listeDesProduits;
    }

    
}
