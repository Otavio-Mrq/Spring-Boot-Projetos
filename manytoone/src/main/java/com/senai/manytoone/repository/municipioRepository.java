package com.senai.manytoone.repository;

import com.senai.manytoone.model.municipioModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface municipioRepository extends JpaRepository<municipioModel, Long>{
    
    public Optional<municipioModel> findByNome(String nome);
    
}
