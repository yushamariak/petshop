/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.modelo.dao;

import com.petshop.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yusha
 */
public class UsuarioDAO {
    
    private final Connection conexao;
    
    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public void gravar(Usuario contato) throws SQLException {
        String insercao = "INSERT INTO usuarios (login, senha) VALUES (?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, contato.getLogin());
            pstmt.setString(2, contato.getSenha());
            int resultado = pstmt.executeUpdate();
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    contato.setIdUsuario(rs.getInt(1));
                }
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A inserção não foi feita corretamente.");
            }
        }
    }

    public void remover(Usuario contato) throws SQLException {
        String remocao = "DELETE FROM usuarios WHERE idUsuario= ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
            pstmt.setLong(1, contato.getIdUsuario());
            int remocoes = pstmt.executeUpdate();
            if (remocoes == 1) {
                System.out.println("Remoção efetuada com sucesso.");
            } else {
                System.out.println("Não foi possível efetuar a remoção.");
            }
        }
    }

    public void atualizar(Usuario contato) throws SQLException {
        String alteracao = "UPDATE usuarios SET login = ?, senha = ? WHERE idUsuario = ?;";
        try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
            pstmt.setString(1, contato.getLogin());
            pstmt.setString(2, contato.getSenha());
            int alteracoes = pstmt.executeUpdate();
            if (alteracoes == 1) {
                System.out.println("\nAlteracao bem sucedida.");
            } else {
                System.out.println("A alteracao não foi feita corretamente.");
            }
        }
    }

   /* public Contato buscar(int idContato) throws SQLException {
        Contato contato = null;
        String selecao = "SELECT * FROM contato WHERE idContato = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setInt(1, idContato);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    contato = new Contato();
                    contato.setIdContato(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    contato.setEndereco(rs.getString(3));
                    contato.setTelefone(rs.getString(4));
                    contato.setEmail(rs.getString(5));
                }
            }
        }
        return contato;
    }

    public List<Contato> buscarTodos() throws SQLException {
        Contato contato;
        List<Contato> contatos = new ArrayList<>();
        String selecao = "SELECT * FROM contato";
        try (Statement stmt = conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                while (rs.next()) {
                    contato = new Contato();
                    contato.setIdContato(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    contato.setEndereco(rs.getString(3));
                    contato.setTelefone(rs.getString(4));
                    contato.setEmail(rs.getString(5));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }

    public List<Contato> buscarNome(String nome) throws SQLException {
        Contato contato;
        List<Contato> contatos = new ArrayList<>();
        String selecao = "SELECT * FROM contato WHERE nome LIKE ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    contato = new Contato();
                    contato.setIdContato(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    contato.setEndereco(rs.getString(3));
                    contato.setTelefone(rs.getString(4));
                    contato.setEmail(rs.getString(5));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }*/
    
}
