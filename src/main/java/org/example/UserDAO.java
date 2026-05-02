package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection conexao;

    public UserDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(User user) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement("INSERT INTO users (nome, idade) VALUES (?, ?)");
        ps.setString(1, user.getNome());
        ps.setInt(2, user.getIdade());

        ps.executeUpdate();
        ps.close();
    }

    public List<User> listar() throws SQLException {
        List<User> lista = new ArrayList<>();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            User user = new User(rs.getString("nome"), rs.getInt("idade"));
            lista.add(user);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public int deletar(int id) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(
                "DELETE FROM user WHERE id = ?"
        );

        ps.setInt(1,id);

        int linhas = ps.executeUpdate();

        ps.close();
        return linhas;
    }

    public int atualizar(int id, String nome, int idade) throws SQLException {
        PreparedStatement ps = conexao.prepareStatement(
                "UPDATE users SET nome = ?, idade = ? WHERE id = ?"
        );
        ps.setString(1, nome);
        ps.setInt(2, idade);
        ps.setInt(3, id);

        int linhas = ps.executeUpdate();

        ps.close();
        return linhas;
    }
    
}