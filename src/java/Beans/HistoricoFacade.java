/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Historico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinciusrodriguessilvacosta
 */
@Stateless
public class HistoricoFacade extends AbstractFacade<Historico> {

    @PersistenceContext(unitName = "Trabalho_SDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoricoFacade() {
        super(Historico.class);
    }
    
}
