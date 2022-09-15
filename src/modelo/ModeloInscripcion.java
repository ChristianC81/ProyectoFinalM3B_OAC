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
public class ModeloInscripcion extends Inscripcion{
    ModelPGConection mpgc = new ModelPGConection();

    public ModeloInscripcion() {
    }

    public ModeloInscripcion(int idnis, int ndiasparticipacionins, int idproyins, int idpersona) {
        super(idnis, ndiasparticipacionins, idproyins, idpersona);
    }

    // ******   M É T O D O S   C R U D  *************
    public boolean setInscripcion(){
        String sql;
        sql = "INSERT INTO inscripcion (idins,ndiasparticipacionins , idproyins ,idpersona) "
                + "VALUES('" + getIdnis()+ "'"
                + ",'" + getNdiasparticipacionins()+ "'"
                + ",'" + getIdproyins()+ "'"
                + ",'" + getIdpersona()+ "'";
        return mpgc.accion(sql);  //EJECUTAiddonaonaMOS EL INSERT
    }
    
    public boolean eliminar(String id) {
        String sql;
        sql = "delete from inscripcion WHERE idins='" + id + "';";
        return mpgc.accion(sql);

    }
    public boolean modificar(String id) {
        String sql;
        sql = "UPDATE inscripcion SET ndiasparticipacionins ='" + getNdiasparticipacionins()+ "',idproyins ='" + getIdproyins()
                + "',idpersona ='" + getIdpersona()
                + " WHERE idins = '" + id + "';";
        return mpgc.accion(sql);
    }


    public List<Inscripcion> buscarDatosInscripcion(String cadena) {
        List<Inscripcion> listainscripcion = new ArrayList<>();

        String sql = "select * from inscripcion WHERE ";
        sql += " UPPER(ndiasparticipacionins ) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(idproyins ) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(idpersona ) like UPPER('%" + cadena + "%')";

        //System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdnis(rs.getInt("idins"));
                ins.setNdiasparticipacionins(rs.getInt("ndiasparticipacionins "));
                ins.setIdproyins(rs.getInt("idproyins "));
                ins.setIdpersona(rs.getInt("idpersona "));
                listainscripcion.add(ins);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listainscripcion;
    }
    //MANEJAR LOS DATOS DE LA CONEXION DE BASE DE DATOS

    public List<Inscripcion> getInscripcion() {

        List<Inscripcion> listaInscripcion = new ArrayList();
        String sql = "select * from inscripcion";
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setIdnis(rs.getInt("idins"));
                i.setNdiasparticipacionins(rs.getInt("ndiasparticipacionins "));
                i.setIdproyins(rs.getInt("idproyins "));
                i.setIdpersona(rs.getInt("idpersona "));
                
                listaInscripcion.add(i);
            }
            return listaInscripcion;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaInscripcion;
    }
    
    public boolean editarInscripcion() {
        String sql;
        boolean a;
        sql = "UPDATE  inscripcion SET ndiasparticipacionins =?, idproyins =?, idpersona =?\n"
                + "WHERE idins= '"+ getIdnis()+"';";
        
        try {
            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setInt(1, getNdiasparticipacionins());
            ps.setInt(2, getIdproyins());
            ps.setInt(3, getIdpersona());
            ps.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloDonacion.class.getName()).log(Level.SEVERE, null, ex);
            a = false;
        }
        return a;
    }
    
    
    public List<Inscripcion> InscriModif(String texto) {
        List<Inscripcion> listins = new ArrayList<>();
        String sql = "Select * from inscripcion where idins = '" + texto + "'";
        System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
                Inscripcion p = new Inscripcion();
                p.setIdnis(rs.getInt("idins"));
                p.setNdiasparticipacionins(rs.getInt("ndiasparticipacionins"));
                p.setIdproyins(rs.getInt("idproyins "));
                p.setIdpersona(rs.getInt("idpersona "));

                listins.add(p);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listins;
    }
    
}
