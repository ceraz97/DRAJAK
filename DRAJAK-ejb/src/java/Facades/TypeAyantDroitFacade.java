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
    public TypeAyantDroit CreerTypeAyantDroit(String Libelle) {
        TypeAyantDroit typeAyantDroitInstance= new TypeAyantDroit ();
        typeAyantDroitInstance.setLibelleAyantDroit(Libelle);
        getEntityManager().persist(typeAyantDroitInstance);
        return typeAyantDroitInstance;
    }

    @Override
    public List ListerAllTypeAyantDroit() {
        List listeDesTypeAyantDroit;
        String tx = "SELECT T FROM TypeAyantDroit AS T";
        Query req = getEntityManager().createQuery(tx);
        listeDesTypeAyantDroit=req.getResultList();
        return listeDesTypeAyantDroit;
    }

    @Override
    public TypeAyantDroit RechercherTypeAyantDroitParId(long id) {
        TypeAyantDroit TypeAyantDroitRecherche;
        String tx = "SELECT t FROM TypeAyantDroit AS t WHERE t.id=:idType";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("idType", id);
        TypeAyantDroitRecherche = (TypeAyantDroit)req.getSingleResult();
        return TypeAyantDroitRecherche;
    }
    
    
    @Override
    public TypeAyantDroit RechercherTypeAyantDroitParLibelle(String libelle) {
        TypeAyantDroit TypeAyantDroitRecherche;
        String tx = "SELECT t FROM TypeAyantDroit AS t WHERE t.libelleAyantDroit=:libelle";
        Query req = getEntityManager().createQuery(tx);
        req.setParameter("libelle", libelle);
        TypeAyantDroitRecherche = (TypeAyantDroit)req.getSingleResult();
        return TypeAyantDroitRecherche;
    }
    
}
