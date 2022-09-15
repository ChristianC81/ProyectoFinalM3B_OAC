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
public class Inscripcion {

    private int idnis;
    private int ndiasparticipacionins;
    private int idproyins;
    private int idpersona;

    public Inscripcion() {
    }

    public Inscripcion(int idnis, int ndiasparticipacionins, int idproyins, int idpersona) {
        this.idnis = idnis;
        this.ndiasparticipacionins = ndiasparticipacionins;
        this.idproyins = idproyins;
        this.idpersona = idpersona;
    }

    /**
     * @return the idnis
     */
    public int getIdnis() {
        return idnis;
    }

    /**
     * @param idnis the idnis to set
     */
    public void setIdnis(int idnis) {
        this.idnis = idnis;
    }

    /**
     * @return the ndiasparticipacionins
     */
    public int getNdiasparticipacionins() {
        return ndiasparticipacionins;
    }

    /**
     * @param ndiasparticipacionins the ndiasparticipacionins to set
     */
    public void setNdiasparticipacionins(int ndiasparticipacionins) {
        this.ndiasparticipacionins = ndiasparticipacionins;
    }

    /**
     * @return the idproyins
     */
    public int getIdproyins() {
        return idproyins;
    }

    /**
     * @param idproyins the idproyins to set
     */
    public void setIdproyins(int idproyins) {
        this.idproyins = idproyins;
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
