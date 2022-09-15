/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
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
public class ModeloProyecto extends Proyecto {

    ModelPGConection mpgc = new ModelPGConection();

    public ModeloProyecto() {
    }

    public ModeloProyecto(int idproy, String nombreproy, java.util.Date fechainicioproy, java.util.Date fechafinproy, String lugarproy, int idpersona) {
        super(idproy, nombreproy, fechainicioproy, fechafinproy, lugarproy, idpersona);
    }

    // ******   M É T O D O S   C R U D  *************
    public boolean setProyecto() {
        String sql;
        sql = "INSERT INTO proyecto(idproy, nombreproy, fechainicioproy,fechafinproy,lugarproy,idpersona) "
                + "VALUES('" + getIdproy() + "'"
                + ",'" + getNombreproy() + "'"
                + ",'" + getFechainicioproy() + "'"
                + ",'" + getFechafinproy() + "'"
                + ",'" + getLugarproy() + "'"
                + ",'" + getIdpersona() + "')";
        return mpgc.accion(sql);
    }

    public boolean eliminarProyecto(String id) {
        String sql;
        sql = "delete from proyecto WHERE idproy='" + id + "';";
        return mpgc.accion(sql);

    }

    public boolean modificarProyecto() {
        String sql;
        sql = "UPDATE proyecto SET nombreproy='" + getNombreproy() + "',fechainicioproy='" + getFechainicioproy()
                + "',fechafinproy='" + getFechafinproy() + "',lugarproy='" + getLugarproy() + "',idpersona='" + getIdpersona()
                + " WHERE iddona = '" + getIdproy() + "';";
        return mpgc.accion(sql);
    }

    public List<Proyecto> buscarDatosProyecto(String atributo) {
        List<Proyecto> listaProyecto = new ArrayList<>();

        String sql = "select * from proyecto where idproy like ('" + atributo + "%') or lower(nombreproy) like ('" + atributo + "%') or fechainicioproy like ('" + atributo + "%')or fechafinproy like ('" + atributo + "%')or lower(lugarproy) like ('" + atributo + "%')or idpersona like ('" + atributo + "%')";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Proyecto proye = new Proyecto();
                proye.setIdproy(rs.getInt("idproy"));
                proye.setNombreproy(rs.getString("nombreproy"));
                proye.setFechainicioproy(rs.getDate("fechainicioproy"));
                proye.setFechafinproy(rs.getDate("fechafinproy"));
                proye.setLugarproy(rs.getString("lugarproy"));
                proye.setIdpersona(rs.getInt("idpersona"));

                listaProyecto.add(proye);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaProyecto;
    }

    public List<Proyecto> getProyecto() {

        List<Proyecto> listaProyecto = new ArrayList();
        String sql = "select * from proyecto";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Proyecto proye = new Proyecto();
                proye.setIdproy(rs.getInt("idproy"));
                proye.setNombreproy(rs.getString("nombreproy"));
                proye.setFechainicioproy(rs.getDate("fechainicioproy"));
                proye.setFechafinproy(rs.getDate("fechafinproy"));
                proye.setLugarproy(rs.getString("lugarproy"));
                proye.setIdpersona(rs.getInt("idpersona"));

                listaProyecto.add(proye);
            }
            return listaProyecto;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProyecto;
    }

    public boolean editarProyecto() {
        String sql;

        sql = "update proyecto set nombreproy=?,"
                + "fechainicioproy=?,"
                + "fechafinproy=?,"
                + "lugarproy=?,"
                + "sidpersona=?,"
                + "where idproy ='" + getIdproy() + "';";

        try {
            long time = getFechainicioproy().getTime();
            java.sql.Date fechainicio = new java.sql.Date(time);

            long time2 = getFechafinproy().getTime();
            java.sql.Date fechafin = new java.sql.Date(time2);

            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setString(1, getNombreproy());
            ps.setDate(2, fechainicio);
            ps.setDate(3, fechafin);
            ps.setString(4, getLugarproy());
            ps.setInt(5, getIdpersona());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Proyecto> ModiProye(String texto) {
        List<Proyecto> listaProye = new ArrayList<>();
        String sql = "Select * from proyecto where idproy = '" + texto + "'";
        System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Proyecto proye = new Proyecto();
                proye.setIdproy(rs.getInt("idproy"));
                proye.setNombreproy(rs.getString("nombreproy"));
                proye.setFechainicioproy(rs.getDate("fechainicioproy"));
                proye.setFechafinproy(rs.getDate("fechafinproy"));
                proye.setLugarproy(rs.getString("lugarproy"));
                proye.setIdpersona(rs.getInt("idpersona"));

                listaProye.add(proye);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listaProye;
    }

}
