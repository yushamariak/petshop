/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.modelo;

/**
 *
 * @author yusha
 */
public class Papel {
    int idPapel;
    String nome, descricao;

    public Papel() {
    }

    public Papel(int idPapel, String nome, String descricao) {
        this.idPapel = idPapel;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(int idPapel) {
        this.idPapel = idPapel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Papel{" + "idPapel=" + idPapel + ", nome=" + nome + ", descricao=" + descricao + '}';
    }

}
