/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
public class ModeloProducto extends Producto{

    ModelPGConection mpgc = new ModelPGConection();

    public ModeloProducto() {
    }

    public ModeloProducto(int idprod, int cantprod, String tipoprod, int iddonaprod, int idproyprod) {
        super(idprod, cantprod, tipoprod, iddonaprod, idproyprod);
    }

    // manejar los datos de la conecxion de base dedatos 
    public boolean setProducto() {
        String sql = "Insert into producto (cantidadprod,tipoprod,iddonaprod,idproyprod)"
                + "values ('" + getCantprod() + "'"
                + ",'" + getTipoprod() + "'"
                + ",'" + getIddonaprod() + "'"
                + ",'" + getIdproyprod() + "')";
        return mpgc.accion(sql);// se ejecuta el insert
    }

    public boolean updateProducto(int id) {
        String sql = "update producto set cantidadprod='" + getCantprod()
                + "',tipoprod='" + getTipoprod() + "',iddonaprod='" + getIddonaprod()
                + "',idproyprod='" + getIdproyprod()
                + "' where idprod='" + id + "'; ";
        return mpgc.accion(sql);// se ejecuta el update
    }

    public boolean deletePersona(int id) {
        String sql = "delete from producto where idprod='" + id + "'; ";
        return mpgc.accion(sql);// se ejecuta el delete
    }

    public List<Producto> getProducto() {
        List<Producto> listprod = new ArrayList<>();
        String sql = "select * from producto";
        ResultSet rs = mpgc.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdprod(rs.getInt("idprod"));
                p.setCantprod(rs.getInt("cantidadprod"));
                p.setTipoprod(rs.getString("tipoprod"));
                p.setIddonaprod(rs.getInt("iddonaprod"));
                p.setIdproyprod(rs.getInt("idproyprod"));
                listprod.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, e);
        }

        return listprod;
    }

    public List<Producto> buscaProducto(String texto) {
        List<Producto> listproducto = new ArrayList<>();
        String sql = "select * from productos where tipoprod LIKE '%" + texto + "%'";
        System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdprod(rs.getInt("idprod"));
                p.setCantprod(rs.getInt("cantidadprod"));
                p.setTipoprod(rs.getString("tipoprod"));
                p.setIddonaprod(rs.getInt("iddonaprod"));
                p.setIdproyprod(rs.getInt("idproyprod"));
                listproducto.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listproducto;
    }

    public List<Producto> productoModif(int texto) {
        List<Producto> listProducto = new ArrayList<>();
        String sql = "Select * from producto where idprod = '" + texto + "'";
        byte[] bytea;
        System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdprod(rs.getInt("idprod"));
                p.setCantprod(rs.getInt("cantidadprod"));
                p.setTipoprod(rs.getString("tipoprod"));
                p.setIddonaprod(rs.getInt("iddonaprod"));
                p.setIdproyprod(rs.getInt("idproyprod"));
                listProducto.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listProducto;
    }

}
