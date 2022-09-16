/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalm3b_oac;

import controlador.ControllerPersona;
import modelo.ModeloPersona;
import vista.ViewAdministrador;

/**
 *
 * @author miri
 */
public class ProyectoFinalM3B_OAC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("YONNI MARICA");
        ViewAdministrador vista= new ViewAdministrador();
        ModeloPersona modelo= new ModeloPersona();
        ControllerPersona controladorPersona= new ControllerPersona(modelo, vista);
    } 
    
}
