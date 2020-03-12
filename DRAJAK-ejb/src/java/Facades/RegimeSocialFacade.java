/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.RegimeSocial;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Novelzreal
 */
@Stateless
public class RegimeSocialFacade extends AbstractFacade<RegimeSocial> implements RegimeSocialFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegimeSocialFacade() {
        super(RegimeSocial.class);
    }
    
    @Override
    public RegimeSocial CreerRegimeSocial(String libelle, Double plafMois, Double plafJour) {
        RegimeSocial rs = new RegimeSocial();
        rs.setLibelle(libelle);
        rs.setPlafondMensuel(plafMois);
        rs.setPlafondJournalier(plafJour);
        getEntityManager().persist(rs);
        return rs;  
    }

    @Override
    public void ModifierRegimeSocial(RegimeSocial rs) {
        em.merge(rs);
    }
    
    @Override
    public void SupprimerCompteAssure(RegimeSocial rs) {
        em.remove(rs);
    }

    @Override
    public List ListerAllRegimeSocial() {
        List ListerAllRegimeSocial;
        String tx = "SELECT CA FROM CompteAssure AS CA";
        Query req = getEntityManager().createQuery(tx);
        ListerAllRegimeSocial=req.getResultList();
        return ListerAllRegimeSocial;
    }
}
