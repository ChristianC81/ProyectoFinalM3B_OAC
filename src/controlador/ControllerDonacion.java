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
import modelo.Donacion;
import modelo.ModeloDonacion;
import modelo.ModelPGConection;
import vista.ViewAdministrador;

/**
 *
 * @author Laptop
 */
public class ControllerDonacion {

    private ModelPGConection conex;
    private ModeloDonacion modelo;
    private ViewAdministrador vista;
    int filas;

    public ControllerDonacion(ModeloDonacion modelo, ViewAdministrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControl() {
        cargaDatos();
        vista.getBtnbuscarDONA().addActionListener(l -> cargaDatos());
        //vista.getjButtonSalir().addActionListener(ll -> salir());
        vista.getBtnCREARDONA().addActionListener(lc -> crearDonacion());
        vista.getBtnEDITARDONA().addActionListener(c -> editarDatosDonacion());
        vista.getBtnELIMINARDONA().addActionListener(lm -> eliminarDonacion());
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
            if (e.getSource() == vista.getTxtBsqDonacionesCriterio()) {

                String apellidos = vista.getTxtBsqDonacionesCriterio().getText();

                DefaultTableModel tabla;
                tabla = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
                tabla.setNumRows(0);
                List<Donacion> listadon = modelo.buscarDatosDonacion(apellidos);

                Holder<Integer> i = new Holder<>(0);
                listadon.stream().forEach(pe -> {
                    tabla.addRow(new Object[10]);
                    vista.getjTableDatosDonacione().setValueAt(pe.getIddonacion(), i.value, 0);
                    vista.getjTableDatosDonacione().setValueAt(pe.getDetallePro(), i.value, 1);
                    vista.getjTableDatosDonacione().setValueAt(pe.getFechaEntrega(), i.value, 2);
                    vista.getjTableDatosDonacione().setValueAt(pe.getMotivodonacion(), i.value, 3);
                    vista.getjTableDatosDonacione().setValueAt(pe.getIdpersona(), i.value, 4);
                    i.value++;
                });
            }
        }
    };

    private void crearDonacion() {
        //INSERT
        String detalle = vista.getTxaDetalleProdDON().getText();;
        String motivo = vista.getTxaMotivoDON().getText();
        String idpersona = (String) vista.getjComboBoxPersonasBenefactDon();

        Instant instant = vista.getjDateChooserFECHADONA().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fecha = Date.valueOf(zdt.toLocalDate());

        ModeloDonacion donacion = new ModeloDonacion();
        donacion.setDetallePro(detalle);
        donacion.setMotivodonacion(motivo);
        donacion.setFechaEntrega(fecha);
        int persona = Integer.parseInt(idpersona);
        donacion.setIdpersona(persona);

        if (donacion.setDonacion()) {
            Resouces.success("Atención! ", "DONACIÓN CREADA");
            cargaDatos();
        } else {
            Resouces.error("Atención! ", "NO SE PUDO CREAR LA DONACIÓN");
        }
    }

    private void eliminarDonacion() {
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
    private void editarDatosDonacion() {
        String detalle = vista.getTxaDetalleProdDON().getText();
        String motivo = vista.getTxaMotivoDON().getText();
        String idpe = (String) vista.getjComboBoxPersonasBenefactDon();
        int pers = Integer.parseInt(idpe);

        Instant instant = vista.getjDateChooserFECHADONA().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
        Date fecha = Date.valueOf(zdt.toLocalDate());

        ModeloDonacion donacion = new ModeloDonacion();
        donacion.setDetallePro(detalle);
        donacion.setMotivodonacion(motivo);
        donacion.setFechaEntrega(fecha);
        donacion.setIdpersona(pers);

        int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE EDITAR LOS DATOS DE ESTA DONACION?");
        if (select == JOptionPane.YES_OPTION) {
            if (donacion.editarDonacion()) {
                Resouces.success("Atención!!", "DONACION EDITADA :)");
                cargaDatos();
            } else {
                JOptionPane.showMessageDialog(vista, "NO SE PUDO EDITAR LA DONACIÓN");
            }
        }
    }

    private void cargaDatos() {
        DefaultTableModel tabla;
        tabla = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
        tabla.setNumRows(0);

        List<Donacion> listap = modelo.getDonacion();
        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(per -> {
            tabla.addRow(new Object[10]);
            vista.getjTableDatosDonacione().setValueAt(per.getIddonacion(), i.value, 0);
            vista.getjTableDatosDonacione().setValueAt(per.getDetallePro(), i.value, 1);
            vista.getjTableDatosDonacione().setValueAt(per.getFechaEntrega(), i.value, 2);
            vista.getjTableDatosDonacione().setValueAt(per.getMotivodonacion(), i.value, 3);
            vista.getjTableDatosDonacione().setValueAt(per.getIdpersona(), i.value, 4);

            i.value++;
        });
    }

    public void cargarDatosModificar() {
        try {
            int filaSelecionada = vista.getjTableDatosPersonas().getSelectedRow();
            System.out.println(vista.getjTableDatosPersonas().getValueAt(filaSelecionada, 0).toString());
            String iddona = vista.getjTableDatosDonacione().getValueAt(filaSelecionada, 0).toString();

            List<Donacion> lista = modelo.DonaModif(iddona);
            for (int i = 0; i < lista.size(); i++) {

                vista.getTxaDetalleProdDON().setText(lista.get(i).getDetallePro());
                vista.getjDateChooserFECHADONA().setDate(lista.get(i).getFechaEntrega());
                vista.getTxaMotivoDON().setText(lista.get(i).getMotivodonacion());
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
