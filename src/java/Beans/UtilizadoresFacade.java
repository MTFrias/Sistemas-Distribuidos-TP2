/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Entities.Utilizadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class UtilizadoresFacade extends AbstractFacade<Utilizadores> {

    @PersistenceContext(unitName = "Trabalho_SDPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilizadoresFacade() {
        super(Utilizadores.class);
    }
    
}
