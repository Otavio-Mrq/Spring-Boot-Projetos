package com.senai.ThymeLeaf.repositories;

import com.senai.ThymeLeaf.models.municipioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface municipioRepository extends JpaRepository<municipioModel, Long>{
    
    public Optional<municipioModel> findByNome(String nome);
    
}
