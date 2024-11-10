package com.senai.ThymeLeaf.repositories;


import com.senai.ThymeLeaf.models.estadoModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface estadoRepository extends JpaRepository<estadoModel, Long>{
    
    public Optional<estadoModel> findBySigla(String sigla);
    
}
