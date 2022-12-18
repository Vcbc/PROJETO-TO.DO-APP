package UTIL;

import MODEL.TASK;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Nesta classe vamos configurar o grid (tabela) que vai ser exibido para 
 * o usu�rio com as tarefas de cada projeto.
 * @author victo
 */


/**
 * temos que usar Heran�a nesta classe para obter todas as op��es de 
 * implementa��o que o AbstractTableModel proporciona.
 * @author victo
 */
public class TASKTABLEMODEL extends AbstractTableModel {
    
   

    /**
     * Cria��o de um vetor para obter o nome que queremos de cada coluna 
     * E cria��o de um objeto lista que vai obter as tarefas
     */
    String[] columns = {"Nome", "Descri�ao", "Prazo", "Tarefa concluida", "Editar", "Excluir"};
    List<TASK> tasks = new ArrayList();

    /**
     * M�todos abstratos que existem na classe AbstractTableModel e s�o 
     * implementados automaticamente.
     * GetRowCount(), GetColumnCount e GetValueAt().
     * @return 
     */
    
    /**
     * neste m�todos vamos retornar a quantidade de tarefas
     * @return 
     */
    @Override
    public int getRowCount() {
        return tasks.size();
    }

    /**
     * neste m�todo vamos retornar o n�mero de colunas 
     * @return 
     */
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    /**
     * neste metodo vamos implementar a descri��o de cada coluna 
     * que vai aparecer no grid
     * @param columnIndex
     * @return 
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];

    }
    /**
     * neste metodo vamos fazer com que apenas o indice de coluna 3 seja edit�vel
     * @param rowIndex
     * @param columnIndex
     * @return 
     */

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
        
        

    }
    /**
     * m�todo que retorna o o tipo do conteudo que est� na celula
     * se a tarefa estiver vazia, retorna um tipo object, sen�o, o m�todo
     * getValueAt � chamado e pega o tipo do valor que est� na celula.
     * @param columnIndex
     * @return 
     */

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (tasks.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();

    }

    /**
     * Neste m�todo vamos pegar o valor de cada posi��o
     * e exibir no grid, lembrando que, rowIndex � o indice de linha
     * e columnIndex � o indice de coluna.
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            
            /**
             * Na primeiro coluna vamos exibir o nome da task baseado rowIndex dela
             */
            case 0:
                return tasks.get(rowIndex).getNAME();

                /**
                 * na segunda coluna vamos exibir a descri��o da tarefa baseado no rowIndex dela
                 */
            case 1:
                return tasks.get(rowIndex).getDESCRIPTION();

                /**
                 * na terceira coluna vamos exibir o prazo em formato de data
                 */
            case 2:
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return dateFormat.format(tasks.get(rowIndex).getDEADLINE());

                /**
                 * na quarta linha vamos exibir a informa��o se a tarefa est� 
                 * concluida ou n�o.
                 */
            case 3:
                return tasks.get(rowIndex).isIS_COMPLETED();

           case 4:
                return "";

            case 5:
                return "";

            default:
                return "Dados n�o encontrados" ;

        }
    }
    /**
     * metodo para setar as informa��es das tarefas
     * @param aValue
     * @param rowIndex
     * @param columnIndex 
     */

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        /**
         * aqui n�s temos que fazer um CAST para converter um OBJECT em BOOLEAN
         */
        tasks.get(rowIndex).setIS_COMPLETED((boolean) aValue);
        tasks.get(rowIndex).getNAME();
        tasks.get(rowIndex).getDESCRIPTION();
        tasks.get(rowIndex).getNOTES();
        tasks.get(rowIndex).getDEADLINE();
        
        
        

    }

    /**
     * m�todos get para colunas e tarefas
     * @return 
     */
    public String[] getColunms() {
        return columns;
    }

    public List<TASK> getTasks() {
        return tasks;
    }

    /**
     * metodo set para setar a lista de tarefas
     * @param tasks 
     */
    public void setTasks(List<TASK> tasks) {
        this.tasks = tasks;
    }

}
