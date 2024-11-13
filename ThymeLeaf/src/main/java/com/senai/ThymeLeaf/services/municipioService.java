package com.senai.ThymeLeaf.services;

import com.senai.ThymeLeaf.dtos.municipioDto;
import com.senai.ThymeLeaf.models.municipioModel;
import com.senai.ThymeLeaf.repositories.municipioRepository;
import java.util.ArrayList;
import java.util.List;
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
      public List<municipioDto> obterListaMunicipios(){

            List<municipioModel> listaMunicipioModel = repository.findAll();

            List<municipioDto> listaMunicipio = new ArrayList();

            for (municipioModel municipio : listaMunicipioModel){

                municipioDto municipiodto = new municipioDto();
                municipiodto.setId(municipio.getId() );
                municipiodto.setNome(municipio.getNome());
                municipiodto.setEstado(municipio.getEstado());

                listaMunicipio.add(municipiodto);
            }

            return listaMunicipio;

        }
      
      public municipioDto obterMunicipio(Long id){
        
        Optional<municipioModel> optionalEstado = repository.findById(id);
        
        municipioDto estado = new municipioDto();
        
        if (!optionalEstado.isPresent()){            
            estado.setId(0L);
            return estado;
        }
        
        estado.setId(optionalEstado.get().getId());
        estado.setNome(optionalEstado.get().getNome());  
        estado.setEstado(optionalEstado.get().getEstado());

        
        return estado;
    }
         public boolean excluirMunicipio(Long id){
        
        System.out.println("id:" + id);
        
        Optional<municipioModel> optionalMunicipio= repository.findById(id);
        
        if (!optionalMunicipio.isPresent()){
            return false;
        }
        
        repository.delete(optionalMunicipio.get());
        
        return true;
        
    }
         
        public boolean atualizarMunicipio(Long id, municipioDto dados){
        
         Optional<municipioModel> optionalMunicipio = repository.findById(id);
         
         if(!optionalMunicipio.isPresent()){
             return false;
         }
         
         municipioModel municipio = optionalMunicipio.get();
         municipio.setId(dados.getId());
         municipio.setNome(dados.getNome());
         municipio.setEstado(dados.getEstado());
         
         
         repository.save(municipio);
                 
        return true;
    } 
}
