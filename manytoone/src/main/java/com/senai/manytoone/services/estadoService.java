/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senai.manytoone.services;

import com.senai.manytoone.dtos.estadoDto;
import com.senai.manytoone.model.estadoModel;
import com.senai.manytoone.repository.estadoRepository;
import java.time.LocalDate;
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
}
