package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pedidoDAO {
    private Connection conexao;

    public pedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public int inserir(Pedido pedido) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement("""
                    INSERT INTO pedidos (user_id, produto_id, quantidade) VALUES(?, ?,?)
                """);

        ps.setInt(1, pedido.getUserId());
        ps.setInt(2, pedido.getProdutoId());
        ps.setInt(3, pedido.getQuantidade());


        ps.executeUpdate();
        ps.close();

        return 0;
    }

}
