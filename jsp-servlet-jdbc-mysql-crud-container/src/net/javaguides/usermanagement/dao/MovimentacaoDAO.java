package net.javaguides.usermanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import net.javaguides.usermanagement.model.Movimentacao;

public class MovimentacaoDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/dbcontainer?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "internet1";
    
    private static final String INSERT_MOVIMENTACAO_SQL = "INSERT INTO movimentacao" + "  (navio, tipomovimentacao, dt_inicio, dt_fim) VALUES " +
            " (?, ?, ?, ?);";

        private static final String SELECT_MOVIMENTACAO_BY_ID = "select idmovimentacao,navio,tipomovimentacao,dt_inicio,dt_fim from movimentacao where idmovimentacao =?";
        private static final String SELECT_ALL_MOVIMENTACAO = "select * from movimentacao";
        private static final String DELETE_MOVIMENTACAO_SQL = "delete from movimentacao where idcontainer = ?;";
        private static final String UPDATE_MOVIMENTACAO_SQL = "update movimentacao set navio = ?,tipomovimentacao= ?, dt_inicio =?, dt_fim=? where idmovimentacao = ?;";

        public MovimentacaoDAO() {}

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

        public void insertMovimentacao(Movimentacao movimentacao) throws SQLException {
            System.out.println(INSERT_MOVIMENTACAO_SQL);
            
            try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIMENTACAO_SQL)) {
                preparedStatement.setString(1, movimentacao.getNavio());
                preparedStatement.setString(2, movimentacao.getTipo_mov());
                preparedStatement.setDate(3, movimentacao.getDt_inicio());
                preparedStatement.setDate(3, movimentacao.getDt_fim());;
             
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }
        }

        public Movimentacao selectMovimentacao(int idmovimentacao) {
            Movimentacao movimentacao = null;
             
            try (Connection connection = getConnection();
              
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIMENTACAO_BY_ID);) {
                preparedStatement.setInt(1, idmovimentacao);
                System.out.println(preparedStatement);
                 
                ResultSet rs = preparedStatement.executeQuery();

                 
                while (rs.next()) {
                    String navio = rs.getString("navio");
                    String tipo_mov = rs.getString("tipo_mov");
                    Date dt_inicio = rs.getDate("dt_inicio");
                    Date dt_fim = rs.getDate("dt_fim");
                    movimentacao = new Movimentacao(idmovimentacao, navio, tipo_mov, dt_inicio, dt_fim);
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return movimentacao;
        }

        public List < Movimentacao > selectAllMovimentacao() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < Movimentacao > movimentacao = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIMENTACAO);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int idmovimentacao = rs.getInt("idmovimentacao");
                    String navio = rs.getString("navio");                  
                    String tipo_mov = rs.getString("tipo_mov");
                    Date dt_inicio = rs.getDate("dt_inicio");
                    Date dt_fim = rs.getDate("dt_fim");
                    movimentacao.add(new Movimentacao(idmovimentacao, navio, tipo_mov, dt_inicio, dt_fim));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return movimentacao;
        }

        public boolean deleteMovimentacao(int idmovimentacao) throws SQLException {
            boolean rowDeleted;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIMENTACAO_SQL);) {
                statement.setInt(1, idmovimentacao);
                rowDeleted = statement.executeUpdate() > 0;
            }
            return rowDeleted;
        }

        public boolean updateMovimentacao(Movimentacao movimentacao) throws SQLException {
            boolean rowUpdated;
            try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIMENTACAO_SQL);) {
                statement.setString(1, movimentacao.getNavio());
                statement.setString(2, movimentacao.getTipo_mov());
                statement.setDate(3, movimentacao.getDt_inicio());
                statement.setDate(4, movimentacao.getDt_fim());
                statement.setInt(5, movimentacao.getIdmovimentacao());

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
