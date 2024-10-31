package com.senai.manytoone.services;

import com.senai.manytoone.dtos.estadoDto;
import com.senai.manytoone.dtos.municipioDto;
import com.senai.manytoone.model.estadoModel;
import com.senai.manytoone.model.municipioModel;
import com.senai.manytoone.repository.municipioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class municipioService {
    
    @Autowired
    municipioRepository repository;
    
     public boolean cadastrarContato(municipioDto cadastro){
        
        Optional<municipioModel> optionalMunicipio = repository.findByNome(cadastro.getNome());
        
        if (optionalMunicipio.isPresent()){
            return false;
        }
        
        municipioModel municipio = new municipioModel();
        
        municipio.setNome(cadastro.getNome());
        municipio.setEstado(cadastro.getEstado());
        
        repository.save(municipio);
        
        return true;
    }
}
