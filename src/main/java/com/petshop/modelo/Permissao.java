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
public class Permissao {
    String valor, descricao;
    int idPermissao;

    public Permissao() {
    }

    public Permissao(String valor, String descricao, int idPermissao) {
        this.valor = valor;
        this.descricao = descricao;
        this.idPermissao = idPermissao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }

    @Override
    public String toString() {
        return "Permissao{" + "valor=" + valor + ", descricao=" + descricao + ", idPermissao=" + idPermissao + '}';
    }
    
}
