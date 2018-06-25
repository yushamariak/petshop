/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.modelo.dao;

import com.petshop.modelo.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yusha
 */
public class ServicoDAO {
    private final Connection conexao;
    
    public ServicoDAO(Connection conexao) {
        this.conexao = conexao;
    }
        
    public void gravar(int idPet, int idServico, int idFuncionario, String data_atendimento) throws SQLException {
        String insercao = "INSERT INTO pets_funcionarios (pet_id, funcionario_id, data_atendimento, servico_id) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idPet);
            pstmt.setInt(2, idFuncionario);
            pstmt.setString(3, data_atendimento);
            pstmt.setInt(4, idServico);
            int resultado = pstmt.executeUpdate();
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                   // contato.setIdServico(rs.getInt(1));
                }
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A inserção não foi feita corretamente.");
            }
        }
    }

    
    public List<Servico> buscarTodos() throws SQLException {
        Servico contato;
        List<Servico> contatos = new ArrayList<>();
        String selecao = "SELECT * FROM servicos";
        try (Statement stmt = conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                while (rs.next()) {
                    contato = new Servico();
                    contato.setIdServico(rs.getInt(1));
                    contato.setDescricao(rs.getString(2));
                    contato.setValor(rs.getDouble(3));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }

}
