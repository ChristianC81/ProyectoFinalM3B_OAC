/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author Laptop
 */
public class Donacion {
    private int iddonacion;
    private String detallePro;
    private Date fechaEntrega;
    private String motivodonacion;
    private int idpersona;

    public Donacion() {
    }

    public Donacion(int iddonacion, String detallePro, Date fechaEntrega, String motivodonacion, int idpersona) {
        this.iddonacion = iddonacion;
        this.detallePro = detallePro;
        this.fechaEntrega = fechaEntrega;
        this.motivodonacion = motivodonacion;
        this.idpersona = idpersona;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIddonacion() {
        return iddonacion;
    }

    public void setIddonacion(int iddonacion) {
        this.iddonacion = iddonacion;
    }

    public String getDetallePro() {
        return detallePro;
    }

    public void setDetallePro(String detallePro) {
        this.detallePro = detallePro;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getMotivodonacion() {
        return motivodonacion;
    }

    public void setMotivodonacion(String motivodonacion) {
        this.motivodonacion = motivodonacion;
    }
    
    
}
