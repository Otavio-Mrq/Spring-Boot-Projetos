/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.ThymeLeaf.services;

import com.senai.ThymeLeaf.dtos.estadoDto;
import com.senai.ThymeLeaf.models.estadoModel;
import com.senai.ThymeLeaf.repositories.estadoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estadoService {
    
    @Autowired
    estadoRepository repository;
    
    public boolean cadastrarContato(estadoDto cadastro){
        
        Optional<estadoModel> optionalUsuario = repository.findBySigla(cadastro.getSigla());
        
        if (optionalUsuario.isPresent()){
            return false;
        }
        
        estadoModel estado = new estadoModel();
        
        estado.setNome(cadastro.getNome());
        estado.setSigla(cadastro.getSigla().toUpperCase());
        
        repository.save(estado);
        
        return true;
    
        
    }
    public List<estadoDto> obterListaEstados(){

            List<estadoModel> listaEstadoModel = repository.findAll();

            List<estadoDto> listaEstados = new ArrayList();

            for (estadoModel estado : listaEstadoModel){

                estadoDto estadoDto = new estadoDto();
                estadoDto.setId(estado.getId() );
                estadoDto.setNome(estado.getNome());
                estadoDto.setSigla(estado.getSigla());

                listaEstados.add(estadoDto);
            }

            return listaEstados;

        }    
     public estadoDto obterEstado(Long id){
        
        Optional<estadoModel> optionalEstado = repository.findById(id);
        
        estadoDto estado = new estadoDto();
        
        if (!optionalEstado.isPresent()){            
            estado.setId(0L);
            return estado;
        }
        
        estado.setId(optionalEstado.get().getId());
        estado.setNome(optionalEstado.get().getNome());  
        estado.setSigla(optionalEstado.get().getSigla());

        
        return estado;
    }
         public boolean excluirEstado(Long id){
        
        System.out.println("id:" + id);
        
        Optional<estadoModel> optionalUsuario = repository.findById(id);
        
        if (!optionalUsuario.isPresent()){
            return false;
        }
        
        repository.delete(optionalUsuario.get());
        
        return true;
        
    }
}
