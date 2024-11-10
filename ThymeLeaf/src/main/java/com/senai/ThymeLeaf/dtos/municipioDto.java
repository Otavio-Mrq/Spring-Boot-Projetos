package com.senai.ThymeLeaf.dtos;

import com.senai.ThymeLeaf.models.estadoModel;

public class municipioDto {
    
    private long id;
    
    private String nome;
    
    private estadoModel estado;

    public municipioDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public estadoModel getEstado() {
        return estado;
    }

    public void setEstado(estadoModel estado) {
        this.estado = estado;
    }
    
    
}
