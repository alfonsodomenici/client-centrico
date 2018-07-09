/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotti;

import javax.ejb.EJBException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author alfonso
 */
@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException>{

    @Override
    public Response toResponse(EJBException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .header("causato da:", exception.getMessage())
                .build();
    }

    
}
