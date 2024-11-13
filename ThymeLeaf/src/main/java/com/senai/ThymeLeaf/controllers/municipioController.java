package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.municipioDto;
import com.senai.ThymeLeaf.services.municipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/municipio")
public class municipioController {
    
    @Autowired
    municipioService service;
    
    @PostMapping()
    public String cadastrarUsuario(@ModelAttribute("municipio") municipioDto cadastro){
        
        boolean sucesso = service.cadastrarContato(cadastro);
        
        if (sucesso){
            return "redirect:listaMunicipios";
        }

        return "redirect:cadastrao?erro";        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>  excluirContato(@PathVariable Long id){
    
        boolean sucesso = service.excluirMunicipio(id);
        
        if (sucesso){
            return ResponseEntity.ok("Contato excluído com sucesso.");
        }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir Contato.");
        
    }
    
    @PostMapping("/{id}")
    public String atualizarContato(@ModelAttribute("contato") @PathVariable Long id, municipioDto atualizar){
        
        boolean sucesso = service.atualizarMunicipio(id,atualizar);
        
        if(sucesso){
            return "redirect:listacontato";
        }
        return "redirect:listacontato?erro";
    }
}
