package par2019.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Product;

/**
 *
 * @author Sourabh Sharma
 */
public interface ProductService {

    /**
     *
     * @param product
     * @throws Exception
     */
    public void add(Product product) throws Exception;

    /**
     *
     * @param product
     * @throws Exception
     */
    public void update(Product product) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(Integer id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(Integer id) throws Exception;

    /**
     *
     * @param criteria
     * @return
     * @throws Exception
     */
    public Collection<Product> findByCriteria(Map<String, ArrayList<String>> criteria) throws Exception;

    /**
     *
     * @param descripcion
     * @param categoria
     * @return
     * @throws Exception
     */
    public Collection<Product> findByDescripcionCategoria(String descripcion, Integer categoria) throws Exception;

   
}
