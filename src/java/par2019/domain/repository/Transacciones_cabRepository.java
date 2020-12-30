package par2019.domain.repository;

import java.util.Collection;

/**
 *
 * @author Sourabh Sharma
 * @param <Transacciones_cab>
 * @param <Integer>
 */
public interface Transacciones_cabRepository<Transacciones_cab, Integer> extends Repository<Transacciones_cab, Integer> {

    /**
     *
     * @param id_transaccion  
     * @return
     */
    boolean containsId_transaccion(int id_transaccion);   


    /**
     *
     * @param id_transaccion  
     * @return
     * @throws Exception
     */
  
    
    /**
     *
     * @param id_cliente
     * @return
     * @throws Exception
     */
    public Collection<Transacciones_cab> findById_Cliente(int id_cliente) throws Exception;
    
    /**
     *
     * @param id_transaccion
     * @return
     */
    public Transacciones_cab  gett(int id_transaccion);
    
}
