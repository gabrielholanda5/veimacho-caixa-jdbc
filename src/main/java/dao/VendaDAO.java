package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import connection.Conexao;
import model.Venda;

public class VendaDAO {
	
	
	public int inserir(Venda venda) {

        String sql = "INSERT INTO venda (data, valor_total) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            
            stmt.setTimestamp(1, Timestamp.valueOf(venda.getData()));
            stmt.setDouble(2, venda.getValorTotal());

            
            stmt.executeUpdate();

            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir venda", e);
        }

        return 0;
    }
	
	
	public Venda buscarPorId(int id) {

        String sql = "SELECT * FROM venda WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    Venda venda = new Venda();
                    venda.setId(rs.getInt("id"));
                    venda.setData(rs.getTimestamp("data").toLocalDateTime());
                    venda.setValorTotal(rs.getDouble("valor_total"));

                    return venda;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar venda", e);
        }

        return null;
    }
	
	public List<Venda> listarTodas() {

        List<Venda> vendas = new ArrayList<>();

        String sql = "SELECT * FROM venda";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setData(rs.getTimestamp("data").toLocalDateTime());
                venda.setValorTotal(rs.getDouble("valor_total"));

                vendas.add(venda);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendas", e);
        }

        return vendas;
    }
	
}
