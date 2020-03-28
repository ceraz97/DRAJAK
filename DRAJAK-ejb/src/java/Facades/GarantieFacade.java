/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Garantie;
import Entity.Modules;
import Entity.TauxGarantie;
import Entity.TypeRemboursement;
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
public class GarantieFacade extends AbstractFacade<Garantie> implements GarantieFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GarantieFacade() {
        super(Garantie.class);
    }

    @Override
    public Garantie CreerGarantie(String libelle, TypeRemboursement typeRemboursement) {
        Garantie garantieInstance = new Garantie ();
        garantieInstance.setLibelleGarantie(libelle);
        garantieInstance.setCleTypeRemboursement(typeRemboursement);
        getEntityManager().persist(garantieInstance);
        return garantieInstance;
    }

    @Override
    public List ListerAllGarantie() {
        List listeDesGarantie;
        String tx = "SELECT G FROM Garantie AS G";
        Query req = getEntityManager().createQuery(tx);
        listeDesGarantie=req.getResultList();
        return listeDesGarantie;
    }

    @Override
    public Garantie RechercherGarantie(String libelle) {
        Garantie garantieInstance;
        String tx = "SELECT t FROM Garantie AS t WHERE t.libelleGarantie=:libelleG";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("libelleG", libelle);
        garantieInstance = (Garantie) req.getSingleResult();
        return garantieInstance;
    }
    
             @Override
    public Garantie rechercheGarantieParId(long id){
        Garantie f=null; 
        
        String tx= "SELECT g FROM Garantie AS g WHERE g.id=:id";
        Query req = getEntityManager().createQuery(tx); 
        req= req.setParameter("id",id);
        f= (Garantie) req.getSingleResult();
        return f;
 
    }
    
}
