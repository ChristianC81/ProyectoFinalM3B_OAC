
package controlador;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author miri
 */
public class ImagenTabla extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //EL override va a la tabla y hace que acepte un jlabel aparte de los datos que tiene
        if(value instanceof JLabel){
            JLabel jlb=(JLabel)value;
            return jlb;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
}
