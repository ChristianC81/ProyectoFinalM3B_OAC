package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import modelo.ModeloProducto;
import modelo.Producto;
import vista.ViewAdministrador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laptop
 */
public class ControllerProducto {

    ModeloProducto model;
    ViewAdministrador vist;
    int filas;

    public ControllerProducto(ModeloProducto model, ViewAdministrador vist) {
        this.model = model;
        this.vist = vist;
        vist.setVisible(true);
        vist.setLocationRelativeTo(null);
        cargaDatos();
    }

    public void iniciaControl() {
        cargaDatos();
        vist.getBtnbuscarProd().addActionListener(l -> cargaDatos());
        vist.getBtnEDITARPROD().addActionListener(al-> editarProducto());
        vist.getBtnCREARPROD().addActionListener(lc -> crearProducto());
        vist.getBtnELIMINARPROD().addActionListener(le -> eliminarProducto());
    }

    private void crearProducto() {

        int cantidad = (int) vist.getjSpinnerCantidad().getValue();
        String tipoprod = vist.getTxtTipoProducto().getText();
        int iddonaprod = vist.getCbxIdDonacion().getSelectedIndex();
        int idproyprod = vist.getCbxProyecto().getSelectedIndex();

        ModeloProducto producto = new ModeloProducto();
        producto.setCantprod(cantidad);
        producto.setTipoprod(tipoprod);
        producto.setIddonaprod(iddonaprod);
        producto.setIdproyprod(idproyprod);

        if (producto.setProducto()) {
           Resouces.success("ATENCIÒN!!!", "Producto creado");
            cargaDatos();
        } else {
            Resouces.error("ERROR!!!", "No se pudo crear el producto");
        }
    }
    private void editarProducto() {

        int cantidad = (int) vist.getjSpinnerCantidad().getValue();
        String tipoprod = vist.getTxtTipoProducto().getText();
        int iddonaprod = vist.getCbxIdDonacion().getSelectedIndex();
        int idproyprod = vist.getCbxProyecto().getSelectedIndex();

        ModeloProducto producto = new ModeloProducto();
        producto.setCantprod(cantidad);
        producto.setTipoprod(tipoprod);
        producto.setIddonaprod(iddonaprod);
        producto.setIdproyprod(idproyprod);

        if (producto.updateProducto(producto.getIdprod())) {
            Resouces.success("ATENCIÒN!!!", "Producto editado");
            cargaDatos();
        } else {
            Resouces.error("ERROR!!!", "No se pudo editarr el producto");
        }
    }

    private void eliminarProducto() {
        ModeloProducto producto = new ModeloProducto();
        try {
            int m = vist.getjTableDatosProductos().getSelectedRow();
            int id = (int) vist.getjTableDatosProductos().getValueAt(m, 0);
            if (vist.getjTableDatosProductos().getSelectedRow() >= 0) {
                DefaultTableModel dtm = (DefaultTableModel) vist.getjTableDatosProductos().getModel();
                int select = JOptionPane.showConfirmDialog(vist, "¿ESTÁS SEGUR@ DE ELIMINAR A ESA PERSONA?");
                if (select == JOptionPane.YES_OPTION) {
                    dtm.removeRow(vist.getjTableDatosProductos().getSelectedRow());
                    producto.deletePersona(id);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una producto en la tabla");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(vist, "ERROR, Selecciona una producto de la tabla");
        }
    }

    public void cargarDatosModifProd() {
        try {
            int filaSelecionada = vist.getjTableDatosProductos().getSelectedRow();
            System.out.println(vist.getjTableDatosProductos().getValueAt(filaSelecionada, 0).toString());
            int ide = (int) vist.getjTableDatosProductos().getValueAt(filaSelecionada, 0);

            List<Producto> lista = model.productoModif(ide);
            for (int i = 0; i < lista.size(); i++) {

                vist.getjSpinnerCantidad().setValue(lista.get(i).getCantprod());
                vist.getTxtTipoProducto().setText(lista.get(i).getTipoprod());
                vist.getCbxIdDonacion().setSelectedIndex(lista.get(i).getIddonaprod());
                vist.getCbxProyecto().setSelectedIndex(lista.get(i).getIdproyprod());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void tbl() {
        try {
            int edit = vist.getjTableDatosProductos().getSelectedRow();
            vist.getjSpinnerCantidad().setValue(String.valueOf(vist.getjTableDatosProductos().getValueAt(edit, 1)));
            vist.getTxtTipoProducto().setText((String) vist.getjTableDatosProductos().getValueAt(edit, 2));
            vist.getCbxIdDonacion().setSelectedIndex((int) vist.getjTableDatosProductos().getValueAt(edit, 3));
            vist.getCbxProyecto().setSelectedIndex((int) vist.getjTableDatosProductos().getValueAt(edit, 4));
        } catch (Exception E) {
            System.out.println(E);

        }
    }

    private void cargaDatos() {

        DefaultTableModel tabla;
        tabla = (DefaultTableModel) vist.getjTableDatosProductos().getModel();
        tabla.setNumRows(0);

        List<Producto> listap = model.getProducto();
        Holder<Integer> i = new Holder<>(0);

        listap.stream().forEach(per -> {
            tabla.addRow(new Object[5]);
            vist.getjTableDatosProductos().setValueAt(per.getIdprod(), i.value, 0);
            vist.getjTableDatosProductos().setValueAt(per.getCantprod(), i.value, 1);
            vist.getjTableDatosProductos().setValueAt(per.getTipoprod(), i.value, 2);
            vist.getjTableDatosProductos().setValueAt(per.getIddonaprod(), i.value, 3);
            vist.getjTableDatosProductos().setValueAt(per.getIdproyprod(), i.value, 4);
            i.value++;
        });
    }

    private void limpiar() {
        vist.getTxtTipoProducto().setText("");
        vist.getCbxIdDonacion().setSelectedIndex(0);
        vist.getCbxProyecto().setSelectedIndex(0);
        vist.getjSpinnerCantidad().setValue(0);
    }

    KeyListener kyl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getSource() == vist.getTxtBsqProductos()) {

                String tipo = vist.getTxtBsqProductos().getText();

                DefaultTableModel tabla;
                tabla = (DefaultTableModel) vist.getjTableDatosProductos().getModel();
                tabla.setNumRows(0);
                List<Producto> listap = model.buscaProducto(tipo);

                Holder<Integer> i = new Holder<>(0);
                listap.stream().forEach(pe -> {
                    tabla.addRow(new Object[5]);
                    vist.getjTableDatosProductos().setValueAt(pe.getIdprod(), i.value, 0);
                    vist.getjTableDatosProductos().setValueAt(pe.getCantprod(), i.value, 1);
                    vist.getjTableDatosProductos().setValueAt(pe.getTipoprod(), i.value, 2);
                    vist.getjTableDatosProductos().setValueAt(pe.getIddonaprod(), i.value, 3);
                    vist.getjTableDatosProductos().setValueAt(pe.getIdproyprod(), i.value, 4);
                    i.value++;
                });
            }

        }
    };
}
