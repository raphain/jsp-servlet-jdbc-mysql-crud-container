package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.Container;

public class ContainerDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/dbcontainer?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "internet1";
    
    private static final String INSERT_CONTAINER_SQL = "INSERT INTO container" + "  (cliente, numero, tipo, status, categoria) VALUES " +
            " (?, ?, ?, ?, ?);";

        private static final String SELECT_CONTAINER_BY_ID = "select idcontainer,cliente,numero,tipo,status,categoria from container where idcontainer =?;";
        private static final String SELECT_ALL_CONTAINER = "select * from container;";
        private static final String DELETE_CONTAINER_SQL = "delete from container where idcontainer = ?;";
        private static final String UPDATE_CONTAINER_SQL = "update container set cliente = ?,numero= ?, tipo =?, status=?, categoria =? where idcontainer = ?;";

        public ContainerDAO() {}

        protected Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (SQLException e) {
             
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
             
                e.printStackTrace();
            }
            return connection;
        }

        public void insertContainer(Container container) throws SQLException {
            System.out.println(INSERT_CONTAINER_SQL);
            
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTAINER_SQL)) {
                preparedStatement.setString(1, container.getCliente());
                preparedStatement.setString(2, container.getNumero());
                preparedStatement.setString(3, container.getTipo());
                preparedStatement.setString(4, container.getStatus());
                preparedStatement.setString(5, container.getCategoria());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }
        }

        public Container selectContainer(int idcontainer) {
            Container container = null;
             
            try (Connection connection = getConnection();
              
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTAINER_BY_ID);) {
                preparedStatement.setInt(1, idcontainer);
                System.out.println(preparedStatement);
                 
                ResultSet rs = preparedStatement.executeQuery();

                 
                while (rs.next()) {
                	String numero = rs.getString("numero");
                	String cliente = rs.getString("cliente");
                    String tipo = rs.getString("tipo");
                    String status = rs.getString("status");
                    String categoria = rs.getString("categoria");
                    container = new Container(idcontainer, cliente, numero, tipo, status, categoria);
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return container;
        }

        public List < Container > selectAllContainer() {

 
            List < Container > containers = new ArrayList < > ();
 
            try (Connection connection = getConnection();

  
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTAINER);) {
                System.out.println(preparedStatement);
   
                ResultSet rs = preparedStatement.executeQuery();

    
                while (rs.next()) {
                    int idcontainer = rs.getInt("idcontainer");
                    String cliente = rs.getString("cliente");
                    String numero = rs.getString("numero");
                    String tipo = rs.getString("tipo");
                    String status = rs.getString("status");
                    String categoria = rs.getString("categoria");
                    containers.add(new Container(idcontainer, cliente, numero, tipo, status, categoria));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return containers;
        }

        public boolean deleteContainer(int idcontainer) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CONTAINER_SQL);) {
                statement.setInt(1, idcontainer);
                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
        }

        public boolean updateContainer(Container container) throws SQLException {
            boolean rowUpdated;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CONTAINER_SQL);) {
                statement.setString(1, container.getCliente());
                statement.setString(2, container.getNumero());
                statement.setString(3, container.getTipo());
                statement.setString(4, container.getStatus());
                statement.setString(5, container.getCategoria());
                statement.setInt(6, container.getIdcontainer());

                rowUpdated = statement.executeUpdate() > 0;
            }
            return rowUpdated;
        }

        private void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
                if (e instanceof SQLException) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }

}
