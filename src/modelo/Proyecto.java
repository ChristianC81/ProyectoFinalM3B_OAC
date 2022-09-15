/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Laptop
 */
public class Proyecto {

    private int idproy;
    private String nombreproy;
    private Date fechainicioproy;
    private Date fechafinproy;
    private String lugarproy;
    private int idpersona; //beneficiario

    public Proyecto() {
    }

    public Proyecto(int idproy, String nombreproy, Date fechainicioproy, Date fechafinproy, String lugarproy, int idpersona) {
        this.idproy = idproy;
        this.nombreproy = nombreproy;
        this.fechainicioproy = fechainicioproy;
        this.fechafinproy = fechafinproy;
        this.lugarproy = lugarproy;
        this.idpersona = idpersona;
    }

    /**
     * @return the idproy
     */
    public int getIdproy() {
        return idproy;
    }

    /**
     * @param idproy the idproy to set
     */
    public void setIdproy(int idproy) {
        this.idproy = idproy;
    }

    /**
     * @return the nombreproy
     */
    public String getNombreproy() {
        return nombreproy;
    }

    /**
     * @param nombreproy the nombreproy to set
     */
    public void setNombreproy(String nombreproy) {
        this.nombreproy = nombreproy;
    }

    /**
     * @return the fechainicioproy
     */
    public Date getFechainicioproy() {
        return fechainicioproy;
    }

    /**
     * @param fechainicioproy the fechainicioproy to set
     */
    public void setFechainicioproy(Date fechainicioproy) {
        this.fechainicioproy = fechainicioproy;
    }

    /**
     * @return the fechafinproy
     */
    public Date getFechafinproy() {
        return fechafinproy;
    }

    /**
     * @param fechafinproy the fechafinproy to set
     */
    public void setFechafinproy(Date fechafinproy) {
        this.fechafinproy = fechafinproy;
    }

    /**
     * @return the lugarproy
     */
    public String getLugarproy() {
        return lugarproy;
    }

    /**
     * @param lugarproy the lugarproy to set
     */
    public void setLugarproy(String lugarproy) {
        this.lugarproy = lugarproy;
    }

    /**
     * @return the idpersona
     */
    public int getIdpersona() {
        return idpersona;
    }

    /**
     * @param idpersona the idpersona to set
     */
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

}
