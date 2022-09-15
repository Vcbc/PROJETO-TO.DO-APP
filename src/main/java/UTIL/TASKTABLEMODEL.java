package UTIL;

import MODEL.TASK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TASKTABLEMODEL extends AbstractTableModel {

    String[] columns = {"Nome", "Descriçao", "Prazo", "Tarefa concluida", "Editar", "Excluir"};
    List<TASK> tasks = new ArrayList();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];

    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;

        /*if(columnIndex == 3)
          return true;
      
      else 
          return false;*/
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return tasks.get(rowIndex).getNAME();

            case 1:
                return tasks.get(rowIndex).getDESCRIPTION();

            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDEADLINE());

            case 3:
                return tasks.get(rowIndex).isIS_COMPLETED();

           /* case 4:
                return "";

            case 5:
                return "";*/

            default:
                return "Dados não encontrados";

        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIS_COMPLETED((boolean) aValue);
        
        

    }

    public String[] getColunms() {
        return columns;
    }

    public List<TASK> getTasks() {
        return tasks;
    }

    public void setTasks(List<TASK> tasks) {
        this.tasks = tasks;
    }

}
