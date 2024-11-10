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
}