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
public class Funcionario {
    int cliente_id, usuario_id, idFuncionario;

    public Funcionario() {
    }

    public Funcionario(int cliente_id, int usuario_id, int idFuncionario) {
        this.cliente_id = cliente_id;
        this.usuario_id = usuario_id;
        this.idFuncionario = idFuncionario;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "cliente_id=" + cliente_id + ", usuario_id=" + usuario_id + ", idFuncionario=" + idFuncionario + '}';
    }      
}
