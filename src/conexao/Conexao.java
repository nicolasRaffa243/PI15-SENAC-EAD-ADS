package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/mercadoraffa";
    private static final String USUARIO = "root"; 
    private static final String SENHA = "14nn89"; 

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }

    public static void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar: " + e.getMessage());
        }
    }
}

