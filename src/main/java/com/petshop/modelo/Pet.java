/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author yusha
 */
public class Pet {
    private long idPet;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String raca;
    private String especie;
    private int cliente_id;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.idPet ^ (this.idPet >>> 32));
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.data_nascimento);
        hash = 61 * hash + Objects.hashCode(this.sexo);
        hash = 61 * hash + Objects.hashCode(this.raca);
        hash = 61 * hash + Objects.hashCode(this.especie);
        hash = 61 * hash + this.cliente_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        if (this.idPet != other.idPet) {
            return false;
        }
        if (this.cliente_id != other.cliente_id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        if (!Objects.equals(this.data_nascimento, other.data_nascimento)) {
            return false;
        }
        return true;
    }

    public long getIdPet() {
        return idPet;
    }

    public void setIdPet(long idPet) {
        this.idPet = idPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
   
    @Override
    public String toString() {
        return "Pet{" + "idPet=" + idPet + ", nome=" + nome + ", data_nascimento=" + data_nascimento + ", sexo=" + sexo + ", raca=" + raca + ", especie=" + especie + ", cliente_id=" + cliente_id + '}';
    }

    
    
    
}
