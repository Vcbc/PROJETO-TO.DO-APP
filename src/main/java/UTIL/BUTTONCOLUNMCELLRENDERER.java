
package UTIL;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;


public class BUTTONCOLUNMCELLRENDERER extends DefaultTableCellRenderer {
    
    private String buttonType;
    
    public BUTTONCOLUNMCELLRENDERER(String buttonType){
        this.buttonType = buttonType;
        
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column){

        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        
        
        label.setHorizontalAlignment(JLabel.CENTER);
        
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));
        
        return label;
    }
}
