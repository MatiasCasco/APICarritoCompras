/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.service;

import java.util.Collection;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Transacciones_det;


/**
 *
 * @author Alexis
 */
public interface TransaccionDetService {
     /**
     *
     * @param transaccionD
     * @throws Exception
     */
    public void add(Transacciones_det transaccionD) throws Exception;

    /**
     *
     * @param transaccionD
     * @throws Exception
     */
    public void update(Transacciones_det transaccionD) throws Exception;

    /**
     *
     * @param id
     * @param item
     * @throws Exception
     */
    public void delete(int id, int item) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Collection<Transacciones_det> findByIdD(Integer id) throws Exception;

     /**
     *
     * @param id
     * @param item
     * @return
     * @throws Exception
     */
    public Entity findByIdItem(Integer id, Integer item) throws Exception;
}
