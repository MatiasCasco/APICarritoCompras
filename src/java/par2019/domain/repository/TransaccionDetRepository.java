/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.repository;

import java.util.Collection;
import par2019.domain.model.entity.Entity;





/**
 *
 * @author Matias
 * @param <transacciones_det>
 * @param <Integer>
 */
public interface TransaccionDetRepository<transacciones_det, Integer> extends Repository<transacciones_det, Integer> {
     /**
     *
     * @param id
     * @param item
     * @return
     */
    boolean containsIdTransaccion(Integer id, Integer item);
    
     /**
     *
     * @param id
     * @return
     */
    boolean containsIdProduct(Integer id);
    /**
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    public Collection<transacciones_det> findByDetalle(int id) throws Exception;

    
    /**
     *
     * @param id_transaccion
     * @param item
     */
    void removeTD(int id_transaccion, int item);
    
    public Entity getTransD(Integer id, Integer item);

    
}
