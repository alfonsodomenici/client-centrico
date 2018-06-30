/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotti;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("/prodotti")
public class ProdottoStore {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    public List<Prodotto> findAll(){
        return em.createQuery("select e from Prodotto e order by e.prezzo desc",Prodotto.class)
                .getResultList();
    }
}