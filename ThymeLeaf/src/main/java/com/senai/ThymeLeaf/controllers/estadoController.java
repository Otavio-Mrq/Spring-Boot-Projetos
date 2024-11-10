package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.estadoDto;
import com.senai.ThymeLeaf.services.estadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estado")
public class estadoController {
    
    @Autowired
    estadoService service;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("estado") estadoDto cadastro){
        
        boolean sucesso = service.cadastrarContato(cadastro);
        
        if (sucesso){
            return "redirect:listaEstados";
        }

        return "redirect:cadastroEstado?erro";        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirUsuario(@PathVariable Long id){
    
        boolean sucesso = service.excluirEstado(id);
        
        if (sucesso){
            return ResponseEntity.ok("Usuário excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir usuário.");
        
    }
}
