package par2019.domain.repository;

import java.util.Collection;

/**
 *
 * @author Sourabh Sharma
 * @param <Product>
 * @param <Integer>
 */
public interface ProductRepository<Product, Integer> extends Repository<Product, Integer> {

    /**
     *
     * @param criteria
  
     * @return
     * @throws java.lang.Exception
     */
   
    public Collection<Product> findByCriteria(String criteria) throws Exception;
    
    /**
     *
     * @param Id
     * @return
     */
    public boolean containsId(int Id);
     /**
     *
     * @param Id_Categoria
     * @return
     */
    public boolean containsId_categoria(int Id_Categoria);

    /**
     *
     * @param descripcion
     * @param precio
     * @return
     * @throws Exception
     */
    public Collection<Product> findByDescripcionCategoria(String descripcion, Integer IdCategoria) throws Exception;
}
