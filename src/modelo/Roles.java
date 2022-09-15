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
public class Roles {
    private int idrol;
    private String nombrerol;
    private String descripcionrol;

    public Roles() {
    }

    
    public Roles(int idrol, String nombrerol, String descripcionrol) {
        this.idrol = idrol;
        this.nombrerol = nombrerol;
        this.descripcionrol = descripcionrol;
    }

    
    /**
     * @return the idrol
     */
    public int getIdrol() {
        return idrol;
    }

    /**
     * @param idrol the idrol to set
     */
    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    /**
     * @return the nombrerol
     */
    public String getNombrerol() {
        return nombrerol;
    }

    /**
     * @param nombrerol the nombrerol to set
     */
    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    /**
     * @return the descripcionrol
     */
    public String getDescripcionrol() {
        return descripcionrol;
    }

    /**
     * @param descripcionrol the descripcionrol to set
     */
    public void setDescripcionrol(String descripcionrol) {
        this.descripcionrol = descripcionrol;
    }
    
}
