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

public class TASKCONTROLLER {

    public void Save(TASK task) {//tirar/colocar aspas
        String sql = "INSERT INTO tasks (NAME, DESCRIPTION, COMPLETED, NOTES, DEADLINE, "
                + "CREATED_AT, UPDATE_AT, ID_PROJECT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //estabelecendo a conexão com o banco
            connection = CONNECTIONFACTORY.getConnection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores do statement
            
            statement.setString(1, task.getNAME());
            statement.setString(2, task.getDESCRIPTION());
            statement.setBoolean(3, task.isIS_COMPLETED());
            statement.setString(4, task.getNOTES());
            statement.setDate(5, new Date(task.getDEADLINE().getTime()));
            statement.setDate(6, new Date(task.getCREATED_AT().getTime()));
            statement.setDate(7, new Date(task.getUPDATED_AT().getTime()));
            statement.setInt(8, task.getID_PROJECT());
            //executando a query
            statement.execute();

          //tratando erros/excessões  
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao salvar a tarefa " + ex.getMessage(), ex);

        } finally {
            //finalizando a conexão com o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement);

        }

    }

    public void Update(TASK task) {
        String sql = "UPDATE tasks SET "
                + " ID_PROJECT = ?, NAME = ?, DESCRIPTION = ?, NOTES = ?, DEADLINE = ?, COMPLETED = ?, CREATED_AT, "
                + "UPDATE_AT = ?, "
                + "WHERE ID_PROJECT = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // estabelecemos a conexão com o banco de dados 
            connection = CONNECTIONFACTORY.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando os valores do statement
            
            statement.setString(1, task.getNAME());
            statement.setString(2, task.getDESCRIPTION());
            statement.setBoolean(3, task.isIS_COMPLETED());
            statement.setString(4, task.getNOTES());
            statement.setDate(5, new Date(task.getDEADLINE().getTime()));
            //statement.setDate(6, new Date(task.getCREATED_AT().getTime()));
            statement.setDate(6, new Date(task.getUPDATED_AT().getTime()));
            statement.setInt(7, task.getID());
            statement.setInt(8, task.getID_PROJECT());
            //executando a query
            statement.execute();
            
            //tratando erros/excessões
        } catch (SQLException ex) {
              throw new RuntimeException("erro ao atualizar a tarefa " + ex.getMessage(), ex);

        } finally {
            //finalizando a conexão com o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
        

    }

    public void removeByID(int TASK_ID) {
        String SQL = "DELETE FROM tasks WHERE ID = ?";

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
        } catch (SQLException ex) {
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
                
                task.setNAME(resultSet.getString("NAME"));
                task.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                task.setNOTES(resultSet.getString("NOTES"));
                task.setIS_COMPLETED(resultSet.getBoolean("COMPLETED"));
                task.setDEADLINE(resultSet.getDate("DEADLINE"));
                task.setCREATED_AT(resultSet.getDate("CREATED_AT"));
                task.setUPDATED_AT(resultSet.getDate("UPDATE_AT"));
                task.setID_PROJECT(resultSet.getInt("ID_PROJECT"));
                
                tasks.add(task);
            }
         //tratando erros/excessões   
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao inserir tarefa" + ex.getMessage(), ex);
        }finally{
            //finalizando a conexão com  o banco 
            CONNECTIONFACTORY.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }
} 
