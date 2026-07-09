package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import supermercadoraffa.Produtos;
import conexao.Conexao;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import supermercadoraffa.Produtos;

public class ProdutoDAO {
    
     public List<Produtos> pesquisarProdutos(String pesquisa) {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE nome LIKE ? OR marca LIKE ?"; // Pesquisa pelo nome ou marca
        
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Define o critério de pesquisa para o nome ou marca
            stmt.setString(1, "%" + pesquisa + "%");
            stmt.setString(2, "%" + pesquisa + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setMarca(rs.getString("marca"));
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date dataSQL = rs.getDate("validade");
                if (dataSQL != null) {
                    p.setValidade(formato.format(dataSQL)); 
                } else {
                    p.setValidade(""); 
                }
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar produtos: " + e.getMessage());
        }
        return lista;
    }
    
    public void excluirProduto(int id) {
    String sql = "DELETE FROM produtos WHERE id = ?";

    try (Connection con = Conexao.conectar();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Produto excluído com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao excluir produto: " + e.getMessage());
    }
}
    
    public void cadastrarProduto(Produtos produto) {
        String sql = "INSERT INTO produtos (nome, marca, validade) VALUES (?, ?, ?)";
        
        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setDate(3, Date.valueOf(produto.getValidade()));
            
            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    public List<Produtos> listarProdutos() {
        List<Produtos> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection con = Conexao.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produtos p = new Produtos();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setMarca(rs.getString("marca"));
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
Date dataSQL = rs.getDate("validade");
if (dataSQL != null) {
    p.setValidade(formato.format(dataSQL)); 
} else {
    p.setValidade(""); 
}
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }
    
    

}
