package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
* Proyecto Final - Inteligencia Artificial
* 
* Elaborado por: Eduardo Aarón Olmedo Mateos y Kevin Alexis Martinez Sanchez
*/

public class MiRender extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
        if((row%2==0)&&(isSelected == false)) {
                cell.setBackground(new Color(hex("CCD1D1")));
                cell.setForeground(Color.BLACK);
        }else if((row%2!=0)&&(isSelected == false)){
                cell.setBackground(new Color(hex("85C1E9")));
                cell.setForeground(Color.BLACK);
        }else {
                cell.setBackground(new Color(hex("34495E")));
                cell.setForeground(Color.WHITE);
        }
        table.setFont(new Font("Arial", 0, 14));		

        return cell;
    }
	
    public static int hex(String color_hex ){
        return Integer.parseInt(color_hex,  16 );
    }
	
}