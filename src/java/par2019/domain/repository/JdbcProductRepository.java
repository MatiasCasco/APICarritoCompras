package par2019.domain.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import par2019.util.DBUtils;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Product;

/**
 *
 * @author Sourabh Sharma
 */
//@Repository("userRepository")
public class JdbcProductRepository implements ProductRepository<Product, Integer> {

                 
    
    private Map<String, Product> entities;

    public JdbcProductRepository(Map<String, Product> entities) {
        this.entities = entities;
    }

    public JdbcProductRepository() {
    }
   

  
    
   
   
    public Collection<Product> findById(int id_producto) throws Exception {
        Collection<Product> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto WHERE id_producto = ?");

            pstmt.setInt(1, id_producto);

            rs = pstmt.executeQuery();

            if (rs.next()) {
               retValue.add(new Product(rs.getInt ("id_producto"), rs.getString("descripcion"),rs.getInt("id_categoria"),rs.getInt("precio_unit"),rs.getInt ("cantidad")));
          }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void add(Product entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO producto (descripcion,id_categoria,precio_unit,cantidad) values (?, ?, ?, ?)");

           // pstmt.setInt(1, entity.getId());
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getId_categoria());
            pstmt.setInt(3, entity.getPrecio_unit());
            pstmt.setInt(4, entity.getCantidad());
            //pstmt.setDouble(0, 0);
            
            pstmt.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param id
     */
    @Override
    public void remove(Integer id) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM producto WHERE id_producto = ?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void update(Product entity) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE producto SET descripcion = ?,id_categoria = ?,precio_unit = ?,cantidad = ? WHERE id_producto = ?");

            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getId_categoria());
            pstmt.setInt(3, entity.getPrecio_unit());
            pstmt.setInt(4, entity.getCantidad());
            pstmt.setInt(5, entity.getId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean contains(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Entity get(Integer id) {
        Entity retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto WHERE id_producto = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                retValue = new Product(rs.getInt ("id_producto"), rs.getString("descripcion"),rs.getInt("id_categoria"),rs.getInt("precio_unit"),rs.getInt ("cantidad"));
         
            } else {
                retValue = new Product(0,null,0,0,0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Product> getAll() {
        Collection<Product> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt ("id_producto"), rs.getString("descripcion"),rs.getInt("id_categoria"),rs.getInt("precio_unit"),rs.getInt ("cantidad")));
         
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    /**
     *
     * @param criteria
     * @return
     * @throws Exception
     */
    
    

    @Override
    public Collection<Product> findByCriteria(String criteria) throws Exception {
        Collection<Product> retValue = new ArrayList();
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto WHERE lower(descripcion) like ?");
            String a ="%"+criteria.toLowerCase()+"%";
            pstmt.setString(1, a);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt ("id_producto"), rs.getString("descripcion"),rs.getInt("id_categoria"),rs.getInt("precio_unit"),rs.getInt ("cantidad")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

   
    @Override
    public boolean containsId_categoria(int Id_Categoria) {
        try {
            Entity retValue = null;   
            Connection c = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM  categoria where id_categoria= ?");

            pstmt.setInt(1, Id_Categoria);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(JdbcProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean containsId(int Id) {
        try {
            
            return findById(Id).size()>0;
        } catch (Exception ex) {
            Logger.getLogger(JdbcProductRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
     }
     

    
    
    
    
    
  

    @Override
    public Collection<Product> findByDescripcionCategoria(String descripcion, Integer IdCategoria) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Collection<Product> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto WHERE descripcion like ? and id_categoria = ? order by descripcion");
            String a = descripcion+"%";
            pstmt.setString(1, a);
            pstmt.setInt(2, IdCategoria);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Product(rs.getInt("id_producto"), rs.getString("descripcion"), rs.getInt("id_categoria"),  rs.getInt("precio_unit"), rs.getInt("cantidad")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                DBUtils.closeConnection(c);
            } catch (SQLException ex) {
                //Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }
}
