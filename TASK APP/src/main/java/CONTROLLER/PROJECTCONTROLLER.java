package CONTROLLER;

import MODEL.PROJECT;
import UTIL.CONNECTIONFACTORY;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PROJECTCONTROLLER {

    public void Save(PROJECT project) {

        String sql = "INSERT INTO project ( NAME, DESCRIPTION, "
                + "CREATED_AT, UPDATE_AT) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = CONNECTIONFACTORY.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getNAME());
            statement.setString(2, project.getDESCRIPTION());
            statement.setDate(3, new Date(project.getCREATED_AT().getTime()));
            statement.setDate(4, new Date(project.getUPDATE_AT().getTime()));

            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("erro ao salvar o projeto " + ex.getMessage(), ex);

        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
    }

    public void Update(PROJECT project) {
        String sql = "UPDATE project SET"
                + " NAME = ?, DESCRIPTION = ?, CREATED_AT = ?, UPDATE_AT = ?, WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = CONNECTIONFACTORY.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getNAME());
            statement.setString(2, project.getDESCRIPTION());
            statement.setDate(3, new Date(project.getCREATED_AT().getTime()));
            statement.setDate(4, new Date(project.getUPDATE_AT().getTime()));
            statement.setInt(5, project.getID());
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("erro ao atualizar projeto " + ex.getMessage(), ex);

        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }

    }

    public void RemoveByID(int PROJECT_ID) throws SQLException {
        String SQL = "DELETE FROM projects WHERE id = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = CONNECTIONFACTORY.getConnection();
            statement = connection.prepareStatement(SQL);

            connection = CONNECTIONFACTORY.getConnection();

            statement = connection.prepareStatement(SQL);
            statement.setInt(1, PROJECT_ID);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("erro ao deletar projeto" + ex.getMessage(), ex);

        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
    }

    public List<PROJECT> getall() {

        String sql = "SELECT * FROM projects WHERE PROJECT_ID = ?";

       

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
         List<PROJECT> projects = new ArrayList();
        
        try {
            connection = CONNECTIONFACTORY.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                PROJECT project = new PROJECT();

                project.setID(resultSet.getInt("ID"));
                project.setNAME(resultSet.getString("NAME"));
                project.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                project.setCREATED_AT(resultSet.getDate("CREATED_AT"));
                project.setUPDATE_AT(resultSet.getDate("UPDATE_AT"));

                projects.add(project);
            }

        } catch (Exception ex) {
            throw new RuntimeException("erro ao inserir projeto" + ex.getMessage(), ex);
        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement, resultSet);
        }

        return projects;

    }

}
