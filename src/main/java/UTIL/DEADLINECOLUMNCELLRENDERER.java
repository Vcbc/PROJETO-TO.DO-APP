
package UTIL;

import MODEL.TASK;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Nessa classe vamos implementar a troca de cores da celula de prazo quando a tarefa
 * estiver no prazo ou quando estiver atrasada.
 * @author victo
 */

public class DEADLINECOLUMNCELLRENDERER extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column){

        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        
        
        label.setHorizontalAlignment(CENTER);
        
        TASKTABLEMODEL taskModel = (TASKTABLEMODEL) table.getModel();
        TASK task = taskModel.getTasks().get(row);
        
        if (task.getDEADLINE().after(new Date())){
           
            label.setBackground(Color.GREEN);
            
        }else{
            label.setBackground(Color.RED);
        }
        
         return label;
    }


}
