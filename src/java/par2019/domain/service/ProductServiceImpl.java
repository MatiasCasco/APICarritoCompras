package par2019.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Product;
import par2019.domain.repository.ProductRepository;
//import par2019product.product.domain.repository.JdbcProductRepository;

/**
 *
 * @author Sourabh Sharma
 */
//@Service("userService")
public class ProductServiceImpl extends BaseService<Product, Integer>
        implements ProductService {

    private ProductRepository<Product, Integer> productRepository;
   
    
    /**
     *
     * @param productRepository
     */
    //@Autowired
    public ProductServiceImpl(ProductRepository<Product, Integer> productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }



    
    @Override
    public void add(Product product) throws Exception {
        /*if (productRepository.containsId(product.getId())) {
            throw new Exception(String.format("Ya existe un producto con el id %s ", product.getId()));
        }*/
        if (productRepository.containsId_categoria(product.getId_categoria())==false){
            throw new Exception(String.format("no  existe id categoria %s ", product.getId_categoria()));
        }
        if (product.getId() == null) {
            throw new Exception("el id no puede estar vacio");
        }
        
        if (product.getNombre()== null || "".equals(product.getNombre())) {
            throw new Exception("La descripcion no puede ser nulo o cadena vacia.");
        }
        //considerar id categoria y aggregar        //super.add(product);
        productRepository.add(product);
    }

    /**
     *
     * @param criteria
     * @return
     * @throws Exception
     */

    public Collection<Product> findByCriteria(String criteria) throws Exception {
        return productRepository.findByCriteria(criteria);
    }

    /**
     *
     * @param product
     * @throws Exception
     */
    @Override
    public void update(Product product) throws Exception {
        if (productRepository.containsId_categoria(product.getId_categoria())==false){
            throw new Exception(String.format("no  existe id categoria %s ", product.getId_categoria()));
        }
        if (product.getId() == null) {
            throw new Exception("el id no puede estar vacio");
        }
        
        if (product.getNombre()== null || "".equals(product.getNombre())) {
            throw new Exception("La descripcion no puede ser nulo o cadena vacia.");
        }
        productRepository.update(product);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(Integer id) throws Exception {
        if (!productRepository.containsId(id)) {
            throw new Exception(String.format("Ya existe un producto con el id %s ", id));
        }
        productRepository.remove(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(Integer id) throws Exception {
        return productRepository.get(id);
    }

    @Override
    public Collection<Product> findByCriteria(Map<String, ArrayList<String>> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     *
     * @param descripcion
     * @param categoria
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Product> findByDescripcionCategoria(String descripcion, Integer categoria) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return productRepository.findByDescripcionCategoria(descripcion, categoria);
    }

   

}
