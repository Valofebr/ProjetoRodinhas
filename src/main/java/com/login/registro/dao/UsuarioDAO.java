package com.login.registro.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.login.registro.model.Usuario;

import java.sql.Connection;

public class UsuarioDAO {
    public void inserir(Usuario contato) throws SQLException {
        String sql = "INSERT INTO contatos (nome, telefone, email) VALUES (?, ?, ?)";
        try (Connection conn = com.login.registro.Factory.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.executeUpdate();
        }
    }
    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contatos";
        try (Connection conn = com.login.registro.Factory.ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario contato = new Usuario();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                contatos.add(contato);
            }
        }
        return contatos;
    }
    public Usuario buscarPorId(int id) throws SQLException {
        Usuario contato = null;
        String sql = "SELECT * FROM contatos WHERE id = ?";
        try (Connection conn = com.login.registro.Factory.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    contato = new Usuario();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setTelefone(rs.getString("telefone"));
                    contato.setEmail(rs.getString("email"));
                }
            }
        }
        return contato;
    }
    public void atualizar(Usuario contato) throws SQLException {
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?";
        try (Connection conn = com.login.registro.Factory.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.setInt(4, contato.getId());
            stmt.executeUpdate();
        }
    }
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?";
        try (Connection conn = com.login.registro.Factory.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
