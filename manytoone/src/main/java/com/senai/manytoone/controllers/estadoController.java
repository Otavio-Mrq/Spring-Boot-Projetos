package com.senai.manytoone.controllers;

import com.senai.manytoone.dtos.estadoDto;
import com.senai.manytoone.services.estadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            return "redirect:listausuarios";
        }

        return "redirect:cadastrarusuario?erro";        
    }
}
