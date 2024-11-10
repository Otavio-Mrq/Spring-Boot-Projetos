package com.senai.ThymeLeaf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.envers.Audited;

@Entity
@Table(name="MUNICIPIO")
@Data
@Audited
public class municipioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_municipio")
    private long id;
    
    @Column(name="nomeMunicipio")
    private String nome;
    
    @ManyToOne
    @JoinColumn(name="id_estado")
    private estadoModel estado;

    public municipioModel() {
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
