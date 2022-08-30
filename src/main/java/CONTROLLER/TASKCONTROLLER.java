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

public class TASKCONTROLLER {

    public void Save(TASK task) {
        String sql = "INSERT INTO tasks (ID_PROJECT, NAME, DESCRIPTION, COMPLETED, NOTES, DEALINE, "
                + "CREATED_AT, UPDATE_AT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //estabelecendo a conexão com o banco
            connection = CONNECTIONFACTORY.getConnection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores do statement
            statement.setInt(1, task.getID_PROJECT());
            statement.setString(2, task.getNAME());
            statement.setString(3, task.getDESCRIPTION());
            statement.setBoolean(4, task.isIS_COMPLETED());
            statement.setString(5, task.getNOTES());
            statement.setDate(6, new Date(task.getDEADLINE().getTime()));
            statement.setDate(7, new Date(task.getCREATED_AT().getTime()));
            statement.setDate(8, new Date(task.getUPDATED_AT().getTime()));
            //executando a query
            statement.execute();

          //tratando erros/excessões  
        } catch (Exception ex) {
            throw new RuntimeException("erro ao salvar a tarefa " + ex.getMessage(), ex);

        } finally {
            //finalizando a conexão com o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement);

        }

    }

    public void Update(TASK task) {
        String sql = "UPDATE tasks SET"
                + "ID_PROJECT = ?, NAME = ?, DESCRIPTION = ?, NOTES = ?, DEADLINE = ?, COMPLETED = ?, CREATED_AT = ?,"
                + "UPDATE_AT = ?,"
                + "WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // estabelecemos a conexão com o banco de dados 
            connection = CONNECTIONFACTORY.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando os valores do statament
            statement.setInt(1, task.getID_PROJECT());
            statement.setString(2, task.getNAME());
            statement.setString(3, task.getDESCRIPTION());
            statement.setBoolean(4, task.isIS_COMPLETED());
            statement.setString(5, task.getNOTES());
            statement.setDate(6, new Date(task.getDEADLINE().getTime()));
            statement.setDate(7, new Date(task.getCREATED_AT().getTime()));
            statement.setDate(8, new Date(task.getUPDATED_AT().getTime()));
            statement.setInt(9, task.getID());
            //executando a query
            statement.execute();
            
            //tratando erros/excessões
        } catch (Exception ex) {
              throw new RuntimeException("erro ao atualizar a tarefa " + ex.getMessage(), ex);

        } finally {
            //finalizando a conexão com o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
        

    }

    public void removeByID(int TASK_ID) throws SQLException {
        String SQL = "DELETE FROM tasks WHRE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //criação da conexão com o banco 
            connection = CONNECTIONFACTORY.getConnection();
            //preparando a query
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, TASK_ID);
            //executando a query
            statement.execute();
            
         //tratando erros//excessões   
        } catch (Exception ex) {
            throw new RuntimeException("erro ao deletar tarefa" + ex.getMessage(), ex);
        } finally {
            //finalizando a conexão com o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement);

        }

    }
    //método que cria uma lista e guarda as infos em cada campo
    public List<TASK> getAll(int ID_Project) {
        
        String sql = "SELECT * FROM tasks WHERE ID_PROJECT = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //criação do objeto TASK, como uma arraylist
        List <TASK> tasks = new ArrayList();
        
        try {
            //criação da conexão com banco
            connection = CONNECTIONFACTORY.getConnection();
            //preparando o statement
            statement = connection.prepareStatement(sql);
            //setando o valor que corresponde ao filtro de busca
            statement.setInt(1, ID_Project);
            //valor retornado pela execução da query
            resultSet = statement.executeQuery();
            //enquanto houverem valores sendo carregados pelo resultset
            while(resultSet.next()){
                TASK task = new TASK();
                task.setID(resultSet.getInt("ID"));
                task.setID_PROJECT(resultSet.getInt("ID_PROJECT"));
                task.setNAME(resultSet.getString("NAME"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setNOTES(resultSet.getString("NOTES"));
                task.setIS_COMPLETED(resultSet.getBoolean("COMPLETED"));
                task.setDEADLINE(resultSet.getDate("DEADLINE"));
                task.setCREATED_AT(resultSet.getDate("CREATED_AT"));
                task.setUPDATED_AT(resultSet.getDate("UPDATED_AT"));
                
                tasks.add(task);
            }
         //tratando erros/excessões   
        } catch (Exception ex) {
            throw new RuntimeException("erro ao inserir tarefa" + ex.getMessage(), ex);
        }finally{
            //finalizando a conexão com  o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }
} 
