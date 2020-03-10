/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TauxGarantie;
import Entity.TypePopulation;
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
public class TypePopulationFacade extends AbstractFacade<TypePopulation> implements TypePopulationFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypePopulationFacade() {
        super(TypePopulation.class);
    }

    @Override
    public void CreerTypePopulation(String libelle, TauxGarantie txGarantie) {
        TypePopulation typePopulationInstance= new TypePopulation ();
        typePopulationInstance.setLibelleTypePopulation(libelle);
        typePopulationInstance.setCleTauxGarantie(txGarantie);
        getEntityManager().persist(typePopulationInstance); 
    }

    @Override
    public List ListTypePopulation() {
        List listeDesTypePopulation;
        String tx = "SELECT T FROM TypePopulation AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypePopulation=req.getResultList();
        return listeDesTypePopulation;
    }
    
    
    
}
