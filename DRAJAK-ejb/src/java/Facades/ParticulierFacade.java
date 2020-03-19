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
    public Particulier CreerParticulier(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr) {
        Particulier p = new Particulier();   
        p.setnAdherent(777);
        p.setnTelephone(tel);
        p.setAdresse(adr);
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setGenre(genre);
        p.setDateNaissance(Dob);
        p.setStatutPeronne(StatutPersonne.Actif);
        p.setEmail(email);
        p.setnSecuriteSocial(Nsecu);
        getEntityManager().persist(p);
        return p;  
    }
    
    public void CreerID(Particulier p){
       Long l = p.getId();
       int id = l.intValue();       
       p.setnAdherent(id);   
       em.merge(p);
       getEntityManager().persist(p);
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
    
    @Override
    public Particulier RechercherParticulier(String nSecu) {
        Particulier p;
        String txt = "SELECT p FROM Particulier P WHERE p.nSecu=:nNecu ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nSecu", nSecu);
        p = null;
        List<Particulier> result = req.getResultList();
        if (result.size() == 1) {
            p = (Particulier) result.get(0);
        }
        return p;

    } 
        
    }
