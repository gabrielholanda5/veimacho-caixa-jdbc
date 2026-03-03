package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.Conexao;
import model.Produto;

public class ProdutoDAO {
	
	public List<Produto> listarTodos() {
	
		List<Produto> produtos = new ArrayList<>();
	
	    String sql = "SELECT * FROM produto";
	
	    try (Connection conn = Conexao.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	
	        while (rs.next()) {
	
	            Produto produto = new Produto();
	
	            produto.setId(rs.getInt("id"));
	            produto.setNome(rs.getString("nome"));
	            produto.setPreco(rs.getDouble("preco"));
	            produto.setQtdEstoque(rs.getInt("qtd_estoque"));
	
	            produtos.add(produto);
	        }
	
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao listar produtos", e);
	    }
	
	    return produtos;
	   
	}
	
	public void inserir(Produto produto) {
		
		String sql = "INSERT INTO produto (nome, preco, qtd_estoque) VALUES (?, ?, ?)";
		
		try (Connection conn = Conexao.conectar();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setInt(3, produto.getQtdEstoque());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao inserir produto", e);
		}
		
	}
	
	public Produto buscarPorId(int id) {
		
		String sql = "SELECT * FROM produto WHERE id = ?";
		
		try (Connection conn = Conexao.conectar();
			 PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
	            Produto produto = new Produto();
	            produto.setId(rs.getInt("id"));
	            produto.setNome(rs.getString("nome"));
	            produto.setPreco(rs.getDouble("preco"));
	            produto.setQtdEstoque(rs.getInt("qtd_estoque"));
	            return produto;
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao buscar produto", e);
	    }

	    return null;
			
	}
	
	public void deletar(int id) {

	    String sql = "DELETE FROM produto WHERE id = ?";

	    try (Connection conn = Conexao.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao deletar produto", e);
	    }
	}
	
	public void atualizar(Produto produto) {

	    String sql = "UPDATE produto SET nome = ?, preco = ?, qtd_estoque = ? WHERE id = ?";

	    try (Connection conn = Conexao.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, produto.getNome());
	        stmt.setDouble(2, produto.getPreco());
	        stmt.setInt(3, produto.getQtdEstoque());
	        stmt.setInt(4, produto.getId());

	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao atualizar produto", e);
	    }
	}
		
}
