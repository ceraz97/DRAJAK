/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

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
public class TypeAyantDroitFacade extends AbstractFacade<TypeAyantDroit> implements TypeAyantDroitFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeAyantDroitFacade() {
        super(TypeAyantDroit.class);
    }

    @Override
    public void CreerTypeAyantDroit(String Libelle) {
        TypeAyantDroit typeAyantDroitInstance= new TypeAyantDroit ();
        typeAyantDroitInstance.setLibelleAyantDroit(Libelle);
        getEntityManager().persist(typeAyantDroitInstance);
    }

    @Override
    public List ListeTypeAyantDroit() {
        List listeDesTypeAyantDroit;
        String tx = "SELECT T FROM TypeAyantDroit AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeAyantDroit=req.getResultList();
        return listeDesTypeAyantDroit;
    }
    
    
    
    
}
