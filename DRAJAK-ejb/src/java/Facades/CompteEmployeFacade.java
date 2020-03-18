/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.CompteEmploye;
import Enum.Genre;
import Enum.Role;
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
public class CompteEmployeFacade extends AbstractFacade<CompteEmploye> implements CompteEmployeFacadeLocal {

    @PersistenceContext(unitName = "DRAJAK-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteEmployeFacade() {
        super(CompteEmploye.class);
    }
    
    @Override
    public CompteEmploye AuthentifierCompteEmploye(String login, String mdp) {
        CompteEmploye ce;
        String txt = "SELECT log FROM CompteEmploye AS log WHERE log.login=:Login and log.Mdp=:mdp";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("Login", login);
        req = req.setParameter("Mdp", mdp);
        ce = null;
        List<CompteEmploye> result = req.getResultList();
        if (result.size() == 1) {
            ce = (CompteEmploye) result.get(0);
        }
        return ce;
    }

    @Override
    public CompteEmploye CreerCompteEmploye(String login, String mdp, String nom, String prenom, Genre genre, Date Dob, String email, String tel, String adr, Role role, StatutPersonne statutPersonne) {
        CompteEmploye ce = new CompteEmploye();

        ce.setLogin(login);
        ce.setMdp(mdp);
        ce.setNom(nom);
        ce.setPrenom(prenom);  
        ce.setGenre(genre);   
        ce.setDateNaissance(Dob);
        ce.setEmail(email);
        ce.setnTelephone(tel);
        ce.setAdresse(adr);
        ce.setRoleEmploye(role);
        ce.setStatutPeronne(statutPersonne);
        
       String IniP = ce.getPrenom();
       String IniN = ce.getNom();
       String InitialP = prenom.substring(0,1);
       String InitialN = nom.substring(0,1);
       ce.setCodeEmploye(IniP+IniN+"0");

        getEntityManager().persist(ce);
        return ce;  
    }

    public void CreerID(CompteEmploye ce){
//Création du code employé avec la première lettre du Nom, puis prenom, puis l'ID de la personne
//Ne peut pas être dans le méthode CreerCompteEmploye sous peine d'avoir un ID null
       Long l = ce.getId();
       String id = String.valueOf(l);       
       String prenom = ce.getPrenom();
       String nom = ce.getNom();
       String IniP = prenom.substring(0,1);
       String IniN = nom.substring(0,1);
       String code = IniP+IniN+id;
       ce.setCodeEmploye(code);   
       em.merge(ce);
       getEntityManager().persist(ce);
    }
    
    @Override
    public void ModifierCompteEmploye(CompteEmploye ce) {    
       em.merge(ce);
    }
    
    @Override
    public void SupprimerCompteEmploye(CompteEmploye ce) {
        em.remove(ce);
    }

    @Override
    public List ListerAllCompteEmploye() {
        List ListerAllCompteEmploye;
        String tx = "SELECT CE FROM CompteEmploye AS CA";
        Query req = getEntityManager().createQuery(tx);
        ListerAllCompteEmploye=req.getResultList();
        return ListerAllCompteEmploye;
    }
    
    @Override
    public CompteEmploye RechercherEmploye(String login) {
        CompteEmploye ce;
        String txt = "SELECT ce FROM CompteEmploye CE WHERE ce.login=:login ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("login", login);
        ce = null;
        List<CompteEmploye> result = req.getResultList();
        if (result.size() == 1) {
            ce = (CompteEmploye) result.get(0);
        }
        return ce;

    }
}
