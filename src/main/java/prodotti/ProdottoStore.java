/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotti;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author alfonso
 */
@Stateless
@Path("/prodotti")
public class ProdottoStore {

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crea(Prodotto p) {
        if (p.getCodice() == null || p.getCodice().isEmpty()) {
            throw new EJBException("Prodotto con codice vuoto");
        }
        if (findByCodice(p.getCodice()) != null) {
            throw new EJBException("Prodottogià esistente");
        }
        em.persist(p);
        return Response.ok().build();
    }

    @POST
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void crea(@FormParam("cod") String codice,
            @FormParam("descr") String descr,
            @FormParam("prezzo") float prezzo) {;
        Prodotto p = new Prodotto();
        p.setCodice(codice);
        p.setDescrizione(descr);
        p.setPrezzo(prezzo);
        crea(p);
    }

    @GET
    public List<Prodotto> findAll() {
        return em.createQuery("select e from Prodotto e order by e.prezzo desc", Prodotto.class)
                .getResultList();
    }

    @GET
    @Path("/{cod}")
    public Prodotto findByCodice(@PathParam("cod") String codice) {
        return em.find(Prodotto.class, codice);
    }

    @GET
    @Path("/alternativo/{cod}")
    public Prodotto findByCodiceAlternativa(@PathParam("cod") String codice) {
        TypedQuery<Prodotto> query
                = em.createQuery("select e from Prodotto e where e.codice= :cod",
                        Prodotto.class);
        query.setParameter("cod", codice);
        Prodotto result = query.getSingleResult();
        return result;
    }

    public Prodotto findByCodiceAlternativa1(String codice) {
        return em.createQuery("select e from Prodotto e where e.codice= :cod",
                Prodotto.class)
                .setParameter("cod", codice)
                .getSingleResult();
    }

}
