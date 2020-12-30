package par2019.domain.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import par2019.util.DBUtils;
import par2019.domain.model.entity.Entity;
import par2019.domain.model.entity.Transacciones_cab;

/**
 *
 * @author Sourabh Sharma
 */
//@Repository("userRepository")
public class JdbcTransaccionesCabRepository implements Transacciones_cabRepository<Transacciones_cab, Integer> {

    private Map<String, Transacciones_cab> entities;

    @Override
    public boolean containsId_transaccion(int id_transaccion) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       try {
            return this.gett(id_transaccion)!=null;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

  

    @Override
    public Collection<Transacciones_cab> findById_Cliente(int id_cliente) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Collection<Transacciones_cab> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab WHERE id_cliente = ?");

            pstmt.setInt(1, id_cliente);
           
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Transacciones_cab(rs.getInt("id_transaccion"),rs.getDate ("fecha"),rs.getInt ("id_cliente"),rs.getInt ("total"),rs.getString("direccion_envio"),rs.getInt ("id_medio_pago"),rs.getInt ("nro_tarjeta"),rs.getString("estado")));
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
    public void add(Transacciones_cab entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("INSERT INTO  transacciones_cab(fecha,id_cliente,total,direccion_envio,id_medio_pago, nro_tarjeta ,estado) values (?, ?, ?, ?, ?, ?, ?)");
            
            java.util.Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(entity.getFecha());
            java.sql.Date fecha = new java.sql.Date(date1.getTime());
            pstmt.setDate(1, fecha);
            pstmt.setInt(2, entity.getId_cliente());
            pstmt.setInt(3, entity.getTotal());
            pstmt.setString(4, entity.getDireccion_envio());
            pstmt.setInt(5, entity.getId_medio_pago());
            pstmt.setInt(6, entity.getNro_tarjeta());
            pstmt.setString(7, entity.getEstado());

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

    @Override
    public void remove(Integer id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("DELETE FROM transacciones_cab WHERE id_transaccion = ?");

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            /*} catch (Exception e) {
            e.printStackTrace();*/
        } catch (SQLException e) {
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

    @Override
    public void update(Transacciones_cab entity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("UPDATE transacciones_cab SET fecha =?,id_cliente= ?, total= ?,direccion_envio= ?,id_medio_pago= ?,nro_tajeta= ?,estado= ? WHERE id_transaccion = ?");
            
            java.util.Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(entity.getFecha());
            java.sql.Date fecha;
            fecha = new java.sql.Date(date1.getTime());
                        
            
            pstmt.setDate(1, fecha);
            pstmt.setInt(2, entity.getId_cliente());
            pstmt.setInt(3, entity.getTotal());
            pstmt.setString(4, entity.getDireccion_envio());
            pstmt.setInt(5, entity.getId_medio_pago());
            pstmt.setInt(6, entity.getNro_tarjeta());
            pstmt.setString(7, entity.getEstado());
            pstmt.setInt(8, entity.getId_transaccion());

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

    @Override
    public boolean contains(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transacciones_cab  gett(int id_transaccion) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Transacciones_cab  retValue = null;

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab WHERE id_transaccion = ?");

            pstmt.setInt(1, id_transaccion);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                //java.sql.Date sqlf= rs.getDate("fecha");
                //java.util.Date fecha=new java.util.Date(sqlf.getTime());
                //public Transacciones_cab(int id_transaccion, java.util.Date fecha, int id_cliente, int total, String direccion_envio, int id_medio_pago, int nro_tarjeta, String estado) throws ParseException {
    
                retValue = new Transacciones_cab(rs.getInt("id_transaccion"),rs.getDate("fecha") ,rs.getInt ("id_cliente"),rs.getInt ("total"),rs.getString("direccion_envio"),rs.getInt ("id_medio_pago"),rs.getInt ("nro_tarjeta"),rs.getString("estado"));
            }else
            {   
                retValue = new Transacciones_cab(0,null,0,0,null,0,0,null);
           
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
        
        return  retValue;
            
    }

    @Override
    public Collection<Transacciones_cab> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Collection<Transacciones_cab> retValue = new ArrayList();

        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            c = DBUtils.getConnection();
            pstmt = c.prepareStatement("SELECT * FROM transacciones_cab ");

           
            rs = pstmt.executeQuery();

            while (rs.next()) {
                retValue.add(new Transacciones_cab(rs.getInt("id_transaccion"),rs.getDate ("fecha"),rs.getInt ("id_cliente"),rs.getInt ("total"),rs.getString("direccion_envio"),rs.getInt ("id_medio_pago"),rs.getInt ("nro_tarjeta"),rs.getString("estado")));
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
    public Entity get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
