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
import java.util.Date;
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
import modelo.ModeloDonacion;
import modelo.ModeloPersona;
import modelo.Persona;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import vista.ViewAdministrador;

/**
 *
 * @author Laptop
 */
public class ControllerPersona {

    private ModeloPersona modelo;
    private ViewAdministrador vista;
    private JFileChooser jfc;
    int filas;

    public ControllerPersona(ModeloPersona modelo, ViewAdministrador vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        iniciaControl();
    }

    public void iniciaControl() {
        cargaDatos();
        vista.getBtnbuscarPer().addActionListener(l -> cargaDatos());
        vista.getBtnSalir().addActionListener(l -> salir());
        vista.getBtnExaminarFoto().addActionListener(l -> examinarFoto());
        vista.getBtnCREARPER().addActionListener(l -> crearPersona());
        vista.getBtnEDITARPER().addActionListener(l -> editarDatosDonacion());
        vista.getBtnELIMINARPER().addActionListener(l -> eliminarDonacion());
        vista.getTxtBsqPersonas().addKeyListener(tecla);

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
                tabla = (DefaultTableModel) vista.getjTableDatosPersonas().getModel();
                tabla.setNumRows(0);
                List<Persona> listaper = modelo.searchPersona(apellidos);

                Holder<Integer> i = new Holder<>(0);
                listaper.stream().forEach(pe -> {
                    tabla.addRow(new Object[10]);
                    vista.getjTableDatosPersonas().setValueAt(pe.getIdper(), i.value, 0);
                    vista.getjTableDatosPersonas().setValueAt(pe.getCedulaper(), i.value, 1);
                    vista.getjTableDatosPersonas().setValueAt(pe.getTipoper(), i.value, 2);
                    vista.getjTableDatosPersonas().setValueAt(pe.getNombresper(), i.value, 3);
                    vista.getjTableDatosPersonas().setValueAt(pe.getApellidosper(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getDireccionper(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getTelefonoper(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getCorreoper(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getGeneroper(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getFechaNacimiento(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getEstadoCivil(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getSalariobenefac(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getEstratoSbenefi(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getTitulo(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getSeguro(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getHorario(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getPeriodovol(), i.value, 4);
                    vista.getjTableDatosPersonas().setValueAt(pe.getTipovol(), i.value, 4);
                    Image foto = pe.getFotop();
                    if (foto != null) {
                        foto = foto.getScaledInstance(50, 70, Image.SCALE_SMOOTH);
                        ImageIcon icono = new ImageIcon(foto);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();
                        dtcr.setIcon(icono);
                        vista.getjTableDatosPersonas().setValueAt(new JLabel(icono), i.value, 8);
                    } else { //No venga foto
                        vista.getjTableDatosPersonas().setValueAt(null, i.value, 8);
                    }

                    i.value++;
                });
            }
        }
    };

    private void crearPersona() {
        //INSERT
        System.out.println("Se creo");
        String cedulaper = vista.getTxtcedulaPer().getText();
        String tipoper = (String) vista.getCbxTipoPer().getSelectedItem();
        String nombresper = vista.getTxtnombrePer().getText();
        String apellidosper = vista.getTxtapellidoPer().getText();
        String direccionper = vista.getTxtdireccionPer().getText();
        String telefonoper = vista.getTxttelefono().getText();
        String correoper = vista.getTxtcorreoPer().getText();
        String generoper = "";
        if (vista.getRbtMasculino().isSelected()) {
            generoper = "Masculino";
        }
        if (vista.getRbtFemenino().isSelected()) {
            generoper = "Femenino";
        }
        Date date = vista.getjDCFechaNacPer().getDate(); //ic es la interfaz, jDate el JDatechooser
        long d = date.getTime(); //guardamos en un long el tiempo
        java.sql.Date fechaNacimiento = new java.sql.Date(d);
        String estadoCivil = vista.getTxtestadocivil().getText();
        double salariobenefac = Double.valueOf(vista.getTxtsalario().getText());
        String estratoSbenefi = vista.getTxtestrato().getText();
        String titulo = vista.getTxtTitulo().getText();
        String seguro;
        if (vista.getChkseguroiees().isSelected()) {
            seguro = "Si";
        } else {
            seguro = "No";
        }
        String horario = vista.getTxthorario().getText();
        String periodovol = vista.getTxtperiodo().getText();
        String tipovol = vista.getTxtTipoVol().getText();

        ModeloPersona p = new ModeloPersona();
        p.setIdper(1);
        p.setCedulaper(cedulaper);
        p.setTipoper(tipoper);
        p.setNombresper(nombresper);
        p.setApellidosper(apellidosper);
        p.setDireccionper(direccionper);
        p.setTelefonoper(telefonoper);
        p.setCorreoper(correoper);
        p.setGeneroper(generoper);
        p.setFechaNacimiento(fechaNacimiento);
        p.setEstadoCivil(estadoCivil);
        p.setSalariobenefac(salariobenefac);
        p.setEstratoSbenefi(estratoSbenefi);
        p.setTitulo(titulo);
        p.setSeguro(seguro);
        p.setHorario(horario);
        p.setPeriodovol(periodovol);
        p.setTipovol(tipovol);

        try {
            FileInputStream img = new FileInputStream(jfc.getSelectedFile());
            int largo = (int) jfc.getSelectedFile().length();
            p.setImageFile(img);
            p.setLength(largo);
        } catch (IOException ex) {
            Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (p.setPersonaFoto()) {
            Resouces.success("Atención! ", "PERSONA CREADA");
            cargaDatos();
        } else {
            Resouces.error("Atención! ", "NO SE PUDO CREAR LA PERSONA");
        }
    }

    private void eliminarDonacion() {
        ModeloDonacion donacion1 = new ModeloDonacion();
        try {
            int m = vista.getjTableDatosPersonas().getSelectedRow();
            String id = String.valueOf(vista.getjTableDatosPersonas().getValueAt(m, 0));
            if (vista.getjTableDatosPersonas().getSelectedRow() >= 0) {
                DefaultTableModel dtm = (DefaultTableModel) vista.getjTableDatosPersonas().getModel();
                int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE ELIMINAR A ESA DONACION?");
                if (select == JOptionPane.YES_OPTION) {
                    dtm.removeRow(vista.getjTableDatosPersonas().getSelectedRow());
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
     
//        int select = JOptionPane.showConfirmDialog(vista, "¿ESTÁS SEGUR@ DE EDITAR LOS DATOS DE ESTA DONACION?");
//        if (select == JOptionPane.YES_OPTION) {
//            if (donacion.editarDonacion()) {
//                Resouces.success("Atención!!", "DONACION EDITADA :)");
//                cargaDatos();
//            } else {
//                JOptionPane.showMessageDialog(vista, "NO SE PUDO EDITAR LA DONACIÓN");
//            }
//        }
    }

    private void cargaDatos() {
        DefaultTableModel tabla;
        tabla = (DefaultTableModel) vista.getjTableDatosPersonas().getModel();
        tabla.setNumRows(0);

        List<Persona> listap = modelo.getPersonas();
        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(pe -> {
            tabla.addRow(new Object[10]);
            vista.getjTableDatosPersonas().setValueAt(pe.getIdper(), i.value, 0);
            vista.getjTableDatosPersonas().setValueAt(pe.getCedulaper(), i.value, 1);
            vista.getjTableDatosPersonas().setValueAt(pe.getTipoper(), i.value, 2);
            vista.getjTableDatosPersonas().setValueAt(pe.getNombresper(), i.value, 3);
            vista.getjTableDatosPersonas().setValueAt(pe.getApellidosper(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getDireccionper(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getTelefonoper(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getCorreoper(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getGeneroper(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getFechaNacimiento(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getEstadoCivil(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getSalariobenefac(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getEstratoSbenefi(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getTitulo(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getSeguro(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getHorario(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getPeriodovol(), i.value, 4);
            vista.getjTableDatosPersonas().setValueAt(pe.getTipovol(), i.value, 4);
            Image foto = pe.getFotop();
            if (foto != null) {
                foto = foto.getScaledInstance(50, 70, Image.SCALE_SMOOTH);
                ImageIcon icono = new ImageIcon(foto);
                DefaultTableCellRenderer dtcr = new DefaultTableCellHeaderRenderer();
                dtcr.setIcon(icono);
                vista.getjTableDatosPersonas().setValueAt(new JLabel(icono), i.value, 8);
            } else { //No venga foto
                vista.getjTableDatosPersonas().setValueAt(null, i.value, 8);
            }

            i.value++;
        });
    }

    private void examinarFoto() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(vista);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(vista.getLblFoto().getWidth(), vista.getLblFoto().getHeight(), Image.SCALE_DEFAULT);
                Icon icono = new ImageIcon(imagen);
                vista.getLblFoto().setIcon(icono);
                vista.getLblFoto().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(ControllerPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//    public void cargarDatosModificar() {
//        try {
//            int filaSelecionada = vista.getjTableDatosPersonas().getSelectedRow();
//            System.out.println(vista.getjTableDatosPersonas().getValueAt(filaSelecionada, 0).toString());
//            String iddona = vista.getjTableDatosPersonas().getValueAt(filaSelecionada, 0).toString();
//
//            List<Donacion> lista = modelo.DonaModif(iddona);
//            for (int i = 0; i < lista.size(); i++) {
//
//                vista.getTxaDetalleProdDON().setText(lista.get(i).getDetallePro());
//                vista.getjDateChooserFECHADONA().setDate(lista.get(i).getFechaEntrega());
//                vista.getTxaMotivoDON().setText(lista.get(i).getMotivodonacion());
//                //vista.getjComboBoxPersonasBenefactDon().setText(lista.get(i).getIdpersona());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void salir() {
        System.exit(0);
    }

}
