/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.MemoireTamponPersonne;
import Enum.Genre;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clementratz
 */
@Stateless
public class MemoireTamponPersonneFacade extends AbstractFacade<MemoireTamponPersonne> implements MemoireTamponPersonneFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoireTamponPersonneFacade() {
        super(MemoireTamponPersonne.class);
    }

    @Override
    public MemoireTamponPersonne CreerPersonneTampon(Genre genre, Date dateNaissance) {
        MemoireTamponPersonne personneInstance = new MemoireTamponPersonne();
        personneInstance.setGenre(genre);
        personneInstance.setDateNaissance(dateNaissance);
        em.persist(personneInstance);
        return personneInstance;
    }
    
    
    
}
