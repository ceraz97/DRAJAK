/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Particulier;
import Enum.Genre;
import Enum.StatutPersonne;
import java.util.Date;
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
public class ParticulierFacade extends AbstractFacade<Particulier> implements ParticulierFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParticulierFacade() {
        super(Particulier.class);
    }
    
    @Override
    public Particulier CreerParticulier(String tel, String adr, String nom, String prenom, Genre genre, Date Dob, StatutPersonne statutPersonne) {
        Particulier p = new Particulier();
        int id = (int)(long)p.getId();
        p.setnAdherent(id);
        p.setnTelephone(tel);
        p.setAdresse(adr);
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setGenre(genre);
        p.setDateNaissance(Dob);
        p.setStatutPeronne(statutPersonne);
        getEntityManager().persist(p);
        return p;  
    }
        
    @Override
    public List ListerAllParticulier() {
        List ListerAllParticulier;
        String tx = "SELECT P FROM Particulier AS P";
        Query req = getEntityManager().createQuery(tx);
        ListerAllParticulier=req.getResultList();
        return ListerAllParticulier;
    }
    
        public void ModifierParticulier(Particulier p) {
        em.merge(p);
        }
        
        public void SupprimerParticulier(Particulier p){
        em.remove(p);
        }
    }
