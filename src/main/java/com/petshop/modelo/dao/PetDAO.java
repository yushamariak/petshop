package com.petshop.modelo.dao;

import com.petshop.modelo.Pet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PetDAO {

    private final Connection conexao;

    public PetDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void gravar(Pet pet) throws SQLException {
        String insercao = "INSERT INTO pets (nome, data_nascimento, sexo, raca, especie) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement pstmt = conexao.prepareStatement(insercao, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, pet.getNome());
            pstmt.setDate(2, Date.valueOf(pet.getData_nascimento()));
            pstmt.setString(3, pet.getSexo());
            pstmt.setString(4, pet.getRaca());
            pstmt.setString(5, pet.getEspecie());
            int resultado = pstmt.executeUpdate();
            if (resultado == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    pet.setIdPet(rs.getLong(1));
                }
                System.out.println("\nInserção bem sucedida.");
            } else {
                System.out.println("A inserção não foi feita corretamente.");
            }
        }
    }

    public Pet buscar(int idContato) throws SQLException {
        Pet contato = null;
        String selecao = "SELECT * FROM contato WHERE idContato = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setInt(1, idContato);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    contato = new Pet();
                    contato.setIdPet(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    //contato.setData_nascimento(rs.getString(3));
                    contato.setSexo(rs.getString(4));
                    contato.setRaca(rs.getString(5));
                    contato.setEspecie(rs.getString(6));
                }
            }
        }
        return contato;
    }

    public List<Pet> buscarTodos() throws SQLException {
        Pet contato;
        List<Pet> contatos = new ArrayList<>();
        String selecao = "SELECT * FROM pets";
        try (Statement stmt = conexao.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(selecao)) {
                while (rs.next()) {
                    contato = new Pet();
                    contato.setIdPet(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    //contato.setData_nascimento(rs.getString(3));
                    contato.setSexo(rs.getString(4));
                    contato.setRaca(rs.getString(5));
                    contato.setEspecie(rs.getString(6));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }

    public List<Pet> buscarNome(String nome) throws SQLException {
        Pet contato;
        List<Pet> contatos = new ArrayList<>();
        String selecao = "SELECT * FROM pets WHERE nome LIKE ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
            pstmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    
                    contato = new Pet();
                    contato.setIdPet(rs.getLong(1));
                    contato.setNome(rs.getString(2));
                    //contato.setData_nascimento(rs.getString(3));
                    contato.setSexo(rs.getString(4));
                    contato.setRaca(rs.getString(5));
                    contato.setEspecie(rs.getString(6));
                    contatos.add(contato);
                }
            }
        }
        return contatos;
    }

    public void remover(Pet contato) throws SQLException {
        String remocao = "DELETE FROM contato WHERE idPet = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
            pstmt.setLong(1, contato.getIdPet());
            int remocoes = pstmt.executeUpdate();
            if (remocoes == 1) {
                System.out.println("Remoção efetuada com sucesso.");
            } else {
                System.out.println("Não foi possível efetuar a remoção.");
            }
        }
    }

    public void atualizar(Pet pet) throws SQLException {
        String alteracao = "UPDATE pet SET nome = ?, data_nascimento = ?, sexo = ?, raca = ?,especie = ? WHERE idPet = ?;";
        try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
           pstmt.setString(1, pet.getNome());
            pstmt.setDate(2, Date.valueOf(pet.getData_nascimento()));
            pstmt.setString(3, pet.getSexo());
            pstmt.setString(4, pet.getRaca());
            pstmt.setString(5, pet.getEspecie());
            int alteracoes = pstmt.executeUpdate();
            if (alteracoes == 1) {
                System.out.println("\nAlteracao bem sucedida.");
            } else {
                System.out.println("A alteracao não foi feita corretamente.");
            }
        }
    }
}
