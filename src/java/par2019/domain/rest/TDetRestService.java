/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import par2019.domain.model.entity.Transacciones_det;
import par2019.domain.repository.JdbcTransaccionDetRepository;
import par2019.domain.service.TransaccionDServiceImpl;


//import par2019.user.domain.repository.InMemUserRepository;

/**
 *
 * @author Mauricio
 */
@Path("/tdapi")
public class TDetRestService {

    private final TransaccionDServiceImpl transacciones_detService = new TransaccionDServiceImpl (new JdbcTransaccionDetRepository());

    /**
     *
     * @return
     */
    @GET
    @Path("/transacciones_det")
    @Produces("application/json")
    public ArrayList<Transacciones_det> getTDet() {
        ArrayList<Transacciones_det> transacciones_det = (ArrayList) transacciones_detService.getAll();
        return transacciones_det;
    }

    @GET
    @Path("/transacciones_det/{id}/nitem/{item}")
    @Produces("application/json")
    public Transacciones_det getTransacciones_det(@PathParam("id") Integer id,@PathParam("item") Integer item) {
        Transacciones_det entity = null;
        try {
            entity = (Transacciones_det) transacciones_detService.findByIdItem(id, item);
        } catch (Exception ex) {
            Logger.getLogger(TDetRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/transacciones_det")
    @Consumes("application/json")
    @Produces("application/json")
    public Transacciones_det addTDet(Transacciones_det entity) {
        try {
            transacciones_detService.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(TDetRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    /**
     *
     * @param entity
     */
    @PUT
    @Path("/transacciones_det")
    @Consumes("application/json")
    public void updateTDet(Transacciones_det entity) {
        try {
            transacciones_detService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(TDetRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//?id=1&item=2
    @DELETE
    @Path("/transacciones_det/{id}/nitem/{item}")
    public void removeTDet(@PathParam("id") Integer id,@PathParam("item") Integer item) {
        //String [] part=pt.split("_");
//        int id= 1;
  //      int item=3;
        try {
            transacciones_detService.delete(id, item);
        } catch (Exception ex) {
            Logger.getLogger(TDetRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
