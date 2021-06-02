/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.*;

/**
 *
 * @author migue
 */
@Stateless
public class ProdutosBean {

    @PersistenceContext(unitName = "TP2_SDPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Produtos> getProducts() {
        return (List<Produtos>) em.createNamedQuery("Product.findAll").getResultList();
    }

    public Produtos addProduct(Produtos prd) {
        em.persist(prd);
        return prd;
    }
}
