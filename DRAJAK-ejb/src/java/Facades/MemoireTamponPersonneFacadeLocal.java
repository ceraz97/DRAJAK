/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entity.MemoireTamponPersonne;
import Enum.Genre;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author clementratz
 */
@Local
public interface MemoireTamponPersonneFacadeLocal {

    void create(MemoireTamponPersonne memoireTamponPersonne);

    void edit(MemoireTamponPersonne memoireTamponPersonne);

    void remove(MemoireTamponPersonne memoireTamponPersonne);

    MemoireTamponPersonne find(Object id);

    List<MemoireTamponPersonne> findAll();

    List<MemoireTamponPersonne> findRange(int[] range);

    int count();

    MemoireTamponPersonne CreerPersonneTampon(Genre genre, Date dateNaissance);
    
}
