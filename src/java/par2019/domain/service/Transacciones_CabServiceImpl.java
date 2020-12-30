package par2019.domain.service;

import java.util.ArrayList;
import java.util.Collection;
import par2019.domain.model.entity.Transacciones_cab;

import par2019.domain.repository.Transacciones_cabRepository;
//import par2019product.product.domain.repository.JdbcProductRepository;

/**
 *
 * @author Sourabh Sharma
 */
//@Service("userService")
public class Transacciones_CabServiceImpl extends BaseService<Transacciones_cab, Integer>
        implements Transacciones_cabService {

    private Transacciones_cabRepository<Transacciones_cab, Integer> tCabRepository;
    
    /**
     *
     * @param tCabRepository
     */
    
    //@Autowired
    public Transacciones_CabServiceImpl(Transacciones_cabRepository<Transacciones_cab, Integer> tCabRepository) {
        super(tCabRepository);
        this.tCabRepository = tCabRepository;
    }
   
    @Override
    public ArrayList<Transacciones_cab> getAll() {
        ArrayList<Transacciones_cab> transacciones = (ArrayList) tCabRepository.getAll();
        return transacciones;
    }

    

    @Override
    public void add(Transacciones_cab transacciones_cab) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //super.add(transacciones_cab);
        tCabRepository.add(transacciones_cab);
    }

    @Override
    public void update(Transacciones_cab transacciones_cab) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         tCabRepository.update(transacciones_cab);
    
    }

    @Override
    public void delete(Integer id) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        tCabRepository.remove(id);
    
    }

    @Override
    public Transacciones_cab findById(Integer id_transaccion) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return tCabRepository.gett(id_transaccion);  
    }

    @Override
    public Collection<Transacciones_cab> findId_cliente(Integer Id_cliente) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return tCabRepository.findById_Cliente(Id_cliente);
    }

   



   
}
