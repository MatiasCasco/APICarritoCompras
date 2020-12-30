/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019.domain.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Transacciones_det;
import par2019.util.DBUtils;

/**
 *
 * @author Matias
 */
public class JdbcTransaccionDetRepository implements TransaccionDetRepository<Transacciones_det, Integer>  {

   
    
    
    
    @Override
    public boolean containsIdTransaccion(Integer id, Integer item) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_det WHERE id_transaccion = ? and item = ?");

            pstmt.setInt(1, id);
            pstmt.setInt(2, item);
            // ver si no necesita item
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
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
        return false;
    }

    @Override
    public boolean containsIdProduct(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM producto WHERE id_producto = ?");

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
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
         return false;
        }
    }

    @Override
    public Collection<Transacciones_det> findByDetalle(int id) throws Exception {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Transacciones_det> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab WHERE id_transaccion = ?");
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                                                    
                retValue.add(new Transacciones_det( rs.getInt("id_transaccion"),rs.getInt("item"), rs.getInt("id_producto"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("sub_total")));
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
               // Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public void add(Transacciones_det entity) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO transacciones_det(id_transaccion, item, id_producto, cantidad, precio, sub_total)  values ((select max(id_transaccion) from transacciones_cab), ((select count(item) from transacciones_det where id_transaccion = (select max(id_transaccion) from transacciones_cab))+1), ?, ?, ?, ?)");

           // pstmt.setInt(1, entity.getId());
            //pstmt.setInt(1, entity.getId());
            pstmt.setInt(1, entity.getId_producto());
            pstmt.setInt(2, entity.getCantidad());
            pstmt.setInt(3, entity.getPrecio());
            pstmt.setInt(4, entity.getSubtotal());
            
            
            pstmt.execute();
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
// No se implementa remove aqui
    @Override
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Transacciones_det entity) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE transacciones_det SET id_producto = ?, cantidad = ?, precio = ?, sub_total = ? WHERE id_transaccion = ? and item = ?");

            pstmt.setInt(1, entity.getId_producto());
            pstmt.setInt(2, entity.getCantidad());
            pstmt.setInt(3, entity.getPrecio());
            pstmt.setInt(4, entity.getSubtotal());
            pstmt.setInt(5, entity.getId());
            pstmt.setInt(6, entity.getItem());
            
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
// No se implementa aqui
    @Override
    public boolean contains(Integer id) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_det WHERE id_transaccion = ?");

            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
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
        return false;           
    }
// No se implementa aqui


    @Override
    public Collection<Transacciones_det> getAll() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Collection<Transacciones_det> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_det");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                                                    
                retValue.add(new Transacciones_det( rs.getInt("id_transaccion"),rs.getInt("item"), rs.getInt("id_producto"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("sub_total")));
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
               // Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }

    @Override
    public void removeTD(int id, int item) {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM transacciones_det WHERE id_transaccion = ? and item = ?");

            pstmt.setInt(1, id);
            pstmt.setInt(2, item);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        //} catch (SQLException e) {
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
    

 
    public Entity getTransD(Integer id, Integer item) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Entity retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
       
        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_det WHERE id_transaccion = ? and item = ?");

            pstmt.setInt(1, id);
            pstmt.setInt(2, item);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // int item, int id_producto, int cantidad, int precio, int subtotal, Integer id
                retValue = new Transacciones_det( rs.getInt("id_transaccion"),rs.getInt("item"), rs.getInt("id_producto"), rs.getInt("cantidad"), rs.getInt("precio"), rs.getInt("sub_total"));
            
            } else {
                retValue = new Transacciones_det(0, 0, 0, 0, 0, 0);
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
               // Logger.getLogger(UsuarioManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return retValue;
    }
   // este es ara cabecera
    

    @Override
    public Entity get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}
