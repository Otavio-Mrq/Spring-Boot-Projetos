package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.municipioDto;
import com.senai.ThymeLeaf.services.municipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
            return "redirect:listausuarios";
        }

        return "redirect:cadastrarusuario?erro";        
    }
}
