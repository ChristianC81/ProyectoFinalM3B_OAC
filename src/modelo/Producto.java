/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Laptop
 */
public class Producto {

    private int idprod;
    private int cantprod;
    private String tipoprod;
    private int iddonaprod;
    private int idproyprod;

    public Producto() {
    }

    public Producto(int idprod, int cantprod, String tipoprod, int iddonaprod, int idproyprod) {
        this.idprod = idprod;
        this.cantprod = cantprod;
        this.tipoprod = tipoprod;
        this.iddonaprod = iddonaprod;
        this.idproyprod = idproyprod;
    }

    /**
     * @return the idprod
     */
    public int getIdprod() {
        return idprod;
    }

    /**
     * @param idprod the idprod to set
     */
    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    /**
     * @return the cantprod
     */
    public int getCantprod() {
        return cantprod;
    }

    /**
     * @param cantprod the cantprod to set
     */
    public void setCantprod(int cantprod) {
        this.cantprod = cantprod;
    }

    /**
     * @return the tipoprod
     */
    public String getTipoprod() {
        return tipoprod;
    }

    /**
     * @param tipoprod the tipoprod to set
     */
    public void setTipoprod(String tipoprod) {
        this.tipoprod = tipoprod;
    }

    /**
     * @return the iddonaprod
     */
    public int getIddonaprod() {
        return iddonaprod;
    }

    /**
     * @param iddonaprod the iddonaprod to set
     */
    public void setIddonaprod(int iddonaprod) {
        this.iddonaprod = iddonaprod;
    }

    /**
     * @return the idproyprod
     */
    public int getIdproyprod() {
        return idproyprod;
    }

    /**
     * @param idproyprod the idproyprod to set
     */
    public void setIdproyprod(int idproyprod) {
        this.idproyprod = idproyprod;
    }

}
