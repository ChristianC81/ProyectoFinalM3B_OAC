/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laptop
 */
public class ModeloPersona {
//    
//    // ******   M É T O D O S   C R U D  *************
//    public boolean setDonacion(){
//        String sql;
//        sql = "INSERT INTO donacion (iddona,detalleproductodona, fechaentregadona,motivodona,iddona) "
//                + "VALUES('" + getIddonacion()+ "'"
//                + ",'" + getDetallePro()+ "'"
//                + ",'" + getFechaEntrega()+ "'"
//                + ",'" + getMotivodonacion()+ "'"
//                + ",'" + getIddonacion()+"')";
//        return mpgc.accion(sql);  //EJECUTAiddonaonaMOS EL INSERT
//    }
//    
//    public boolean eliminar(String id) {
//        String sql;
//        sql = "delete from donacion WHERE iddona='" + id + "';";
//        return mpgc.accion(sql);
//
//    }
//    public boolean modificar(String id) {
//        String sql;
//        sql = "UPDATE donacion SET detalleproductodona='" + getDetallePro()+ "',fechaentregadona='" + getFechaEntrega()
//                + "',motivodona='" + getMotivodonacion()+ "',iddona='" + getIddonacion()
//                + " WHERE iddona = '" + id + "';";
//        return mpgc.accion(sql);
//    }
//
//
//    public List<Donacion> buscarDatosDonacion(String cadena) {
//        List<Donacion> listadonacion = new ArrayList<>();
//
//        String sql = "select * from donacion WHERE ";
//        sql += " UPPER(iddona) like UPPER('%" + cadena + "%')OR";
//        sql += " UPPER(detalleproductodona) like UPPER('%" + cadena + "%') OR";
//        sql += " UPPER(fechaentregadona) like UPPER('%" + cadena + "%') OR";
//        sql += " UPPER(motivodona) like UPPER('%" + cadena + "%') OR";
//        sql += " UPPER(iddonaona) like UPPER('%" + cadena + "%')";
//
//        //System.out.println(sql);
//        ResultSet rs = mpgc.consulta(sql);
//        try {
//            while (rs.next()) {
//                Donacion dona = new Donacion();
//                dona.setIddonacion(rs.getInt("iddona"));
//                dona.setDetallePro(rs.getString("detalleproductodona"));
//                dona.setFechaEntrega(rs.getDate("fechaentregadona"));
//                dona.setMotivodonacion(rs.getString("motivodona"));
//                dona.setIdpersona(rs.getInt("idpersona"));
//                listadonacion.add(dona);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return listadonacion;
//    }
//    //MANEJAR LOS DATOS DE LA CONEXION DE BASE DE DATOS
//
//    public List<Donacion> getDonacion() {
//
//        List<Donacion> listaDonacion = new ArrayList();
//        String sql = "select * from donacion";
//        ResultSet rs = mpgc.consulta(sql);
//        try {
//            while (rs.next()) {
//                Donacion dona = new Donacion();
//                dona.setIddonacion(rs.getInt("iddona"));
//                dona.setDetallePro(rs.getString("detalleproductodona"));
//                dona.setFechaEntrega(rs.getDate("fechaentregadona"));
//                dona.setMotivodonacion(rs.getString("motivodona"));
//                dona.setIdpersona(rs.getInt("idpersona"));
//                
//                listaDonacion.add(dona);
//            }
//            return listaDonacion;
//        } catch (SQLException ex) {
//            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            rs.close();//cierro conexion BD
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return listaDonacion;
//    }
//    
//    public boolean editarDonacion() {
//        String sql;
//        boolean a;
//        /*UPDATE public.donaona
//	SET iddonaona=?, nombres=?, apellidos=?, fecha_nacimiento=?, telefono=?, sexo=?, sueldo=?, cupo=?, foto=?
//	WHERE <condition>;*/
//        sql = "UPDATE  donacion SET detalleproductodona=?, fechaentregadona=?, motivodona=?, idpersona=?\n"
//                + "WHERE iddona= '"+ getIddonacion()+"';";
//        
//        try {
//            long time = getFechaEntrega().getTime();
//            java.sql.Date date1 = new java.sql.Date(time);
//
//            PreparedStatement ps = mpgc.con.prepareStatement(sql);
//            ps.setString(1, getDetallePro());
//            ps.setDate(2, date1);
//            ps.setString(3, getMotivodonacion());
//            ps.setInt(4, getIdpersona());
//            ps.executeUpdate();
//            a = true;
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
//            a = false;
//        }
//        return a;
//    }
//    
//    
//    public List<Donacion> DonaModif(String texto) {
//        List<Donacion> listdona = new ArrayList<>();
//        String sql = "Select * from donacion where iddona = '" + texto + "'";
//        System.out.println(sql);
//        ResultSet rs = mpgc.consulta(sql);
//        try {
//            while (rs.next()) {
//                Donacion p = new Donacion();
//                p.setIddonacion(rs.getInt("iddona"));
//                p.setDetallePro(rs.getString("detalleproductodona"));
//                p.setFechaEntrega(rs.getDate("fechaentregadona"));
//                p.setMotivodonacion(rs.getString("motivodona"));
//                p.setIdpersona(rs.getInt("idpersona"));
//
//                listdona.add(p);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return listdona;
//    }
//    
}
