/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;


import Facades.ContratIndividuelFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author clementratz
 */
@Stateless
public class PubliqueSession implements PubliqueSessionLocal {

    @EJB
    private ContratIndividuelFacadeLocal contratIndividuelFacade;


    @Override
    public void CreerDevis() {
        
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
