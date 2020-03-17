/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.ContratIndividuel;
import Entity.PersonnePhysique;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clementratz
 */
@Stateless
public class PersonnePhysiqueFacade extends AbstractFacade<PersonnePhysique> implements PersonnePhysiqueFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnePhysiqueFacade() {
        super(PersonnePhysique.class);
    }
    

}
