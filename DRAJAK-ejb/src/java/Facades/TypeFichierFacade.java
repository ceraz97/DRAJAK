/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.TypeFichier;
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
public class TypeFichierFacade extends AbstractFacade<TypeFichier> implements TypeFichierFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeFichierFacade() {
        super(TypeFichier.class);
    }

    @Override
    public TypeFichier CreerTypeFichier(String Libelle) {
        TypeFichier typeFichierInstance= new TypeFichier ();
        typeFichierInstance.setLibelleTypeFichier(Libelle);
        getEntityManager().persist(typeFichierInstance);
        return typeFichierInstance;
    }

    @Override
    public List ListerAllTypeFichier() {
        List listeDesTypeFichier;
        String tx = "SELECT T FROM TypeFichier AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeFichier=req.getResultList();
        return listeDesTypeFichier;
    }
    
    
    
    
}
