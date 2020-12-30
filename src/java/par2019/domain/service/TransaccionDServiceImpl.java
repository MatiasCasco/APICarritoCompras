/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.service;

import java.util.Collection;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Transacciones_det;
import par2019.domain.repository.Repository;
import par2019.domain.repository.TransaccionDetRepository;


/**
 *
 * @author Alexis
 */
public class TransaccionDServiceImpl extends BaseService<Transacciones_det, Integer>
            implements TransaccionDetService {
    
    private TransaccionDetRepository<Transacciones_det, Integer> transDRepository;
    
    public TransaccionDServiceImpl(TransaccionDetRepository<Transacciones_det, Integer> repository) {
        super(repository);
         this.transDRepository = repository;
    }
    
    @Override
    public void add(Transacciones_det transaccionD) throws Exception{
        // Primero verificamos que la transaccion detalle no exista
        /*if (transDRepository.containsIdTransaccion(transaccionD.getId(),transaccionD.getItem()))  {
            throw new UnsupportedOperationException("Ya existe la transaccion detalle.");
        }
        // Segundo verificamos que el id producto exista
        if (!transDRepository.containsIdProduct(transaccionD.getId_producto())) {
            throw new Exception(String.format("El id producto no existe %d", transaccionD.getId_producto()));
        }*/
        
        super.add(transaccionD);
    }
    
    @Override
    public void update(Transacciones_det transaccionD) throws Exception {
        // Primero debemos verificar que ya exista la transaccion con el item correspondiente
        if (!transDRepository.containsIdTransaccion(transaccionD.getId(), transaccionD.getItem()) ) {
            throw new Exception(String.format("No existe la transaccion con el item %d", transaccionD.getItem()));
        }
        
        transDRepository.update(transaccionD);
    }

    @Override
    public void delete(int id, int item) throws Exception{
        // Primero debemos verificar que ya exista la transaccion con el item correspondiente
        /*if (!transDRepository.containsIdTransaccion(id, item) ) {
            throw new Exception(String.format("No existe la transaccion %d y con el item %d", id, item));
        }*/

        transDRepository.removeTD(id,item);
    }

    @Override
    public Collection<Transacciones_det> findByIdD(Integer id) throws Exception {
        // Primero verificamos si existe el id de la transaccion
        if (!transDRepository.contains(id) ) {
            throw new Exception(String.format("El id no existe %d", id));
        }
       
        return transDRepository.findByDetalle(id);
    }

    @Override
    public Entity findByIdItem(Integer id, Integer item) throws Exception {
        // Primero debemos verificar que ya exista la transaccion con el item correspondiente
        // Primero debemos verificar que ya exista la transaccion con el item correspondiente
         if (!transDRepository.containsIdTransaccion(id, item) ) {
            throw new Exception(String.format("No existe la transaccion %d y con el item %d", id, item));
        }
        
        return transDRepository.getTransD(id, item);
    }

    

    
   

    

}
