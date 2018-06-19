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
public class Servico {
    int idServico;
    String descricao;
    double valor;

    public Servico() {
    }

    public Servico(int idServico, String descricao, double valor) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Servico{" + "idServico=" + idServico + ", descricao=" + descricao + ", valor=" + valor + '}';
    }
}
