/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Laptop
 */
public class ModeloPersona extends Persona {

    ModelPGConection mpgc = new ModelPGConection();

    public ModeloPersona() {
    }

    public ModeloPersona(int idper, String cedulaper, String tipoper, String nombresper, String apellidosper, String direccionper, String telefonoper, String correoper, String generoper, Date fechaNacimiento, String estadoCivil, double salariobenefac, String estratoSbenefi, String titulo, String seguro, String horario, String periodovol, String tipovol, Image fotop, FileInputStream imageFile, int length) {
        super(idper, cedulaper, tipoper, nombresper, apellidosper, direccionper, telefonoper, correoper, generoper, fechaNacimiento, estadoCivil, salariobenefac, estratoSbenefi, titulo, seguro, horario, periodovol, tipovol, fotop, imageFile, length);
    }

    // ******   M É T O D O S   C R U D  *************

    public boolean setPersonaFoto() {
        String sql;
        boolean a;
        sql = "INSERT INTO persona(\n"
                + "idper, cedulaper, tipoper, nombresper, apellidosper, direccionper, telefonoper, correoper, generoper, fechaNacimiento, estadoCivil, salariobenefac, estratoSbenefi, titulo, seguro, horario, periodovol, tipovol, fotop)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        System.out.println(sql);
        try {

            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setInt(1, getIdper());
            ps.setString(2, getCedulaper());
            ps.setString(3, getTipoper());
            ps.setString(4, getNombresper());
            ps.setString(5, getApellidosper());
            ps.setString(6, getDireccionper());
            ps.setString(7, getTelefonoper());
            ps.setString(8, getCorreoper());
            ps.setString(9, getGeneroper());
            ps.setDate(10, getFechaNacimiento());
            ps.setString(11, getEstadoCivil());
            ps.setDouble(12, getSalariobenefac());
            ps.setString(13, getEstratoSbenefi());
            ps.setString(14, getTitulo());
            ps.setString(15, getSeguro());
            ps.setString(16, getHorario());
            ps.setString(17, getPeriodovol());
            ps.setString(18, getTipovol());
            ps.setBinaryStream(19, getImageFile(), getLength());
            ps.executeUpdate();
            System.out.println(ps.toString());
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            a = false;
        }
        return a;
    }

    public boolean editPersonaFoto() {
        String sql;
        boolean a;

        sql =  "UPDATE persona(\n"
                + "SET idper=?, cedulaper=?, tipoper=?, nombresper=?, apellidosper=?, direccionper=?, telefonoper=?, correoper=?, generoper=?, fechaNacimiento=?, estadoCivil=?, salariobenefac=?, estratoSbenefi=? , titulo=?, seguro=?, horario=?, periodovol=?, tipovol=?"
                + "fotop='"
                + "WHERE idper='" + getIdper() + "';";
        try {
           
            PreparedStatement ps = mpgc.con.prepareStatement(sql);
            ps.setInt(1, getIdper());
            ps.setString(2, getCedulaper());
            ps.setString(3, getTipoper());
            ps.setString(4, getNombresper());
            ps.setString(5, getApellidosper());
            ps.setString(6, getDireccionper());
            ps.setString(7, getTelefonoper());
            ps.setString(8, getCorreoper());
            ps.setString(9, getGeneroper());
            ps.setDate(10, getFechaNacimiento());
            ps.setString(11, getEstadoCivil());
            ps.setDouble(12, getSalariobenefac());
            ps.setString(13, getEstratoSbenefi());
            ps.setString(14, getTitulo());
            ps.setString(15, getSeguro());
            ps.setString(16, getHorario());
            ps.setString(17, getPeriodovol());
            ps.setString(18, getTipovol());
            ps.setBinaryStream(19, getImageFile(), getLength());
            ps.executeUpdate();
            a = true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            a = false;
        }
        return a;
    }

     public List<Persona> getPersonas() {

        List<Persona> ListaPersonas = new ArrayList<Persona>();
        byte[] bytea;
        String sql = "select * from persona";
        ResultSet rs = mpgc.consulta(sql);

        try {
            while (rs.next()) {
                Persona p = new Persona();
                p.setIdper(rs.getInt("idper"));
                p.setCedulaper(rs.getString("cedulaper"));
                p.setTipoper(rs.getString("tipoper"));
                p.setNombresper(rs.getString("nombresper"));
                p.setApellidosper(rs.getString("apellidosper"));
                p.setDireccionper(rs.getString("direccionper"));
                p.setTelefonoper(rs.getString("telefonoper"));
                p.setCorreoper(rs.getString("correoper"));
                p.setGeneroper(rs.getString("generoper"));
                p.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                p.setEstadoCivil(rs.getString("estadoCivil"));
                p.setSalariobenefac(rs.getDouble("salariobenefac"));
                p.setEstratoSbenefi(rs.getString("estratoSbenefi"));
                p.setTitulo(rs.getString("titulo"));
                p.setSeguro(rs.getString("seguro"));
                p.setHorario(rs.getString("horario"));
                p.setPeriodovol(rs.getString("periodovol"));
                p.setTipovol(rs.getString("tipovol"));
                 bytea =rs.getBytes("foto");
                
                try {
                    if (bytea != null) {
                        p.setFotop(getImage(bytea));
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
                ListaPersonas.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ListaPersonas;
    }
      public List<Persona> searchPersona(String texto) {
        List<Persona> listpersona = new ArrayList<>();
        byte[] bytea;
        String sql = "Select * from persona where idpersona LIKE '%" + texto + "%'"
                + "or lower(nombresper) LIKE '%" + texto + "%'"
                + "or lower(apellidosper) LIKE '%" + texto + "%'"
                + "or lower(generoper) LIKE '%" + texto + "%';";
        System.out.println(sql);
        ResultSet rs = mpgc.consulta(sql);
        try {
            while (rs.next()) {
               Persona p = new Persona();
                p.setIdper(rs.getInt("idpersona"));
                p.setCedulaper(rs.getString("cedulaper"));
                p.setTipoper(rs.getString("tipoper"));
                p.setNombresper(rs.getString("nombresper"));
                p.setApellidosper(rs.getString("apellidosper"));
                p.setDireccionper(rs.getString("direccionper"));
                p.setTelefonoper(rs.getString("telefonoper"));
                p.setCorreoper(rs.getString("correoper"));
                p.setGeneroper(rs.getString("generoper"));
                p.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                p.setEstadoCivil(rs.getString("estadoCivil"));
                p.setSalariobenefac(rs.getDouble("salariobenefac"));
                p.setEstratoSbenefi(rs.getString("estratoSbenefi"));
                p.setTitulo(rs.getString("titulo"));
                p.setSeguro(rs.getString("seguro"));
                p.setHorario(rs.getString("horario"));
                p.setPeriodovol(rs.getString("periodovol"));
                p.setTipovol(rs.getString("tipovol"));
                 bytea =rs.getBytes("foto");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listpersona;
    }
      
     private Image getImage(byte[] fotoBytes) throws IOException {

        ByteArrayInputStream byteArr = new ByteArrayInputStream(fotoBytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader imRdr = (ImageReader) it.next();
        Object source = byteArr;
        ImageInputStream img = ImageIO.createImageInputStream(source);
        imRdr.setInput(img, true);
        ImageReadParam prmtrs = imRdr.getDefaultReadParam();
        prmtrs.setSourceSubsampling(1, 1, 0, 0);

        return imRdr.read(0, prmtrs);
    }
    public boolean delPersona() {
        String sql = "DELETE  FROM persona\n"
                + " WHERE idper= '" + getIdper() + "'"
                + ";";
        System.out.println(sql);
        return mpgc.accion(sql);
    }

}
