/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.DomaineProduit;
import Entity.Modules;
import Entity.Produit;
import Enum.TypeProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();

    Produit CreerProduit(TypeProduit typeProduit, String libelle, double fiscalite, DomaineProduit cleDomaineProduit, List<Modules> lesModules);
    
   

    void ModifierProduit(Produit produit);

    void SupprimerProduit(Produit produit);

    List ListerAllProduit();

    
}
