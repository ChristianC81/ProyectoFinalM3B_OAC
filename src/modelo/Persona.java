/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.io.FileInputStream;
import java.util.Date;

/**
 *
 * @author Laptop
 */
public class Persona {
  private int idper;
  private String cedulaper ;
  private String nombresper;
  private String apellidosper;
  private String direccionper;
  private String telefonoper;
  private String correoper;
  private String generoper;
  private Date fechaNacimiento;
  private String estadoCivil;
  private double salariobenefac;
  private String estratoSbenefi;
  private String titulo;
  private String seguro ;
  private String horario;
  private String periodovol;
  private String tipovol;
  private Image fotop;
  
    
    //GUARDAR FOTO
    private FileInputStream imageFile;
    private int length;
    
    

    /**
     * @return the idper
     */
    public int getIdper() {
        return idper;
    }

    /**
     * @param idper the idper to set
     */
    public void setIdper(int idper) {
        this.idper = idper;
    }

    /**
     * @return the cedulaper
     */
    public String getCedulaper() {
        return cedulaper;
    }

    /**
     * @param cedulaper the cedulaper to set
     */
    public void setCedulaper(String cedulaper) {
        this.cedulaper = cedulaper;
    }

    /**
     * @return the nombresper
     */
    public String getNombresper() {
        return nombresper;
    }

    /**
     * @param nombresper the nombresper to set
     */
    public void setNombresper(String nombresper) {
        this.nombresper = nombresper;
    }

    /**
     * @return the apellidosper
     */
    public String getApellidosper() {
        return apellidosper;
    }

    /**
     * @param apellidosper the apellidosper to set
     */
    public void setApellidosper(String apellidosper) {
        this.apellidosper = apellidosper;
    }

    /**
     * @return the direccionper
     */
    public String getDireccionper() {
        return direccionper;
    }

    /**
     * @param direccionper the direccionper to set
     */
    public void setDireccionper(String direccionper) {
        this.direccionper = direccionper;
    }

    /**
     * @return the telefonoper
     */
    public String getTelefonoper() {
        return telefonoper;
    }

    /**
     * @param telefonoper the telefonoper to set
     */
    public void setTelefonoper(String telefonoper) {
        this.telefonoper = telefonoper;
    }

    /**
     * @return the correoper
     */
    public String getCorreoper() {
        return correoper;
    }

    /**
     * @param correoper the correoper to set
     */
    public void setCorreoper(String correoper) {
        this.correoper = correoper;
    }

    /**
     * @return the generoper
     */
    public String getGeneroper() {
        return generoper;
    }

    /**
     * @param generoper the generoper to set
     */
    public void setGeneroper(String generoper) {
        this.generoper = generoper;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the salariobenefac
     */
    public double getSalariobenefac() {
        return salariobenefac;
    }

    /**
     * @param salariobenefac the salariobenefac to set
     */
    public void setSalariobenefac(double salariobenefac) {
        this.salariobenefac = salariobenefac;
    }

    /**
     * @return the estratoSbenefi
     */
    public String getEstratoSbenefi() {
        return estratoSbenefi;
    }

    /**
     * @param estratoSbenefi the estratoSbenefi to set
     */
    public void setEstratoSbenefi(String estratoSbenefi) {
        this.estratoSbenefi = estratoSbenefi;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the seguro
     */
    public String getSeguro() {
        return seguro;
    }

    /**
     * @param seguro the seguro to set
     */
    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the periodovol
     */
    public String getPeriodovol() {
        return periodovol;
    }

    /**
     * @param periodovol the periodovol to set
     */
    public void setPeriodovol(String periodovol) {
        this.periodovol = periodovol;
    }

    /**
     * @return the tipovol
     */
    public String getTipovol() {
        return tipovol;
    }

    /**
     * @param tipovol the tipovol to set
     */
    public void setTipovol(String tipovol) {
        this.tipovol = tipovol;
    }

    /**
     * @return the fotop
     */
    public Image getFotop() {
        return fotop;
    }

    /**
     * @param fotop the fotop to set
     */
    public void setFotop(Image fotop) {
        this.fotop = fotop;
    }
}
