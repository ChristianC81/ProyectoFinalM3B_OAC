/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.Donacion;
import modelo.ModeloDonacion;
import modelo.Resouces;
import vista.ViewAdministrador;

/**
 *
 * @author Laptop
 */
public class ControllerDonacion {
//    private ModeloDonacion modelo;
//    private ViewAdministrador vista;
//    private JFileChooser jfc;
//    int filas;
//
//    public ControllerDonacion(ModeloDonacion modelo, ViewAdministrador vista) {
//        this.modelo = modelo;
//        this.vista = vista;
//        
//        vista.setVisible(true);
//    }
//    public void iniciaControl() {
//        cargaDatos();
////        vista.getjButtonbuscar().addActionListener(l -> cargaDatos());
////        vista.getjButtonSalir().addActionListener(ll -> salir());
//        vista.getjButtoncrear().addActionListener(lc -> abrirDialogo(1));
//        vista.getjButtonCancelar().addActionListener(c -> cancelar() );
//        vista.getjButtonmodificar().addActionListener(lm -> abrirDialogo(2));
//        vista.getjButtonACEPTAR().addActionListener(la -> crearEditarPersona());
//        vista.getjButtoneliminar().addActionListener(le -> eliminarPersona());
//        vista.getjTextFieldbusqueda().addKeyListener(tecla);
//        vista.getjButtonExaminar().addActionListener(ex -> examinaFoto());
//        /* UNA FORMA DE REALIZAR
//        vista.getjButtonbuscar().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //AQUI SE PROGRAMA
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });*/
//
//    }
//    KeyListener tecla = new KeyListener() {
//        @Override
//        public void keyTyped(KeyEvent e) {
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            if (e.getSource() == vista.getTxtBsqDonacionesCriterio()) {
//
//                String apellidos = vista.getTxtBsqDonacionesCriterio().getText();
//
//                DefaultTableModel tabla;
//                tabla = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
//                tabla.setNumRows(0);
//                List<Donacion> listaper = modelo.buscarDatosDonacion(apellidos);
//
//                Holder<Integer> i = new Holder<>(0);
//                listaper.stream().forEach(pe -> {
//                    tabla.addRow(new Object[10]);
//                    vista.getjTableDatosDonacione().setValueAt(pe.getIddonacion(), i.value, 0);
//                    vista.getjTableDatosDonacione().setValueAt(pe.getDetallePro(), i.value, 1);
//                    vista.getjTableDatosDonacione().setValueAt(pe.getFechaEntrega(), i.value, 2);
//                    vista.getjTableDatosDonacione().setValueAt(pe.getMotivodonacion(), i.value, 3);
//                    vista.getjTableDatosDonacione().setValueAt(pe.getIdpersona(), i.value, 4);
//                    i.value++;
//                });
//            }
//        }
//    };
//
//    private void abrirDialogo(int op) {
//        String titulo;
//        if (op == 1) {
//            titulo = "CREAR PERSONA";
//            vista.getjDialogPERSONAS().setName("C");
//            vista.getjDialogPERSONAS().setTitle(titulo);
//            vista.getjDialogPERSONAS().setVisible(true);
//        } else {
//            if (vista.getjTableDatosPersonas().getSelectedRow() >= 0) {
//                titulo = "EDITAR PERSONA";
//                
//                cargarDatosModificar();
//                vista.getjDialogPERSONAS().setName("E");
//                vista.getjDialogPERSONAS().setTitle(titulo);
//                vista.getjTextFieldIDENTIFICACION().setEnabled(false);
//                vista.getjDialogPERSONAS().setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(null, "Seleccione una persona en la tabla");
//            }
//        }
//        vista.getjDialogPERSONAS().setSize(700, 500);
//        vista.getjDialogPERSONAS().setLocationRelativeTo(null);
//    }
//
//    private void crearDonacion() {
//            //INSERT
//            String detalle = vista.getTxaDetalleProdDON().getText();
//            String motivo = vista.getTxaMotivoDON().getText();
//            
//
//            Instant instant = vista.getjDateChooserFECHADONA().getDate().toInstant();
//            ZoneId zid = ZoneId.of("America/Guayaquil");
//            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
//            Date fecha = Date.valueOf(zdt.toLocalDate());
//
//            ModeloDonacion donacion = new ModeloDonacion();
//            donacion.setDetallePro(detalle);
//            donacion.setMotivodonacion(motivo);
//            donacion.setFechaEntrega(fecha);
//            //donacion.setIdpersona(telefono);
//
//            if (donacion.setDonacion()) {
//                JOptionPane.showMessageDialog(vista, "DONACION CREADA :)");
//                cargaDatos();
//            } else {
//                JOptionPane.showMessageDialog(vista, "NO SE PUDO CREAR LA DONACION");
//            }
//        }
//
//
//    private void eliminarPersona() {
//        ModeloDonacion donacion1 = new ModeloDonacion();
//        try {
//            int m = vista.getjTableDatosDonacione().getSelectedRow();
//            String id = String.valueOf(vista.getjTableDatosDonacione().getValueAt(m, 0));
//            if (vista.getjTableDatosDonacione().getSelectedRow() >= 0) {
//                DefaultTableModel dtm = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
//                int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE ELIMINAR A ESA DONACION?");
//                if (select == JOptionPane.YES_OPTION) {
//                    dtm.removeRow(vista.getjTableDatosDonacione().getSelectedRow());
//                    donacion1.eliminar(id);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Seleccione una donacion en la tabla");
//            }
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            JOptionPane.showMessageDialog(vista, "ERROR, Selecciona una donacion de la tabla");
//        }
//    }
//
//    @SuppressWarnings("empty-statement")
//    private void editarDatosDonacion() {
//            String detalle = vista.getTxaDetalleProdDON().getText();
//            String motivo = vista.getTxaMotivoDON().getText();
//            
//
//            Instant instant = vista.getjDateChooserFECHADONA().getDate().toInstant();
//            ZoneId zid = ZoneId.of("America/Guayaquil");
//            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zid);
//            Date fecha = Date.valueOf(zdt.toLocalDate());
//
//            ModeloDonacion donacion = new ModeloDonacion();
//            donacion.setDetallePro(detalle);
//            donacion.setMotivodonacion(motivo);
//            donacion.setFechaEntrega(fecha);
//            
//            int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE EDITAR LOS DATOS DE ESTA DONACION?");
//            if (select == JOptionPane.YES_OPTION) {
//                if (donacion.editarDonacion()) {
//                    Resouces.success("Atención!!", "DONACION EDITADA :)");
//                    cargaDatos();
//                } else {
//                    JOptionPane.showMessageDialog(vista, "NO SE PUDO EDITAR LA DONACIÓN");
//                }
//            }
//    }
//
//    private void cargaDatos() {
//        DefaultTableModel tabla;
//        tabla = (DefaultTableModel) vista.getjTableDatosDonacione().getModel();
//        tabla.setNumRows(0);
//
//        List<Donacion> listap = modelo.getDonacion();
//        Holder<Integer> i = new Holder<>(0);
//
//        listap.stream().forEach(per -> {
//            tabla.addRow(new Object[10]);
//            vista.getjTableDatosDonacione().setValueAt(per.getIddonacion(), i.value, 0);
//            vista.getjTableDatosDonacione().setValueAt(per.getDetallePro(), i.value, 1);
//            vista.getjTableDatosDonacione().setValueAt(per.getFechaEntrega(), i.value, 2);
//            vista.getjTableDatosDonacione().setValueAt(per.getMotivodonacion(), i.value, 3);
//            vista.getjTableDatosDonacione().setValueAt(per.getidp(), i.value, 4);
//            
//            i.value++;
//        });
//    }
//    
//    public void cargarDatosModificar() {
//        try {
//            int filaSelecionada = vista.getjTableDatosPersonas().getSelectedRow();
//            System.out.println(vista.getjTableDatosPersonas().getValueAt(filaSelecionada, 0).toString());
//            String identificacion = vista.getjTableDatosPersonas().getValueAt(filaSelecionada, 0).toString();
//
//            List<Persona> lista = modelo.personaModif(identificacion);
//            for (int i = 0; i < lista.size(); i++) {
//
//                vista.getjTextFieldIDENTIFICACION().setText(lista.get(i).getIdpersona());
//                vista.getjTextFieldNOMBRE().setText(lista.get(i).getNombres());
//                vista.getjTextFieldAPELLIDO().setText(lista.get(i).getApellidos());
//                vista.getjDateChooserFECHA().setDate(lista.get(i).getFechaNac());
//                vista.getjTextFieldTELEFONO().setText(lista.get(i).getTelefono());
//                //vista.getTxtSexo().setText(lista.get(i).getSexo());
//                Double salario = lista.get(i).getSueldo();
//                vista.getjTextFieldSUELDO().setText(String.valueOf(salario));
//                vista.getjSpinnerCUPO().setValue(lista.get(i).getCupo());
//                vista.getjLabelFoto().setIcon(icono);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    
//    public void salir() {
//        JOptionPane.showMessageDialog(vista.getjPanel1(), "SALIENDO DEL PROGRAMA....  :)");
//        System.exit(0);
//    }
//    
//    private void datosEditarPersona() {
//
//        try {
//            int edit = vista.getjTableDatosPersonas().getSelectedRow();
//            vista.getjTextFieldIDENTIFICACION().setText(String.valueOf(vista.getjTableDatosPersonas().getValueAt(edit, 0)));
//            vista.getjTextFieldNOMBRE().setText(String.valueOf(vista.getjTableDatosPersonas().getValueAt(edit, 1)));
//            vista.getjTextFieldAPELLIDO().setText(String.valueOf(vista.getjTableDatosPersonas().getValueAt(edit, 2)));
//            vista.getjDateChooserFECHA().setDate((java.util.Date)vista.getjTableDatosPersonas().getValueAt(edit, 3));
//            vista.getjTextFieldTELEFONO().setText(String.valueOf(vista.getjTableDatosPersonas().getValueAt(edit, 4)));
//            String auxG = vista.getjTableDatosPersonas().getValueAt(edit, 5).toString();
//            if (auxG.equals("Femenino")) {
//                vista.getjRadioButtonFEM().setSelected(true);
//            } else {
//                vista.getjRadioButtonMASC().setSelected(false);
//            }
//            vista.getjTextFieldSUELDO().setText(String.valueOf(vista.getjTableDatosPersonas().getValueAt(edit, 6)));
//            vista.getjSpinnerCUPO().setValue(vista.getjTableDatosPersonas().getValueAt(edit, 7));
//        } catch (Exception E) {
//            System.out.println(E);
//        }
//    }
    
}
