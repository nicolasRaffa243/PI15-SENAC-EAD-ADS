
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.Conexao;

public class UsuarioDAO {
    public String autenticar(String usuario, String senha) {
        String sql = "SELECT usuario FROM usuarios WHERE usuario = ? AND senha = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("usuario"); // retorna o cargo
            } else {
                return null;
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return null;
        }
    }
}