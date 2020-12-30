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
import par2019.domain.model.entity.Transacciones_cab;
import par2019.domain.repository.JdbcTransaccionesCabRepository;
import par2019.domain.service.Transacciones_CabServiceImpl;




/**
 *
 * @author Mauricio
 */
@Path("/tcapi")
public class TransaccionCabRestService {
    
    private final Transacciones_CabServiceImpl tCabService =new Transacciones_CabServiceImpl(new JdbcTransaccionesCabRepository());
//  private final UserServiceImpl userService = new UserServiceImpl(new JdbcUserRepository());
    
    @GET
    @Path("/tcabs")
    @Produces("application/json")
    public ArrayList<Transacciones_cab> getTransaccionesCab() {
        ArrayList<Transacciones_cab> transacciones = (ArrayList) tCabService.getAll();
        return transacciones;
    }

    @GET
    @Path("/tcabs/{id}")
    @Produces("application/json")
    public Transacciones_cab getTransacciones_cab(@PathParam("id") Integer id) {
        Transacciones_cab entity = null;
        try {
            entity = tCabService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionCabRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }

    @POST
    @Path("/tcabs")
    @Consumes("application/json")
    @Produces("application/json")
    public Transacciones_cab addTransacciones_cab(Transacciones_cab entity) {
        try {
            tCabService.add(entity);
       } catch (Exception ex) {
            Logger.getLogger(TransaccionCabRestService.class.getName()).log(Level.SEVERE, null, ex);
       }
        return entity;
    }

    @PUT
    @Path("/tcabs")
    @Consumes("application/json")
    public void updateTransacciones_cab(Transacciones_cab entity) {
        try {
            tCabService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionCabRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/tcabs/{id}")
    public void removeTransacciones_cab(@PathParam("id") Integer id) {
        try {
            tCabService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(TransaccionCabRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
