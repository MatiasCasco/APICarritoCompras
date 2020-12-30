/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.rest;

import java.util.ArrayList;
import java.util.Collection;
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
import par2019.domain.model.entity.Product;

import par2019.domain.repository.JdbcProductRepository;

import par2019.domain.service.ProductServiceImpl;


/**
 *
 * @author Mauricio
 */
@Path("/productapi")
public class ProductRestService {

    private final ProductServiceImpl productService = new ProductServiceImpl(new JdbcProductRepository());

    @GET
    @Path("/products")
    @Produces("application/json")
    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = (ArrayList) productService.getAll();
        return products;
    }

    @GET
    @Path("/products/{id}")
    @Produces("application/json")
    public Product getProduct(@PathParam("id") Integer id) {
        Product entity = null;
        try {
            entity = (Product) productService.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
    @GET
    @Path("/products/criteria/{descripcion}")
    @Produces("application/json")
    public ArrayList getProductc(@PathParam("descripcion") String descripcion) throws Exception {
         ArrayList<Product> products = (ArrayList) productService.findByCriteria(descripcion);
        return products;
    }
    
    @GET
    @Path("/products/criteria/{descripcion}/categoria/{idCategoria}")
    @Produces("application/json")
    public ArrayList getProductXC(@PathParam("descripcion") String descripcion,@PathParam("idCategoria") Integer idCategoria) throws Exception {
         ArrayList<Product> products = (ArrayList) productService.findByDescripcionCategoria(descripcion, idCategoria);
        return products;
    }
    
    @POST
    @Path("/products")
    @Consumes("application/json")
    @Produces("application/json")
    public Product addProduct(Product entity) throws Exception {
        
            productService.add(entity);
        
        return entity;
    }

    @PUT
    @Path("/products")
    @Consumes("application/json")
    public void updateProduct(Product entity) {
        try {
            productService.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("/products/{id}")
    public void removeProduct(@PathParam("id") Integer id) {
        try {
            productService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(ProductRestService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
