package CONTROLLER;

import MODEL.PROJECTS;
import UTIL.CONNECTIONFACTORY;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Essa classe controla a entrada e saida de PROJECTS do banco de dados. temos
 * nessa classe os métodos SAVE, UPDATE, REMOVEBYID e GETALL.
 *
 * @author victo
 */
public class PROJECTCONTROLLER {

    /**
     * O método SAVE recebe como parametro um PROJECT, pois esse é o metodo que
     * insere um novo PROJECT no banco.
     *
     *
     * @param projects
     */
    public void Save(PROJECTS projects) {

        //** tentando implementar o JPA acontece o seguinte erro 
        //** "no persistence provider for entitymanager named persistence unit"
        /* EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit"); 
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        entityManager.persist(projects);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
        return projects.getID();*/
        /**
         * Aqui temos que colocar os comandos SQL para inserir os projetos no
         * banco.
         */
        String sql = "INSERT INTO projects (`NAME`, `DESCRIPTION`, `CREATED_AT`, `UPDATE_AT`) VALUES (?, ?, ?, ?)";

        
        /**
         * Criação das variáveis de controle de conexão e do statement
         */
        Connection connection = null;
        PreparedStatement statement = null;

        /**
         * Neste próximo bloco de código temos que colocar um try/catch pois
         * aqui podemos ter algum erro.
         */
        try {
            /**
             * Estabelecendo a conexão com o banco
             */
            connection = CONNECTIONFACTORY.getConnection();

            /**
             * Preparando a query
             */
            statement = connection.prepareStatement(sql);

            /**
             * setando os valores do statement cada parametro representa uma
             * interrogação, por exemplo, parametro 1 vai pegar o nome,
             * pararametro 2, vamos pegar o texto de descrição do projeto,
             * seguindo sempre a sequência que foi escrita em comando SQL.
             *
             */
            statement.setString(1, projects.getNAME());
            statement.setString(2, projects.getDESCRIPTION());
            
            /**
             * IMPORTANTE!!
             * Nesse caso quando estamos trabalhando com uma data que vai ser gerada pelo SQL, 
             * temos que importar o Java.SQL.Date, para pegar a data exata do momento em que o
             * SQL foi inserido.
             */
            statement.setDate(3, new Date(projects.getCREATED_AT().getTime()));
            statement.setDate(4, new Date(projects.getUPDATE_AT().getTime()));

            /**
             * Este comando executa a query no banco de dados
             */
            statement.execute();

            /**
             * tratando erros/excessões com try/catch se algum processo acima
             * falhar, o usuário vai receber a mensagem de erro na tela
             */
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao salvar o projeto " + ex.getMessage(), ex);

            /**
             * Finalizando a conexão com o banco e statement
             */
        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }
    }

    /**
     * O método UPDATE serve para alterar algum dado que foi inserido na PROJECT
     * por isso recebe como parametro uma PROJECT
     *
     * @param projects
     */
    public void Update(PROJECTS projects) {

        /**
         * Aqui temos que usar o comando SQL UPDATE para alterar dados inseridos
         * no PROJECT, pegando como parametro o ID_PROJECT
         */
        String sql = "UPDATE projects SET"
                + " NAME = ?, DESCRIPTION = ?, CREATED_AT = ?, UPDATE_AT = ?, WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        /**
         * Neste próximo bloco de código temos que colocar um try/catch pois
         * aqui podemos ter algum erro.
         */
        try {

            /**
             * Estabelecendo a conexão com o banco de dados
             */
            connection = CONNECTIONFACTORY.getConnection();

            /**
             * Preparando a query
             */
            statement = connection.prepareStatement(sql);

            /**
             * setando os valores do statement cada parametro representa uma
             * interrogação, por exemplo, parametro 1 vai pegar o nome,
             * pararametro 2, vamos pegar o texto de descrição da tarefa,
             * seguindo sempre a sequência que foi escrita em comando SQL.
             */
            statement.setString(1, projects.getNAME());
            statement.setString(2, projects.getDESCRIPTION());
            statement.setDate(3, new Date(projects.getCREATED_AT().getTime()));
            statement.setDate(4, new Date(projects.getUPDATE_AT().getTime()));
            statement.setInt(5, projects.getID());

            /**
             * Este comando vai executar a query
             */
            statement.execute();

            /**
             * tratando erros/excessões com try/catch se algum processo acima
             * falhar, o usuário vai receber a mensagem de erro na tela
             */
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao atualizar projeto " + ex.getMessage(), ex);

            /**
             * Finalizando a conexão com o banco de dados
             */
        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }

    }

    /**
     * O método REMOVEBYID remove um projeto do banco, por isso recebe como
     * parametro o PROJECT_ID
     *
     * @param PROJECT_ID
     * @throws SQLException
     */
    public void RemoveByID(int PROJECT_ID) throws SQLException {

        /**
         * Neste bloco de código temos o JPA (Java persistence API)
         * implementado.
         */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.clear();

        entityManager.close();
        entityManagerFactory.close();

        /**
         * Nesse caso usar o comando SQL DELETE pegando a ID do projeto para
         * remover ele do banco.
         */
        /*String SQL = "DELETE FROM projects WHERE ID = ? ";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = CONNECTIONFACTORY.getConnection();
            statement = connection.prepareStatement(SQL);

            connection = CONNECTIONFACTORY.getConnection();

            statement = connection.prepareStatement(SQL);
        
        //Nesta próxima linha, estamos pedindo para setar o 1° valor com interrogação
        //e trocar ele pelo PROJE#CT_ID
            statement.setInt(1, PROJECT_ID);
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("erro ao deletar projeto" + ex.getMessage(), ex);

        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement);
        }*/
    }

    /**
     * Este método cria uma lista e mostra todas os PROJECTS, por isso tem como
     * parametro o ID_PROJECT.
     *
     * @return
     */
    public List<PROJECTS> getall() {

        /**
         * Neste comando SQL pegamos todas os dados do PROJECT usando o ID do
         * projeto.
         */
        String sql = "SELECT * FROM projects";

        /**
         * Iniciando a conexão
         */
        Connection connection = null;

        /*
        *preparando o statement
         */
        PreparedStatement statement = null;

        /**
         * O ResultSet serve para guardar a resposta que tivemos do select no banco 
         * de dados, como nesse método temos que ter retorno, o resultset vai trazer a 
         * informação que precisamos.
         */
        ResultSet resultSet = null;

        List<PROJECTS> projects = new ArrayList();

        try {
            /**
             * Iniciando a conexão
             */
            connection = CONNECTIONFACTORY.getConnection();
            /*
        *preparando o statement
             */
            statement = connection.prepareStatement(sql);

            /*
        * Pegando o valor retornado pela execução da query
             */
            resultSet = statement.executeQuery();
            
            
            /** WHILE -> Nesse caso o while serve para carregar as informações
             * que estiverem dentro do PROJETO no banco de dados.
             * .Next serve para, assim que terminar de buscar todas os dados de um PROJETO
             * ele vai para a próxima, até acabar a lista de PROJETO.
             * 
             */
            
            
            while (resultSet.next()) {

                PROJECTS project = new PROJECTS();
                
                /**Neste próximo bloco de código estamos pedindo para setar o valor 
                 * que pegamos do resultado (resultSet) de um PROJETO já criado.
                 * 
                 */

                project.setID(resultSet.getInt("ID"));
                project.setNAME(resultSet.getString("NAME"));
                project.setDESCRIPTION(resultSet.getString("DESCRIPTION"));
                project.setCREATED_AT(resultSet.getDate("CREATED_AT"));
                project.setUPDATE_AT(resultSet.getDate("UPDATE_AT"));

                
                /**
                 * E aqui estamos adicionando esse valor em uma ArrayList chamada PROJECTS.
                 */
                projects.add(project);
            }

            /**tratando erros/excessões com try/catch
          */ 
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao inserir projeto" + ex.getMessage(), ex);
            
            /**
             * Finalizando a conexão com o banco de dados.
             */
        } finally {
            CONNECTIONFACTORY.closeConnection(connection, statement, resultSet);
        }

        /** Como nesse método precisamos ter um retorno, pegamos o PROJECTS como retorno
        * 
        */
        return projects;

    }

}
