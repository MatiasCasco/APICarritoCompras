package par2019.domain.service;


import java.util.Collection;

import par2019.domain.model.entity.Transacciones_cab;

/**
 *
 * @author Sourabh Sharma
 */
public interface Transacciones_cabService {

    /**
     *
     * @param transacciones_cab
     * @throws Exception
     */
    public void add(Transacciones_cab transacciones_cab) throws Exception;

    /**
     *
     * @param transacciones_cab
     * @throws Exception
     */
    public void update(Transacciones_cab transacciones_cab) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id_transaccion
     * @return
     * @throws Exception
     */
    public Transacciones_cab findById(Integer id_transaccion) throws Exception;

    /**
     *
     * @param Id_cliente
     * @return
     * @throws Exception
     */
    public Collection<Transacciones_cab> findId_cliente(Integer Id_cliente) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    
}
