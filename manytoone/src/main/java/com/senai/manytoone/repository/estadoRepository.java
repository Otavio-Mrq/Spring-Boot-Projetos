package com.senai.manytoone.repository;

import com.senai.manytoone.model.estadoModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface estadoRepository extends JpaRepository<estadoModel, Long>{
    
    public Optional<estadoModel> findBySigla(String sigla);
    
}
