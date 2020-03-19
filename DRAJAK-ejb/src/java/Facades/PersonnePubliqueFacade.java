/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.Particulier;
import Entity.PersonnePublique;
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
 * @author Novelzreal
 */
@Stateless
public class PersonnePubliqueFacade extends AbstractFacade<PersonnePublique> implements PersonnePubliqueFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnePubliqueFacade() {
        super(PersonnePublique.class);
    }
    @Override
    public PersonnePublique CreerPersonnePublique(String nom, String prenom, Genre genre, Date Dob, String Nsecu, String email, String tel, String adr) {
        PersonnePublique pp = new PersonnePublique();
        pp.setnTelephone(tel);
        pp.setAdresse(adr);
        pp.setNom(nom);
        pp.setPrenom(prenom);
        pp.setGenre(genre);
        pp.setDateNaissance(Dob);
        pp.setStatutPeronne(StatutPersonne.Actif);
        pp.setEmail(email);
        getEntityManager().persist(pp);
        return pp;  
    }
        
    @Override
    public List ListerAllPersonnePublique() {
        List ListerAllPersonnePublique;
        String tx = "SELECT PP FROM PersonnePublique AS PP";
        Query req = getEntityManager().createQuery(tx);
        ListerAllPersonnePublique=req.getResultList();
        return ListerAllPersonnePublique;
    }
    
    public void ModifierPersonnePublique(PersonnePublique pp) {
        em.merge(pp);
        }
        
    public void SupprimerPersonnePublique(PersonnePublique pp){
        em.remove(pp);
        }

    @Override
    public PersonnePublique RechercherPersonnePublique(String nSecu) {
        PersonnePublique pp;
        String txt = "SELECT pp FROM PersonnePublique PP WHERE pp.nSecu=:nSecu ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nSecu", nSecu);
        pp = null;
        List<PersonnePublique> result = req.getResultList();
        if (result.size() == 1) {
            pp = (PersonnePublique) result.get(0);
        }
        return pp;

    }}

