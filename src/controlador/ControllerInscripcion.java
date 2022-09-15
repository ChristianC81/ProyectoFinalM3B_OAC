/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Inscripcion;
import modelo.ModeloDonacion;
import modelo.ModeloInscripcion;
import vista.ViewAdministrador;

/**
 *
 * @author Laptop
 */
public class ControllerInscripcion {
    private ModeloInscripcion modelo;
    private ViewAdministrador vista;
    int filas;

    public ControllerInscripcion(ModeloInscripcion modelo, ViewAdministrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    public void iniciaControl() {
        cargaDatos();
        vista.getBtnbuscarInscri().addActionListener(l -> cargaDatos());
        //vista.getjButtonSalir().addActionListener(ll -> salir());
        vista.getBtnCREARINSCRI().addActionListener(lc -> crearInscripcion());
        vista.getBtnEDITARINSCRI().addActionListener(c -> editarDatosInscripcion());
        vista.getBtnELIMINARINSCRI().addActionListener(lm -> eliminarInscripcion());
        vista.getTxtBsqDonacionesCriterio().addKeyListener(tecla);

    }
    KeyListener tecla = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == vista.getTxtBsqInscripiones()) {

                String apellidos = vista.getTxtBsqInscripiones().getText();

                DefaultTableModel tabla;
                tabla = (DefaultTableModel) vista.getjTableDatosInscripciones().getModel();
                tabla.setNumRows(0);
                List<Inscripcion> listai = modelo.buscarDatosInscripcion(apellidos);

                Holder<Integer> i = new Holder<>(0);
                listai.stream().forEach(pe -> {
                    tabla.addRow(new Object[10]);
                    vista.getjTableDatosInscripciones().setValueAt(pe.getIdnis(), i.value, 0);
                    vista.getjTableDatosInscripciones().setValueAt(pe.getNdiasparticipacionins(), i.value, 1);
                    vista.getjTableDatosInscripciones().setValueAt(pe.getIdproyins(), i.value, 2);
                    vista.getjTableDatosInscripciones().setValueAt(pe.getIdpersona(), i.value, 3);
                    i.value++;
                });
            }
        }
    };

    private void crearInscripcion() {
            //INSERT
            int num = (int) vista.getjSpinnerDiasParticipacion().getValue();
            String proy = vista.getCbxCodigoProyecto().getSelectedItem().toString();
            int nproy = Integer.parseInt(proy);
            String idpersona = vista.getCbxCodigoVoluntario().getSelectedItem().toString();
            int cvol = Integer.parseInt(idpersona);

            ModeloInscripcion inscripcion = new ModeloInscripcion();
            inscripcion.setNdiasparticipacionins(num);
            inscripcion.setIdproyins(nproy);
            inscripcion.setIdpersona(cvol);

            if (inscripcion.setInscripcion()) {
                Resouces.success("Atención! ","INSCRIPCIÓN REALIZADA");
                cargaDatos();
            } else {
                Resouces.error("Atención! ","NO SE PUDO REALIZAR LA INSCRIPCIÓN");
            }
        }


    private void eliminarInscripcion() {
        ModeloDonacion donacion1 = new ModeloDonacion();
        try {
            int m = vista.getjTableDatosDonacione().getSelectedRow();
            String id = String.valueOf(vista.getjTableDatosDonacione().getValueAt(m, 0));
            if (vista.getjTableDatosDonacione().getSelectedRow() >= 0) {
                DefaultTableModel dtm = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
                int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE ELIMINAR A ESA DONACION?");
                if (select == JOptionPane.YES_OPTION) {
                    dtm.removeRow(vista.getjTableDatosDonacione().getSelectedRow());
                    donacion1.eliminar(id);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una donacion en la tabla");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(vista, "ERROR, Selecciona una donacion de la tabla");
        }
    }

//    @SuppressWarnings("empty-statement")
    private void editarDatosInscripcion() {
            int dias = (int) vista.getjSpinnerDiasParticipacion().getValue();
            String NP = vista.getCbxCodigoProyecto().getSelectedItem().toString();
            String CV = vista.getCbxCodigoVoluntario().getSelectedItem().toString();
            int proy = Integer.parseInt(NP);
            int vol = Integer.parseInt(CV);
    
            ModeloInscripcion inscripcion = new ModeloInscripcion();
            inscripcion.setNdiasparticipacionins(dias);;
            inscripcion.setIdproyins(proy);
            inscripcion.setIdpersona(vol);
            
            int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE EDITAR LOS DATOS DE ESTE PROYECTO?");
            if (select == JOptionPane.YES_OPTION) {
                if (inscripcion.editarInscripcion()) {
                    Resouces.success("Atención!!", "INSCRIPCIÓN EDITADA :)");
                    cargaDatos();
                } else {
                    JOptionPane.showMessageDialog(vista, "NO SE PUDO EDITAR LA INSCRIPCIÓN");
                }
            }
    }

    private void cargaDatos() {
        DefaultTableModel tabla;
        tabla = (DefaultTableModel) vista.getjTableDatosInscripciones().getModel();
        tabla.setNumRows(0);

        List<Inscripcion> listap = modelo.getInscripcion();
        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(per -> {
            tabla.addRow(new Object[10]);
            vista.getjTableDatosInscripciones().setValueAt(per.getIdnis(), i.value, 0);
            vista.getjTableDatosInscripciones().setValueAt(per.getNdiasparticipacionins(), i.value, 1);
            vista.getjTableDatosInscripciones().setValueAt(per.getIdproyins(), i.value, 2);
            vista.getjTableDatosInscripciones().setValueAt(per.getIdpersona(), i.value, 3);
            
            i.value++;
        });
    }
    
    public void cargarDatosModificar() {
        try {
            int filaSelecionada = vista.getjTableDatosInscripciones().getSelectedRow();
                System.out.println(vista.getjTableDatosInscripciones().getValueAt(filaSelecionada, 0).toString());
                String idins = vista.getjTableDatosInscripciones().getValueAt(filaSelecionada, 0).toString();

            List<Inscripcion> lista = modelo.InscriModif(idins);
            for (int i = 0; i < lista.size(); i++) {

                vista.getjSpinnerDiasParticipacion().setValue(lista.get(i).getIdnis());
//                vista.getCbxCodigoProyecto().setValue(lista.get(i).getIdproyins());
//                vista.getCbxCodigoVoluntario().setDate(lista.get(i).getIdpersona());
                //vista.getjComboBoxPersonasBenefactDon().setText(lista.get(i).getIdpersona());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void salir() {
        System.exit(0);
    }
    
}
