package CONTROLLER;

import MODEL.TASK;
import UTIL.CONNECTIONFACTORY;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 * Essa classe controla a entrada e saida de TASK do banco de dados.
 * temos nessa classe os m�todos SAVE, REMOVE BY ID, UPDATE e GETALL.
 * 
 * @author victo
 */

public class TASKCONTROLLER {

    /**
     * O m�todo SAVE recebe como parametro uma TASK, pois esse � o metodo que insere uma nova TASK no banco.
     * @param task 
     */
    public void Save(TASK task) {
        
        /**
         * Aqui temos que colocar os comandos SQL para inserir as tarefas no banco.
         */
        String sql = "INSERT INTO tasks (NAME, DESCRIPTION, COMPLETED, NOTES, DEADLINE, "
                + "CREATED_AT, UPDATE_AT, ID_PROJECT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
        /**
         * Cria��o das vari�veis de controle de conex�o e do statement
         */
        Connection connection = null;
        PreparedStatement statement = null;
        
        /**
         * Neste pr�ximo bloco de c�digo temos que colocar um try/catch pois 
         * aqui podemos ter algum erro.
         */

        try {
            /**estabelecendo a conex�o com o banco 
             */
            connection = CONNECTIONFACTORY.getConnection();
            
            /**preparando a query 
             */
            statement = connection.prepareStatement(sql);
            
            /**setando os valores do statement
             * cada parametro representa uma interroga��o, por exemplo, parametro 1 
             * vai pegar o nome, pararametro 2, vamos pegar o texto de descri��o da tarefa, seguindo sempre
             * a sequ�ncia que foi escrita em comando SQL.
              */
            statement.setString(1, task.getNAME());
            statement.setString(2, task.getDESCRIPTION());
            statement.setBoolean(3, task.isIS_COMPLETED());
            statement.setString(4, task.getNOTES());
            
            /**
             * IMPORTANTE!!
             * Nesse caso quando estamos trabalhando com uma data que vai ser gerada pelo SQL, 
             * temos que importar o Java.SQL.Date, para pegar a data exata do momento em que o
             * SQL foi inserido.
             */
            statement.setDate(5, new Date(task.getDEADLINE().getTime()));
            statement.setDate(6, new Date(task.getCREATED_AT().getTime()));
            statement.setDate(7, new Date(task.getUPDATED_AT().getTime()));
            statement.setInt(8, task.getID_PROJECT());
            
            /**Este comando vai executar a query no banco de dados
             */
            statement.execute();

          /**tratando erros/excess�es com try/catch
           * se algum processo acima falhar, o usu�rio vai receber a mensagem de erro na tela
           */  
        } catch (Exception ex) {
            throw new RuntimeException("erro ao salvar a tarefa " + ex.getMessage(), ex);

        } finally {
            /**finalizando a conex�o com o banco e statement
             * 
             */ 
            CONNECTIONFACTORY.closeConnection(connection, statement);

        }

    }

    /**
     * O m�todo UPDATE serve para alterar algum dado que foi inserido na TASK
     * por isso recebe como parametro uma TASK
     * @param task 
     */
    public void Update(TASK task) {
        
        /**
         * Aqui temos que usar o comando UPDATE no banco, passando os novos dados 
         * e dizendo em qual ID do projeto e em qual ID da task vai ser atualizado.
         */
        String sql = "UPDATE tasks SET "
                + " NAME = ?, DESCRIPTION = ?, NOTES = ?, COMPLETED = ?, DEADLINE = ?, "
                + " UPDATE_AT = ?, ID_PROJECT = ? "
                + "WHERE ID = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            /** estabelecemos a conex�o com o banco de dados 
             */ 
            connection = CONNECTIONFACTORY.getConnection();
            
            /**preparando a query
             */
            statement = connection.prepareStatement(sql);
            
            /**setando os valores do statement
             *  * cada parametro representa uma interroga��o, por exemplo, parametro 1 
             * vai pegar o nome, pararametro 2, vamos pegar o texto de descri��o da tarefa, seguindo sempre
             * a sequ�ncia que foi escrita em comando SQL.
             */
            
            statement.setString(1, task.getNAME());
            statement.setString(2, task.getDESCRIPTION());
            statement.setString(3, task.getNOTES());
            statement.setBoolean(4, task.isIS_COMPLETED());
            statement.setDate(5, new Date(task.getDEADLINE().getTime()));
            statement.setDate(6, new Date(task.getUPDATED_AT().getTime()));         
            statement.setInt(7, task.getID_PROJECT());
            statement.setInt(8, task.getID());
            
            /**executando a query
            */
            statement.execute();
            
            /**tratando erros/excess�es com try/catch 
             */
        } catch (Exception ex) {
              throw new RuntimeException("erro ao atualizar a tarefa " + ex.getMessage(), ex);

        } finally {
            /**finalizando a conex�o com o banco 
             */ 
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
        

    }
    
    /**
     * O m�todo REMOVE_BY_ID serve para remover uma TASK do banco, por isso 
     * recebe como parametro a ID da TASK
     * @param TASK_ID 
     */

    public void removeByID(int TASK_ID) {
        /**
         * Nesse caso usar o comando SQL DELETE pegando a ID da TASK para 
         * remover ela do banco.
         */
        String SQL = "DELETE FROM tasks WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            /**cria��o da conex�o com o banco 
             */
            connection = CONNECTIONFACTORY.getConnection();
            
            /**preparando a query 
             */
            statement = connection.prepareStatement(SQL);
            
            /** Aqui vamos setar o valor que foi passado como parametro, no caso
             * o TASK_ID, prq � ele que vai substituir a interroga��o.
             */
            statement.setInt(1, TASK_ID);
            
            /**executando a query 
             */
            statement.execute();
            
         /**tratando erros//excess�es com try/catch 
          */   
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao deletar tarefa" + ex.getMessage(), ex);
        } finally {
            /**finalizando a conex�o com o banco 
             */ 
            CONNECTIONFACTORY.closeConnection(connection, statement);

        }

    }
    /**Este m�todo cria uma lista e mostra todas as TASKS do ID do projeto, por isso
     * tem como parametro o ID_PROJECT. 
     * @param ID_Project
     * @return 
     * tem como retorno as TASKS inseridas no banco.
     */
    public List<TASK> getAll(int ID_Project) {
        
        
        /**
         * Neste comando SQL pegamos todas os dados da TASK usando o ID do projeto.
         */
        String sql = "SELECT * FROM tasks WHERE ID_PROJECT = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        /**
         * O ResultSet serve para guardar a resposta que tivemos do select no banco 
         * de dados, como nesse m�todo temos que ter retorno, o resultset vai trazer a 
         * informa��o que precisamos.
         */
        ResultSet resultSet = null;
        
        /**Cria��o do objeto TASK, como uma arraylist
         * 
         */
        List <TASK> tasks = new ArrayList();
        
        try {
            /**cria��o da conex�o com banco 
             */
            connection = CONNECTIONFACTORY.getConnection();
            
            /**preparando o statement 
             */
            statement = connection.prepareStatement(sql);
            
            /**setando o valor que corresponde ao filtro de busca
             */
            statement.setInt(1, ID_Project);
            /**valor retornado pela execu��o da query 
             */
            resultSet = statement.executeQuery();
            
            /** WHILE -> Nesse caso o while serve para carregar as informa��es
             * que estiverem dentro da TASK no banco de dados.
             * .Next serve para, assim que terminar de buscar todas os dados de uma TASK
             * ele vai para a pr�xima, at� acabar a lista de TASK.
             * 
             */
            
            
            while(resultSet.next()){
                TASK task = new TASK();
               
                /**Neste pr�ximo bloco de c�digo estamos pedindo para setar o valor 
                 * que pegamos do resultado (resultSet) de uma TASK j� criada.
                 * 
                 */
                task.setID(resultSet.getInt("ID"));
                task.setNAME(resultSet.getString("NAME"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setNOTES(resultSet.getString("NOTES"));
                task.setIS_COMPLETED(resultSet.getBoolean("COMPLETED"));
                task.setDEADLINE(resultSet.getDate("DEADLINE"));
                task.setCREATED_AT(resultSet.getDate("CREATED_AT"));
                task.setUPDATED_AT(resultSet.getDate("UPDATE_AT"));
                task.setID_PROJECT(resultSet.getInt("ID_PROJECT"));
                
                /**
                 * E aqui estamos adicionando esse valor em uma ArrayList chamada TASK
                 */
                tasks.add(task);
            }
         /**tratando erros/excess�es com try/catch
          */  
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao inserir tarefa" + ex.getMessage(), ex);
        }finally{
            /**finalizando a conex�o com  o banco 
             */ 
            CONNECTIONFACTORY.closeConnection(connection, statement, resultSet);
        }
        /** Como nesse m�todo precisamos ter um retorno, pegamos a TASK como retorno
        * 
        */
        return tasks;
    }
} 
