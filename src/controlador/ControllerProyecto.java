/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.ModeloProyecto;
import modelo.Proyecto;
import vista.ViewAdministrador;

/**
 *
 * @author Laptop
 */
public class ControllerProyecto {

    private ModeloProyecto modeloProyecto;
    private ViewAdministrador vista;
    int filas;

    public ControllerProyecto(ModeloProyecto modeloProyecto, ViewAdministrador vista) {
        this.modeloProyecto = modeloProyecto;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControl() {
        cargaDatos();
        vista.getBtnbuscarProye().addActionListener(l -> cargaDatos());
        //vista.getjButtonSalir().addActionListener(ll -> salir());
        vista.getBtnCREARPROYE().addActionListener(l -> crearProyecto());
        vista.getBtnEDITARPROYE().addActionListener(l -> editarDatosProyecto());
        vista.getBtnELIMINARPROYE().addActionListener(l -> eliminarProyecto());
        vista.getTxtBsqProyectos().addKeyListener(tecla);

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
            if (e.getSource() == vista.getTxtBsqProyectos()) {

                String buscar = vista.getTxtBsqProyectos().getText();

                DefaultTableModel tabla;
                tabla = (DefaultTableModel) vista.getjTableDatosProyectos().getModel();
                tabla.setNumRows(0);
                List<Proyecto> listaProye = modeloProyecto.buscarDatosProyecto(buscar);

                Holder<Integer> i = new Holder<>(0);
                listaProye.stream().forEach(pe -> {
                    tabla.addRow(new Object[10]);
                    vista.getjTableDatosProyectos().setValueAt(pe.getIdproy(), i.value, 0);
                    vista.getjTableDatosProyectos().setValueAt(pe.getNombreproy(), i.value, 1);
                    vista.getjTableDatosProyectos().setValueAt(pe.getFechainicioproy(), i.value, 2);
                    vista.getjTableDatosProyectos().setValueAt(pe.getFechafinproy(), i.value, 3);
                    vista.getjTableDatosProyectos().setValueAt(pe.getLugarproy(), i.value, 4);
                    vista.getjTableDatosProyectos().setValueAt(pe.getIdpersona(), i.value, 5);
                    i.value++;
                });
            }
        }
    };

    private void crearProyecto() {
        String nombre = vista.getTxtNombreProye().getText();;
        String lugar = vista.getTxtLugarProye().getText();
        String idpersona = (String) vista.getjComboBoxPersonasBeneficiarioProye().getSelectedItem();
        int persona = Integer.parseInt(idpersona);

        Instant instant = vista.getjDateChooserProyeFechaInicio().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fechainicio = Date.valueOf(zdt.toLocalDate());

        Instant instant2 = vista.getjDateChooserFECHADONA().getDate().toInstant();
        ZoneId zid2 = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant, zid);
        Date fechafin = Date.valueOf(zdt.toLocalDate());

        ModeloProyecto proyecto = new ModeloProyecto();
        proyecto.setNombreproy(nombre);
        proyecto.setFechainicioproy(fechainicio);
        proyecto.setFechafinproy(fechafin);
        proyecto.setLugarproy(lugar);
        proyecto.setIdpersona(persona);

        if (proyecto.setProyecto()) {
            Resouces.success("Atención! ", "PROYECTO CREADO");
            cargaDatos();
            limpiardatos();
        } else {
            Resouces.error("Atención! ", "NO SE PUDO CREAR EL PROYECTO");
        }
    }

    private void eliminarProyecto() {
        ModeloProyecto proyecto = new ModeloProyecto();
        try {
            int m = vista.getjTableDatosProyectos().getSelectedRow();
            String id = String.valueOf(vista.getjTableDatosProyectos().getValueAt(m, 0));
            if (vista.getjTableDatosProyectos().getSelectedRow() >= 0) {
                DefaultTableModel dtm = (DefaultTableModel) vista.getjTableDatosProyectos().getModel();
                int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE ELIMINAR A ESTE PROYECTO?");
                if (select == JOptionPane.YES_OPTION) {
                    dtm.removeRow(vista.getjTableDatosProyectos().getSelectedRow());
                    proyecto.eliminarProyecto(id);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto en la tabla");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(vista, "ERROR, Selecciona un proyecto de la tabla");
        }
    }

    private void editarDatosProyecto() {
        String nombre = vista.getTxtNombreProye().getText();;
        String lugar = vista.getTxtLugarProye().getText();
        String idpersona = (String) vista.getjComboBoxPersonasBeneficiarioProye().getSelectedItem();
        int persona = Integer.parseInt(idpersona);

        Instant instant = vista.getjDateChooserProyeFechaInicio().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fechainicio = Date.valueOf(zdt.toLocalDate());

        Instant instant2 = vista.getjDateChooserFECHADONA().getDate().toInstant();
        ZoneId zid2 = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant, zid);
        Date fechafin = Date.valueOf(zdt.toLocalDate());

        ModeloProyecto proyecto = new ModeloProyecto();
        proyecto.setNombreproy(nombre);
        proyecto.setFechainicioproy(fechainicio);
        proyecto.setFechafinproy(fechafin);
        proyecto.setLugarproy(lugar);
        proyecto.setIdpersona(persona);

        int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE EDITAR LOS DATOS DE ESTE PROYECTO?");
        if (select == JOptionPane.YES_OPTION) {
            if (proyecto.editarProyecto()) {
                Resouces.success("Atención!!", "PROYECTO EDITADO :)");
                cargaDatos();
                limpiardatos();
            } else {
                JOptionPane.showMessageDialog(vista, "NO SE PUDO EDITAR EL PROYECTO");
            }
        }
    }

    private void cargaDatos() {
        DefaultTableModel tabla;
        tabla = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
        tabla.setNumRows(0);

        List<Proyecto> listap = modeloProyecto.getProyecto();
        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(per -> {
            tabla.addRow(new Object[10]);
            vista.getjTableDatosDonacione().setValueAt(per.getIdproy(), i.value, 0);
            vista.getjTableDatosDonacione().setValueAt(per.getNombreproy(), i.value, 1);
            vista.getjTableDatosDonacione().setValueAt(per.getFechainicioproy(), i.value, 2);
            vista.getjTableDatosDonacione().setValueAt(per.getFechafinproy(), i.value, 3);
            vista.getjTableDatosDonacione().setValueAt(per.getLugarproy(), i.value, 4);
            vista.getjTableDatosDonacione().setValueAt(per.getIdpersona(), i.value, 5);

            i.value++;
        });
    }

    public void cargarDatosModificar() {
        try {
            int filaSelecionada = vista.getjTableDatosProyectos().getSelectedRow();
            System.out.println(vista.getjTableDatosProyectos().getValueAt(filaSelecionada, 0).toString());
            String idproye = vista.getjTableDatosProyectos().getValueAt(filaSelecionada, 0).toString();

            List<Proyecto> lista = modeloProyecto.ModiProye(idproye);
            for (int i = 0; i < lista.size(); i++) {

                vista.getTxtNombreProye().setText(lista.get(i).getNombreproy());
                vista.getjDateChooserProyeFechaInicio().setDate(lista.get(i).getFechainicioproy());
                vista.getjDateChooserProyeFechaFin().setDate(lista.get(i).getFechafinproy());
                vista.getTxtLugarProye().setText(lista.get(i).getLugarproy());
                
                //AQUIIIIII 
                //vista.getjComboBoxPersonasBenefactDon().setSelectedItem(lista.get(i).getIdpersona());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void salir() {
        System.exit(0);
    }

    public void limpiardatos() {
        vista.getTxtNombreProye().setText("");
        vista.getjDateChooserProyeFechaInicio().setDate(null);
        vista.getjDateChooserProyeFechaFin().setDate(null);
        vista.getTxtLugarProye().setText("");
        vista.getjComboBoxPersonasBeneficiarioProye().setSelectedIndex(0);

    }

}
