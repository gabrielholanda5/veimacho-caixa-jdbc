package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.ItemVenda;

public class ItemVendaDAO {
	
	public void inserir(ItemVenda item) {

        String sql = "INSERT INTO item_venda (venda_id, produto_id, quantidade, preco_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getVendaId());
            stmt.setInt(2, item.getProdutoId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setDouble(4, item.getPrecoUnitario());
            stmt.setDouble(5, item.getSubtotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir item da venda", e);
        }
    }
	
	public ItemVenda buscarPorId(int id) {

        String sql = "SELECT * FROM item_venda WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    ItemVenda item = new ItemVenda();
                    item.setId(rs.getInt("id"));
                    item.setVendaId(rs.getInt("venda_id"));
                    item.setProdutoId(rs.getInt("produto_id"));
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                    item.setSubtotal(rs.getDouble("subtotal"));

                    return item;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar item da venda", e);
        }

        return null;
    }
	
	public List<ItemVenda> listarPorVendaId(int vendaId) {

        List<ItemVenda> lista = new ArrayList<>();

        String sql = "SELECT * FROM item_venda WHERE venda_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vendaId);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {

                    ItemVenda item = new ItemVenda();
                    item.setId(rs.getInt("id"));
                    item.setVendaId(rs.getInt("venda_id"));
                    item.setProdutoId(rs.getInt("produto_id"));
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPrecoUnitario(rs.getDouble("preco_unitario"));
                    item.setSubtotal(rs.getDouble("subtotal"));

                    lista.add(item);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar itens da venda", e);
        }

        return lista;
    }
	
}
